package com.yz.oop;

import java.util.Scanner;

/**
 * @Auther:yangwlz
 * @Date: 14:35 : 2020/10/14
 * @Description: com.yz.oop
 * @version: 1.0
 */
public class testPizza {
    public static void main(String[] args) {
        //选择购买披萨
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择你想要的披萨（1、培根披萨  2、水果披萨）");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: {
                System.out.println("请录入培根的克数：");
                int weight = sc.nextInt();
                System.out.println("请录入培根披萨的大小：");
                int size = sc.nextInt();
                System.out.println("请录入培根披萨的价格：");
                int price = sc.nextInt();

                //将录入的信息封装成对象
                BaconPizza bp = new BaconPizza("培根披萨",size,price, weight);
                System.out.println(bp.showInfo());
            }
                break;
            case 2: {
                System.out.println("请录入你想要加入的水果：");
                String burdening = sc.next();
                System.out.println("请录入水果披萨的大小：");
                int size = sc.nextInt();
                System.out.println("请录入水果披萨的价格：");
                int price = sc.nextInt();
                FruitsPizza fp = new FruitsPizza("水果披萨", size, price, burdening);
                System.out.println(fp.showInfo());
            }
                break;
        }
    }
}
