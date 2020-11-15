package client;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @Auther:yangwlz
 * @Date: 23:23 : 2020/11/14
 * @Description: client
 * @version: 1.0
 */
public class MissileDeadMsg implements Msg{
    int tankId;
    int msgType = Msg.MISSILE_DEAD_MSG;
    int id;
    TankPanel tp;

    public MissileDeadMsg(int tankId, int id) {
        this.id = id;
        this.tankId = tankId;
    }

    public MissileDeadMsg(TankPanel tp) {
        this.tp = tp;
    }

    @Override
    public void send(DatagramSocket ds, String IP, int udpPort) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeInt(msgType);
            dos.writeInt(tankId);
            dos.writeInt(id);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //上面已经将信息写入到字符数组中
        //将字符数组  打包
        //通过流 发送出去

        byte[] buf = baos.toByteArray();      //新分配字节数组
        //打包，DatagramPacket
        DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress(IP, udpPort));
        try {
            //通过DatagramSocket发送出去
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void parse(DataInputStream dis) {
        try {
            int tankId = dis.readInt();
            int id = dis.readInt();
            for (int i = 0; i < tp.missileList.size(); i++) {
                Missile m = tp.missileList.get(i);
                if(m.tankId == tankId && m.id == id) {
                   m.isLive = false;
                   break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
