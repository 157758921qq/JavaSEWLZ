package client;

import server.TankServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * @Auther:yangwlz
 * @Date: 11:31 : 2020/11/7
 * @Description: client
 * @version: 1.0
 */
public class NetClient {
    static int UDP_PORT_START = 2223;
    int udpPort ;
    TankPanel tp;

    DatagramSocket ds;

    public NetClient(TankPanel tp) {
        udpPort = UDP_PORT_START ++;
        this.tp = tp;
        try {
            this.ds = new DatagramSocket(udpPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void connect(String IP, int PORT) {
        Socket s = null;
        try {
            s = new Socket(IP, PORT);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeInt(udpPort);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            int id = dis.readInt();
            this.tp.tank.id = id;
            System.out.println("连接上服务器, 服务器给我分配的ID= " + id);
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



        TankNewMsg msg = new TankNewMsg(tp.tank);
        send(msg);

    }

    public void send(TankNewMsg msg) {
        msg.send(ds, "127.0.0.1", TankServer.UDP_PORT);
    }
}
