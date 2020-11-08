package com.yz.data12;

import java.util.Date;

/**
 * @Auther:yangwlz
 * @Date: 10:39 : 2020/10/18
 * @Description: com.yz.data12
 * @version: 1.0
 */
public class TestDate01 {
    public static void main(String[] args) {
        //java.util.Date                  //只有年月日，有时分秒
        Date d = new Date();
        System.out.println(d);
        System.out.println(d.toString());

        System.out.println(d.toGMTString());

        System.out.println(d.getYear());
        System.out.println(d.getMonth());
        System.out.println(d.getTime());                 //返回long类型的数
        System.out.println(System.currentTimeMillis());  //返回long类型的数,时间差用这个

        long statTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - statTime);         //时间差
    }
}
