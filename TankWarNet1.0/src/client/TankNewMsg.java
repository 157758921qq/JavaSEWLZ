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
 * @Date: 12:52 : 2020/11/7
 * @Description: client
 * @version: 1.0
 */
//坦克新加入的消息
public class TankNewMsg {
    TankPanel tp;
    Tank t;

    public TankNewMsg(TankPanel tp) {
        this.tp = tp;
    }

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
        //上面已经将信息写入到字符数组中
        //将字符数组  打包
        //通过流 发送出去



        byte[] buf = baos.toByteArray();      //新分配字节数组
        //打成DatagramPacket
        DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress(IP,udpPort));
        try {
            ds.send(dp);                     //通过DatagramSocket发送出去
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //消息解析自己
    public void parse(DataInputStream dis) {
        try {
            int id = dis.readInt();
            if(tp.tank.id == id) {
System.out.println("收到自己发给自己的数据包，丢掉");
                return;
            }
            int x = dis.readInt();
            int y = dis.readInt();
            Dir dir = Dir.values()[dis.readInt()];
System.out.println("id= "+id+" ,x= "+x+" ,y= "+y+" ,dir= "+ dir);
            Tank t = new Tank(x, y, dir, tp);
            t.id = id;
            tp.tanks.add(t);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
