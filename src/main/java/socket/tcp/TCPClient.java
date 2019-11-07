package socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author whh  2019/10/18 15:45
 */
public class TCPClient {

    private static int port = 8899;
    ;

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", port);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        String message = getSayHelloMessage("whh", socket, inputStream, outputStream);
        System.out.println(message);

    }

    private static String getSayHelloMessage(String name, Socket socket, InputStream inputStream, OutputStream outputStream) throws IOException {

        outputStream.write(name.getBytes());
        socket.shutdownOutput();
        StringBuilder result = new StringBuilder();
        byte[] buffer = new byte[1024];
        int length;
        while (-1 != (length = inputStream.read(buffer))) {
            result.append(new String(buffer, 0, length));
        }
        return result.toString();
    }

}
