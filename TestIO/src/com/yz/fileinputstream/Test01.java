package com.yz.fileinputstream;

import java.io.*;

/**
 * @Auther:yangwlz
 * @Date: 19:20 : 2020/11/9
 * @Description: com.yz.fileinputstream
 * @version: 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("D:\\yj.jpg");
            FileOutputStream fos = new FileOutputStream("c:\\yj.jpg");

            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            byte[] buf = new byte[1024 * 5];
            int len = fis.read(buf);
            while(len != -1) {
                fos.write(buf, 0, len);
                len = fis.read(buf);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
