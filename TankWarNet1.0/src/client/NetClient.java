package client;

import server.TankServer;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * @Auther:yangwlz
 * @Date: 9:59 : 2020/11/10
 * @Description: client
 * @version: 1.0
 */
public class NetClient {
    TankPanel tp;
    public static int UDP_PORT = 2220;

    int udpPort;
    DatagramSocket ds = null;

    public NetClient(TankPanel tp) {
        this.tp = tp;
        udpPort = UDP_PORT++;
        try {
            ds = new DatagramSocket(udpPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void connect(String ip, int tcpPort) {
        Socket s = null;
        try {
            s = new Socket(ip, tcpPort);
System.out.println("我连接上了Server端");
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeInt(udpPort);       //将自己的UDP port发送给服务器

            DataInputStream dis = new DataInputStream(s.getInputStream());
            int ID = dis.readInt();
            this.tp.tank.id = ID;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(s != null){
                try {
                    s.close();
                    s = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        TankNewMsg newMsg = new TankNewMsg(tp.tank);
        this.send(newMsg);

        new Thread(new UDPRecvThread()).start();
    }

    private void send(TankNewMsg newMsg) {
        newMsg.send(ds, "127.0.0.1", TankServer.UDP_PORT);                     //给服务器发送UDP数据包
    }





    //起一UDP线程用来接收从服务转发过来的UDP数据包
    class UDPRecvThread implements Runnable {
        byte[] buf = new byte[1024*5];

        @Override
        public void run() {
            while(ds != null ) {
                DatagramPacket dp = new DatagramPacket(buf,buf.length);
                try {
                    ds.receive(dp);
                    //接收到服务器端转发的UDP报文，进行解析
                    parse(dp);
System.out.println("从服务器接收到转发过来的UDP数据包");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        private void parse(DatagramPacket dp) {
            ByteArrayInputStream bais = new ByteArrayInputStream(buf, 0, dp.getLength());
            DataInputStream dis = new DataInputStream(bais);
            TankNewMsg newMsg = new TankNewMsg(NetClient.this.tp);
            newMsg.parse(dis);
        }
    }
}
