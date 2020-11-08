package com.yz.test01;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @Auther:yangwlz
 * @Date: 14:59 : 2020/10/14
 * @Description: com.yz.test01
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("请录入第一个数：");
            int num1 = sc.nextInt();
            System.out.println("请录入第二个数：");
            int num2 = sc.nextInt();
            System.out.println("商= " + num1/num2);
           // System.exit(3);                              //终止当前的虚拟机执行
            return;
        } catch (Exception e) {
            //显示异常信息捕获以后，在控制台将异常的效果给我们展示出来
            e.printStackTrace();
        } finally {
            System.out.println("进行执行........");
        }
    }



}
