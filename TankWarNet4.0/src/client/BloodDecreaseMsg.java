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
 * @Date: 9:33 : 2020/11/15
 * @Description: client
 * @version: 1.0
 */
public class BloodDecreaseMsg implements Msg {
    int msgType = Msg.BLOOD_DECREASE_MSG;
    TankPanel tp;
    int tankId;
    int id;



    public BloodDecreaseMsg(TankPanel tp) {
        this.tp = tp;
    }

    public BloodDecreaseMsg(int tankId, int id) {
        this.tankId = tankId;
        this.id = id;
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
            int tankId = dis.readInt();        //坦克id
            int id = dis.readInt();            //血条id
            for (int i = 0; i < tp.tanks.size(); i++) {
                Tank t = tp.tanks.get(i);
                Tank.BloodBar bb = t.bb;
                if(t.id == tankId && bb.id == id) {
                    System.out.println("22222222222222");
                    t.life -= 20;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
