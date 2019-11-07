package io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 伪异步I/O模型 服务端
 *
 * @Author whh
 */
public class BioSocketServerThreadPool {

    private static int DEFAULT_PORT = 8083;

    /**
     * 线程池 饿汉式单利
     */
    private static ExecutorService executorService = Executors.newFixedThreadPool(23);

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = null;
        try {
            System.out.println("监听来自于" + DEFAULT_PORT + "的端口信息");
            serverSocket = new ServerSocket(DEFAULT_PORT);
            Socket socket = serverSocket.accept();
            //当然业务处理过程可以交给一个线程（这里可以使用线程池）,并且线程的创建是很耗资源的。
            //最终改变不了.accept()只能一个一个接受socket的情况,并且被阻塞的情况
            SocketServerThreadPool socketServerThreadPool = new SocketServerThreadPool(socket);
            executorService.execute(socketServerThreadPool);
        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }

        synchronized (BioSocketServerThreadPool.class) {
            BioSocketServerThreadPool.class.wait();
        }
    }

}

class SocketServerThreadPool implements Runnable {

    private Socket socket;

    public SocketServerThreadPool(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        InputStream in = null;
        OutputStream out = null;

        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();

            int port = socket.getPort();
            int maxLen = 1024;
            byte[] bytes = new byte[maxLen];

            //使用线程，同样无法解决read方法的阻塞问题，
            //也就是说read方法处同样会被阻塞，直到操作系统有数据准备好
            int realLen = in.read(bytes, 0, maxLen);
            String message = new String(bytes, 0, realLen);

            //下面打印信息
            System.out.println("服务器收到来自于端口：" + port + "的信息：" + message);

            //下面开始发送信息
            out.write("回发响应信息--！".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 试图关闭
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (this.socket != null) {
                    this.socket.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


    }
}