package io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.concurrent.CountDownLatch;

/**
 * bio 客户端
 *
 * @Author whh
 */
public class BioSocketClient {

    public static void main(String[] args) throws InterruptedException {

        int clientSocket = 20;
        CountDownLatch countDownLatch = new CountDownLatch(clientSocket);

        for (int i = 0; i < clientSocket; i++, countDownLatch.countDown()) {

            ClientRequestThread client = new ClientRequestThread(countDownLatch, i);
            new Thread(client).start();
        }
        //这个wait不涉及到具体的实验逻辑，只是为了保证守护线程在启动所有线程后，进入等待状态
        synchronized (BioSocketClient.class) {
            BioSocketClient.class.wait();
        }

    }
}

class ClientRequestThread implements Runnable {

    /**
     * countDownLatch是java提供的同步计数器。
     * 当计数器数值减为0时，所有受其影响而等待的线程将会被激活。这样保证模拟并发请求的真实性
     */
    private CountDownLatch countDownLatch;

    private Integer index;

    public ClientRequestThread(CountDownLatch countDownLatch, int index) {
        this.countDownLatch = countDownLatch;
        this.index = index;
    }

    @Override
    public void run() {
        OutputStream out = null;
        InputStream in = null;
        try {
            Socket socket = new Socket("localhost", 8083);
            out = socket.getOutputStream();
            in = socket.getInputStream();

            // 等待所有得线程启动 ，然后所有得线程 一起发送请求  模拟并发
            this.countDownLatch.await();

            //发送请求信息
            out.write(("这是第" + this.index + " 个客户端的请求。 over").getBytes());
            out.flush();

            //在这里等待，直到服务器返回信息
            System.out.println("第" + this.index + "个客户端的请求发送完成，等待服务器返回信息");

            int maxLen = 1024;
            byte[] bytes = new byte[maxLen];
            int realLen;
            int read = in.read(bytes, 0, maxLen);
            String message = "";
            while ((realLen = read) != -1) {
                message += (new String(bytes, 0, realLen));
            }
            message = URLDecoder.decode(message, "UTF-8");
            System.out.println("第" + this.index + "个客户端接收到来自服务器的信息:" + message);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }
}
