package socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author whh  2019/10/18 15:34
 */
public class TCPServer {

    private static volatile boolean stopped;

    private static int port = 8899;

    public static void main(String[] args) throws IOException {

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

        ServerSocket serverSocket = new ServerSocket(port);

        while (!stopped) {
            Socket socket = serverSocket.accept();
            service.submit(new TCPServerHandler(socket));
        }
    }

    public static void stop() {
        stopped = true;
    }

}
