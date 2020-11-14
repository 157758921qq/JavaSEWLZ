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
 * @Date: 9:43 : 2020/11/14
 * @Description: client
 * @version: 1.0
 */
public class TankMoveMsg implements Msg {
    TankPanel tp;
    int msgType = Msg.TANK_MOVE_MSG;
    int x, y;
    int id;
    Dir dir;

    public TankMoveMsg() {
    }

    public TankMoveMsg(int x, int y, int id, Dir dir) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.dir = dir;
    }

    public TankMoveMsg(TankPanel tp) {
        this.tp = tp;
    }

    @Override
    public void send(DatagramSocket ds, String IP, int udpPort) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeInt(msgType);
            dos.writeInt(id);
            dos.writeInt(x);
            dos.writeInt(y);
            dos.writeInt(dir.ordinal());
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
            int id = dis.readInt();
            if (tp.tank.id == id) {
                return;
            }
            int x = dis.readInt();
            int y = dis.readInt();

            Dir dir = Dir.values()[dis.readInt()];

            //如果有这辆坦克，改变方向就ok
            //如果没有，new 坦克，添加进List中
            boolean exist = false;
            for (int i = 0; i < tp.tanks.size(); i++) {
                Tank t = tp.tanks.get(i);
                if (t.id == id) {
                    t.dir = dir;
                    t.x = x;
                    t.y = y;
                    exist = true;
                    break;
                }
            }
            //if(!exist)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

