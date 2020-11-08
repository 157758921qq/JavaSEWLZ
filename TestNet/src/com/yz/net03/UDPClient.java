package com.yz.net03;

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
        byte[] buf = new String("Hello Server").getBytes();
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
