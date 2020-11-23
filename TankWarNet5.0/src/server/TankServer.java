package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:yangwlz
 * @Date: 9:55 : 2020/11/10
 * @Description: server
 * @version: 1.0
 */
public class TankServer {
    public static final int TCP_PORT = 8888;
    public static final int UDP_PORT = 6666;               //监听在UDP的6666端口

    List<Client> clients = new ArrayList<>();
    static int ID = 100;

    public static void main(String[] args) {
        new TankServer().init();
    }

    public void init() {
        new Thread(new UDPThread()).start();              //UDP监听的线程启动

        ServerSocket ss = null;
        Socket s = null;
        try {
            ss = new ServerSocket(TCP_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){
            try {
                s = ss.accept();
//System.out.println("有1客户端连接上来,IP= " +s.getInetAddress().getHostAddress() +", 客户端的TCP端口= "+ s.getPort());

                DataInputStream dis = new DataInputStream(s.getInputStream());
                String IP = s.getInetAddress().getHostAddress();
                int clientUdpPort = dis.readInt();                                   //读到客户端的UDP port
                Client c = new Client(IP, clientUdpPort);
                clients.add(c);
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                dos.writeInt(ID++);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    class Client {
        String ip;
        int clientUdpPort;

        public Client(String ip, int clientUdpPort) {
            this.ip = ip;
            this.clientUdpPort = clientUdpPort;
        }
    }


    //TCP连接好后，启动UDP线程接收从客户端发送过来的UDP包
    //Udp线程用来接收客户端发送过来的UDP数据包，并转发给其它的客户端
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
System.out.println("服务器端UDP监听启动，UDP_PORT= " + UDP_PORT);
            //接收客户端发送过来的UDP接口
            while (ds != null) {
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                try {
                    //拿到客户端发送过来的UDP数据包
                    ds.receive(dp);

                    //转发给队友
                    for (int i = 0; i < clients.size(); i++) {
                        Client c = clients.get(i);
                        dp.setSocketAddress(new InetSocketAddress(c.ip, c.clientUdpPort));
                        ds.send(dp);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
