package com.yz.lesson01;

import java.util.Scanner;

/**
 * @Auther:yangwlz
 * @Date: 16:39 : 2020/11/22
 * @Description: com.yz.lesson01
 * @version: 1.0
 */
public class Test02 {
    //定义了一个Double类型的常量
    public static final float PI = 3.14f;
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        float r = sc.nextFloat();
        float c, s;
        c = 2*PI*r;
        s = PI * r * r;

        System.out.println("圆的周长= "+ c +", 圆的面积= "+ s);
    }
}
