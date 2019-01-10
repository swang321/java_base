package socket;

import java.io.*;
import java.net.Socket;

/**
 * @Date: 2019/1/9 10:52
 * @Description:
 * @Author admin
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {

        String serverName = args[0];
        int port = Integer.parseInt(args[1]);

        System.out.println("主机名: " + serverName + "端口号: " + port);
        Socket client = new Socket(serverName, port);
        System.out.println("远程主机地址：" + client.getRemoteSocketAddress());

        OutputStream outToServer = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);
        out.writeUTF("helllo from" + client.getLocalSocketAddress());

        InputStream inFromServer = client.getInputStream();
        DataInputStream in = new DataInputStream(inFromServer);
        System.out.println("服务器响应： " + in.readUTF());


    }

}
