package com.yz.io;

import java.io.File;

/**
 * @Auther:yangwlz
 * @Date: 10:30 : 2020/10/31
 * @Description: com.yz.io
 * @version: 1.0
 */
public class IO02 {
    public static void main(String[] args) {
        File f = new File("c:\\test.txt");
        //对目录的操作
        f.mkdirs();  //创建多层目录
        f.delete();  //删除目录
    }
}
