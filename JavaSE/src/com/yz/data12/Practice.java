package com.yz.data12;

import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.Scanner;
import java.util.zip.CheckedOutputStream;

/**
 * @Auther:yangwlz
 * @Date: 11:21 : 2020/10/18
 * @Description: com.yz.data12
 * @version: 1.0
 */
public class Practice {
    public static void main(String[] args) {

        System.out.println("请输入您想查看的日期：（例如格式2020-1-2）");
        Scanner sc = new Scanner(System.in);
        String strDate = sc.nextLine();
        //System.out.println(strDate);

        //要求 ： String --> Calendar
        //1 String --> Date
        java.sql.Date date = java.sql.Date.valueOf(strDate);
        //2 Date  --> Calendar
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        //后续操作
        //星期提示
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        //获取本月的最大天数
        int maxDate = cal.getActualMaximum(Calendar.DATE);
        //从1号到maxDate循环

        //获取本月那个日，加*
        int nowDay = cal.get(Calendar.DATE);

        //将日期调为本月的1号
        cal.set(Calendar.DATE,1);
        //获取这个1号是本周的第几天
        int num = cal.get(Calendar.DAY_OF_WEEK);
        //System.out.println(num);
        //前面空出来的天数
        int day = num -1;

        int count = 0;               //计数器
        //在日期前将空格打印出来
        for (int i = 1; i <= day; i++) { //空出来的日子也要放入计数器
            System.out.print("\t");
        }
        count = count + day;

        for (int i = 1; i <= maxDate; i++) {
            if(i == nowDay) {
                System.out.print(i + "*"+"\t");
            } else {
                System.out.print(i + "\t");
            }
            count++;                          //每7位换行
            if(count % 7 == 0)
                System.out.println();
        }

    }

}
