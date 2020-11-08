package com.yz.random12;

import java.util.Random;

/**
 * @Auther:yangwlz
 * @Date: 16:50 : 2020/10/18
 * @Description: com.yz.random12
 * @version: 1.0
 */
public class TestRandom01 {
    public static void main(String[] args) {
        //1、Random类，用的少
        Random r1 = new Random(System.currentTimeMillis());   //seed 不一样，结果不一样
        int i = r1.nextInt();
        System.out.println(i);

        //利用空构造器
        Random r2 = new Random();
        int i1 = r2.nextInt(10);   //[0 ,10)之间的均匀分布int值
        System.out.println(i1);

        System.out.println(r2.nextDouble());

    }




}







