package Client;

import Server.MyServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Auther:yangwlz
 * @Date: 16:03 : 2020/11/10
 * @Description: Client
 * @version: 1.0
 */
public class Client {

    String IP = "127.0.0.1";

    public void init() {
        Socket s = null;
        try {
             s = new Socket(IP, MyServer.TCP_PORT);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = dis.readUTF();
System.out.println("服务器端给的口令是= " + str);

            if(str.equals("服务器")) {
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeInt(88);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Client().init();

    }
}
