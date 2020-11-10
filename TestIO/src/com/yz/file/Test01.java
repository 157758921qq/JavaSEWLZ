package com.yz.file;

import java.io.File;
import java.io.IOException;

/**
 * @Auther:yangwlz
 * @Date: 18:00 : 2020/11/9
 * @Description: com.yz.file
 * @version: 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        File f1 = new File("c:\\test.txt");
        //File f2 = new File("d://test.txt");
        //File f3 = new File("d:"+File.separator+"test.txt");

        System.out.println(f1.canRead());
        System.out.println(f1.canWrite());
        System.out.println(f1.getName());
        System.out.println(f1.getParent());
        System.out.println(f1.isDirectory());
        System.out.println(f1.isHidden());
        System.out.println(f1.length());

        if(f1.exists()){
            f1.delete();
        } else {
            try {
                f1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
