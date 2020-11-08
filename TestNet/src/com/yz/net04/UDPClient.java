package com.yz.net04;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @Auther:yangwlz
 * @Date: 15:06 : 2020/11/8
 * @Description: com.yz.net03
 * @version: 1.0
 */
public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        long n = 125698L;
        //写到内存中的字节数组中
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeLong(n);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //写到字节数组中
        byte[] buf = baos.toByteArray();

        //打成Datagrampacket，再通过DatagramSocket发出去
        DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress("127.0.0.1", 5678));
        try {
            ds = new DatagramSocket(9999);
            ds.send(dp);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ds.close();
        }
    }
}
