package io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * bio服务端
 *
 * @Author whh
 */
public class BioSocketServer {

    private static int DEFAULT_PORT = 8083;

    public static void main(String[] args) throws InterruptedException {
        ServerSocket serverSocket = null;
        try {
            System.out.println("监听来自于"+DEFAULT_PORT+"的端口信息");
            serverSocket = new ServerSocket(DEFAULT_PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                SocketServerThread socketServerThread = new SocketServerThread(socket);
                new Thread(socketServerThread).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.getMessage();
            }

        }
        //这个wait不涉及到具体的实验逻辑，只是为了保证守护线程在启动所有线程后，进入等待状态
        synchronized (BioSocketServer.class) {
            BioSocketServer.class.wait();
        }
    }
}

class SocketServerThread implements Runnable {

    private Socket socket;

    public SocketServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            // 接受消息
            in = socket.getInputStream();
            out = socket.getOutputStream();
            int port = socket.getPort();
            int maxLen = 1024;
            byte[] contentBytes = new byte[maxLen];

            //使用线程，同样无法解决read方法的阻塞问题，
            //也就是说read方法处同样会被阻塞，直到操作系统有数据准备好
            int read = in.read(contentBytes, 0, maxLen);
            //读取信息
            String message = new String(contentBytes, 0, read);

            System.out.println("服务器收到来自于端口：" + port + "的信息：" + message);
            // 下面开始发送信息
            out.write("回发响应信息！".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
                if (this.socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
