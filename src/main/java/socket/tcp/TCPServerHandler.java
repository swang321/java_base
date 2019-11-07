package socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author whh  2019/10/18 15:38
 */
public class TCPServerHandler implements Runnable {

    private Socket socket;

    public TCPServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        sayHello(socket);

    }

    private void sayHello(Socket socket) {
        StringBuilder message = new StringBuilder("hello");
        byte[] buffer = new byte[1024];
        int length;
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            while (-1 != (length = inputStream.read(buffer))) {
                String s = new String(buffer, 0, length);
                message.append(s);
            }
            outputStream.write(message.toString().getBytes());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
