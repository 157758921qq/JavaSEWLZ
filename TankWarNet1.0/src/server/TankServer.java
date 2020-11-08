package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

/**
 * @Auther:yangwlz
 * @Date: 11:27 : 2020/11/7
 * @Description: server
 * @version: 1.0
 */
public class TankServer {
    static int ID = 100;
    public static final int TCP_PORT = 8888;
    public static final int UDP_PORT = 6666;

    java.util.List<Client> clients = new ArrayList<>();

    public void init() {
        new Thread(new UDPThread()).start();

        ServerSocket ss = null;
        try {
            ss = new ServerSocket(TCP_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            Socket s = null;
            try {
                s = ss.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                int udpPort = dis.readInt();
                String ip = s.getInetAddress().getHostAddress();

                Client c = new Client(ip, udpPort);
                clients.add(c);

                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeInt(ID++);

                s.close();
                System.out.println("客户端连接上来： " + s.getInetAddress() + " : " + s.getPort() +"UDP_PORT"+ udpPort);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(s != null) {
                    try {
                        s.close();
                        s = null;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

        }
    }

    public static void main(String[] args) {
        new TankServer().init();

    }

    //每个client连接上来后，都需要在server端保存
    class Client {
        String ip;
        int udpPort;

        public Client(String ip, int udpPort) {
            this.ip = ip;
            this.udpPort = udpPort;
        }
    }

    class UDPThread implements Runnable {
        byte[] buf = new byte[1024];

        @Override
        public void run() {
            DatagramSocket ds = null;
            try {
                 ds = new DatagramSocket(UDP_PORT);
            } catch (SocketException e) {
                e.printStackTrace();
            }

 System.out.println("UDP线程已经启动，UDP端口：" + UDP_PORT);

            while(ds != null) {
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                try {
                    ds.receive(dp);
                    System.out.println("收到udp包");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
