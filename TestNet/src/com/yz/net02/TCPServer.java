package com.yz.net02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther:yangwlz
 * @Date: 14:30 : 2020/11/8
 * @Description: com.yz.net
 * @version: 1.0
 */
public class TCPServer {
    public static final int TCP_PORT = 6666;

    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket s = null;
        try {
            ss = new ServerSocket(TCP_PORT);

        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                s = ss.accept();

                //在小桶的字符流
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter os = new PrintWriter(s.getOutputStream());

                DataInputStream dis = new DataInputStream(s.getInputStream());
                System.out.println(dis.readUTF());
                dis.close();
                System.out.println("有客户端连接到服务");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
