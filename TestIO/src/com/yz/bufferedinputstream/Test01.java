package com.yz.bufferedinputstream;

import java.io.*;

/**
 * @Auther:yangwlz
 * @Date: 19:39 : 2020/11/9
 * @Description: com.yz.bufferedinputstream
 * @version: 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        File f = new File("C:\\test.txt");
        File f1 = new File("C:\\test1.txt");
        try {
            FileInputStream fis = new FileInputStream(f);
            FileOutputStream fos = new FileOutputStream(f1);

            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] buf = new byte[1024*10];
            int len = bis.read(buf);
            while ((len != -1)) {
                bos.write(buf, 0, len);   //不需要flush()，bos自带
                len = bis.read(buf);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
