package io.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * nio 多路复用 io
 *
 * @Author whh
 */
public class NioSocketServer {

    private static final Logger log = LoggerFactory.getLogger(NioSocketServer.class);

    public static void main(String[] args) throws IOException {

        //  打开服务器套接字通道
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        // false 设置非阻塞模式
        socketChannel.configureBlocking(false);
        // 获取通道关联的服务器套接字
        ServerSocket serverSocket = socketChannel.socket();
        //   启用/禁用 SO_REUSEADDR 套接字选项。
        serverSocket.setReuseAddress(true);
        serverSocket.bind(new InetSocketAddress(8083));

        //打开选择器
        Selector selector = Selector.open();
        //  注意、服务器通道只能注册SelectionKey.OP_ACCEPT事件
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);

        try {
            // 如果条件成立，说明本次 询问 selector 并没有获取的任何准备好，感兴趣的事件
            // Java程序对多路复用 io 的支持又 阻塞 和非阻塞 模式
            while (true) {
                // 返回键数，可能为零，  其就绪操作集已更新
                if (selector.select(100) == 0) {
                    //   这里视业务情况
                    System.out.println("100次还没有发现感兴趣的事");
                    continue;
                }
                //这里就是本次询问操作系统，所获取到的“所关心的事件”的事件类型（每一个通道都是独立的）
                Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
                while (selectionKeys.hasNext()) {
                    SelectionKey readyKey = selectionKeys.next();
                    // 这个 已经处理的 readyKey一定要移除，如果不溢出就会一直存在 selector.selectKeys集合中
                    // 待 下一次 selector.select()>0 这个readyKey 又会被处理一次
                    selectionKeys.remove();
                    SelectableChannel selectableChannel = readyKey.channel();

                    if (readyKey.isValid() && readyKey.isAcceptable()) {
                        NioSocketServer.log.info("======channel通道已经准备好=======");
                        // 当 server socket channel 通道已经准备好，就可以从 server socket channel 中获取 socket channel
                        // 拿到 socket channel 要做的事情就是马上到 selector 注册这个 socket channel 感兴趣得事情
                        // 否则无法监听到这个 socket channel 到达得数据

                        //获取这个键得通道
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectableChannel;
                        //接受与此频道的套接字建立的连接
                        SocketChannel regSocketChannel = serverSocketChannel.accept();
                        registerSocketChannel(regSocketChannel, selector);
                    } else if (readyKey.isValid() && readyKey.isConnectable()) {
                        NioSocketServer.log.info("======socket channel 建立连接=======");
                    } else if (readyKey.isValid() && readyKey.isReadable()) {
                        NioSocketServer.log.info("======socket channel 数据准备完成，可以去读==读取=======");
                        readSocketChannel(readyKey);
                    }
                }
            }
        } catch (Exception e) {
            NioSocketServer.log.error(e.getMessage());
        } finally {
            serverSocket.close();
        }
    }

    /**
     * 读取从客户端传来得信息 并且观察客户端传来的 socket channel 在经过多次传输后  是否完成传输
     * 如果传输完成返回一个 true 标记
     */
    private static void readSocketChannel(SelectionKey readyKey) throws IOException {
        SocketChannel clientSocketChannel = (SocketChannel) readyKey.channel();

        //获取客户端使用的端口
        InetSocketAddress sourceSocketAddress = (InetSocketAddress) clientSocketChannel.getRemoteAddress();
        int port = sourceSocketAddress.getPort();

        // 拿到这个 socket channel 使用的缓存区  准备读数据
        ByteBuffer contextBytes = (ByteBuffer) readyKey.attachment();
        //将通道的数据写入到缓存区 之前设置 ByteBuffer 是2048  可能会出项写入不完的情况  这个根据业务 或者看情况调整
        int realLen = -1;
        try {
            realLen = clientSocketChannel.read(contextBytes);
        } catch (Exception e) {
            //这里抛出了异常，一般就是客户端因为某种原因终止了。所以关闭channel就行了
            NioSocketServer.log.error(e.getMessage());
            clientSocketChannel.close();
            return;
        }

        // 如果缓冲区中没有任何数据 但实际不太可鞥 否则就不会出发 op_read 事件了
        if (realLen == -1) {
            NioSocketServer.log.warn("====缓存区没有数据？====");
            return;
        }
        // 将缓冲区从写状态切换为读状态（读写模式切换）
        // Java nio 框架中的 这个 socket channel 的写请求将全部等待
        contextBytes.flip();
        //读取信息
        byte[] bytes = contextBytes.array();
        String message = new String(bytes, StandardCharsets.UTF_8);

        if (message.contains("over")) {
            // 清空已读读取的缓存
            contextBytes.clear();
        }


    }

    /**
     * 在 server socket channel 接受到一个新的 TCP 连接后就会向程序返回一个新的 socketChannel
     * 新 socket channel 没有在 selector 中注册  所以程序还没有办法 通过 selector 通知这个 socket channel 得事件
     * 我们拿到新的 socket channel 后 第一个事情就是向 selector 中注册 这个 socket channel 感兴趣得事情
     */
    private static void registerSocketChannel(SocketChannel regSocketChannel, Selector selector) throws IOException {
        regSocketChannel.configureBlocking(false);
        regSocketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(2048));
    }

}
















