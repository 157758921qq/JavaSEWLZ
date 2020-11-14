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
public class TankNewMsg implements Msg{
    int msgType = Msg.TANK_NEW_MSG;

    TankPanel tp;
    Tank t;

    public TankNewMsg(TankPanel tp) {
        this.tp = tp;
    }

    public TankNewMsg(Tank tank) {
        this.t = tank;
    }


    public void send(DatagramSocket ds, String IP, int udpPort) {
        //数据有了后存放在内存中(具体在字节数组中)，通过字节数组流输出，
        //流输出后就到了Client端，  Clinet端接收数据包
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeInt(msgType);
            dos.writeInt(t.id);
            dos.writeInt(t.x);
            dos.writeInt(t.y);
            dos.writeInt(t.dir.ordinal());
            dos.writeBoolean(t.isGood);
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



    //消息解析自己
    public void parse(DataInputStream dis) {
        try {
            int id = dis.readInt();
            if(tp.tank.id == id) {
//System.out.println("收到自己发给自己的数据包，丢掉");
                return;
            }
System.out.println("接收到新坦克的消息");
            int x = dis.readInt();
            int y = dis.readInt();
            Dir dir = Dir.values()[dis.readInt()];
//System.out.println("id= "+id+" ,x= "+x+" ,y= "+y+" ,dir= "+ dir);
            boolean isGood = dis.readBoolean();

            boolean exist = false;
            for (int i = 0; i < tp.tanks.size(); i++) {
                Tank t = tp.tanks.get(i);
                if(t.id == id) {
                    exist = true;
                    break;
                }
            }
            if(!exist) {

                TankNewMsg tnMsg = new TankNewMsg(tp.tank);
                tp.nc.send(tnMsg);

                Tank t = new Tank(x, y, dir, isGood, tp);
                t.id = id;
                tp.tanks.add(t);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
