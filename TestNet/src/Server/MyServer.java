package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther:yangwlz
 * @Date: 15:58 : 2020/11/10
 * @Description: Server
 * @version: 1.0
 */
public class MyServer {
    public static final int TCP_PORT = 8989;
    public static final int UDP_PORT = 2232;

    public void start() {
        ServerSocket ss = null;
        Socket s = null;
        try {
            ss = new ServerSocket(TCP_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {
            try {
                s = ss.accept();
System.out.println("有客户端连接上来");
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeUTF("服务器");

                DataInputStream dis = new DataInputStream(s.getInputStream());
                int i = dis.readInt();
  System.out.println("客户端的指令= " + i);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
            new MyServer().start();
    }
}
