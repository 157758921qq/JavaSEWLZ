package com.yz.lesson01;

import java.util.Scanner;

/**
 * @Auther:yangwlz
 * @Date: 16:19 : 2020/11/22
 * @Description: com.yz
 * @version: 1.0
 */
public class test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入您的姓名：");
        String name = sc.next();

        System.out.print("请输入您的年龄：");
        int age = sc.nextInt();

        System.out.print("请输入您的性别：");
        String sexStr = sc.next();
        //char sex = sexStr.charAt(0);

        System.out.println("name= "+name +", age= "+ age +", sex= " + sexStr);
    }
}
