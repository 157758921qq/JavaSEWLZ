package com.yz.io;

import java.io.File;
import java.io.IOException;

/**
 * @Auther:yangwlz
 * @Date: 10:18 : 2020/10/31
 * @Description: com.yz.io
 * @version: 1.0
 */
public class IO01 {
    public static void main(String[] args) {
        File f = new File("c:\\test.txt");
        File f1 = new File("c:/test.txt");
        File f2 = new File("c:"+File.separator+"test.txt");  //建议

        System.out.println(f.canRead());
        System.out.println(f.canWrite());
        System.out.println(f.getName());
        System.out.println(f.getParent());
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
        System.out.println(f.isHidden());
        System.out.println(f.length());
        if(f.exists()) {
            f.delete();
        } else {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(f.getAbsolutePath());
        System.out.println(f.getPath());
        System.out.println(f.toString());

    }
}
