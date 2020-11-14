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
 * @Date: 22:07 : 2020/11/14
 * @Description: client
 * @version: 1.0
 */
public class MissileNewMsg implements Msg {
    int msgType = Msg.MISSILE_NEW_MSG;
    Missile m;
    TankPanel tp;

    public MissileNewMsg(Missile m) {
        this.m = m;
    }

    public MissileNewMsg(TankPanel tp) {
        this.tp = tp;
    }

    @Override
    public void send(DatagramSocket ds, String IP, int udpPort) {
        //数据有了后存放在内存中(具体在字节数组中)，通过字节数组流输出，
        //流输出后就到了Client端，  Clinet端接收数据包
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeInt(msgType);
            dos.writeInt(m.tankId);
            dos.writeInt(m.id);
            dos.writeInt(m.x);
            dos.writeInt(m.y);
            dos.writeInt(m.dir.ordinal());
            dos.writeBoolean(m.isGood);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //上面已经将信息写入到字符数组中
        //将字符数组  打包
        //通过流 发送出去

        byte[] buf = baos.toByteArray();      //新分配字节数组
        //打包，DatagramPacket
        DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress(IP,udpPort));
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
            if(tankId == tp.tank.id) {
                return;
            }
            int id = dis.readInt();
            int x = dis.readInt();
            int y = dis.readInt();
            Dir dir = Dir.values()[dis.readInt()];
            boolean good = dis.readBoolean();

            Missile m = new Missile(tankId, x, y, dir, tp, good);
            m.id = id;
            tp.missileList.add(m);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
