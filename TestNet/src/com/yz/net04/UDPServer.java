package com.yz.net04;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Auther:yangwlz
 * @Date: 15:03 : 2020/11/8
 * @Description: com.yz.net03
 * @version: 1.0
 */
public class UDPServer {
    public static void main(String[] args) {
        byte[] buf = new byte[1024];
        DatagramSocket ds = null;
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        try {
            ds = new DatagramSocket(5678);                     //在UDP的5678端口监听
        } catch (SocketException e) {
            e.printStackTrace();
        }

        while(true) {
            try {
                ds.receive(dp);
                //System.out.println(new String(buf, 0, dp.getLength()));
                ByteArrayInputStream bais = new ByteArrayInputStream(buf);
                DataInputStream dis = new DataInputStream(bais);
                System.out.println(dis.readLong());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
