package client;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @Auther:yangwlz
 * @Date: 12:52 : 2020/11/7
 * @Description: client
 * @version: 1.0
 */
public class TankNewMsg {
    Tank t;
    public TankNewMsg(Tank tank) {
        this.t = tank;
    }


    public void send(DatagramSocket ds, String IP, int udpPort) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeInt(t.id);
            dos.writeInt(t.x);
            dos.writeInt(t.y);
            dos.writeInt(t.dir.ordinal());
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] buf = baos.toByteArray();
        DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress(IP,udpPort));
        try {
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
