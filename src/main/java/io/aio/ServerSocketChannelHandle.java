package io.aio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 这个处理器 专门用来响应 server socket channel 的事件，
 * server socket channel 只有一件事，接受客户端的连接
 *
 * @Author whh
 */
public class ServerSocketChannelHandle implements CompletionHandler<AsynchronousSocketChannel, Void> {

    private static final Log log = LogFactory.getLog(ServerSocketChannelHandle.class);

    private AsynchronousServerSocketChannel serverSocketChannel;

    public ServerSocketChannelHandle(AsynchronousServerSocketChannel serverSocketChannel) {
        this.serverSocketChannel = serverSocketChannel;
    }

    @Override
    public void completed(AsynchronousSocketChannel result, Void attachment) {
        log.info("completed(AsynchronousServerSocketChannel result,ByteBuffer attachment)");
        // 每次都需要重新注册监听（一次注册一次响应）但是由于 文件状态标识符 时独享的 所以不需要担心漏掉的事件
        this.serverSocketChannel.accept(attachment, this);

    }

    @Override
    public void failed(Throwable exc, Void attachment) {

    }
}
