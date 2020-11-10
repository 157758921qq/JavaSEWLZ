package com.yz.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Auther:yangwlz
 * @Date: 18:07 : 2020/11/9
 * @Description: com.yz.filereader
 * @version: 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        File f = new File("c:\\test.txt");

        FileReader fr = null;
        char[] ch = new char[5];

        try {
            fr = new FileReader(f);
            int len = fr.read(ch);
            while(len != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.println(ch[i]);
                }
                len = fr.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
