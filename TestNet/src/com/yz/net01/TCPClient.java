package com.yz.net01;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Auther:yangwlz
 * @Date: 14:32 : 2020/11/8
 * @Description: com.yz.net
 * @version: 1.0
 */
public class TCPClient {
    public static void main(String[] args) {
        Socket s = null;
        OutputStream os = null;
        DataOutputStream dos = null;
        try {
            s = new Socket("127.0.0.1", TCPServer.TCP_PORT);
             os = s.getOutputStream();
             dos = new DataOutputStream(os);
            dos.writeUTF("Hello Server!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(s != null) {
                try {
                    s.close();
                    s = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
