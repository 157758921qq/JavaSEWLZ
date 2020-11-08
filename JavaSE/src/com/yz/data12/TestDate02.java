package com.yz.data12;

import java.sql.Date;

/**
 * @Auther:yangwlz
 * @Date: 10:46 : 2020/10/18
 * @Description: com.yz.data12
 * @version: 1.0
 */
public class TestDate02 {
    public static void main(String[] args) {
        //java.sql.Date
        Date d = new Date(1592055964263L);
        System.out.println(d);    //只有年月日，没有时分秒

        //java.sql.Date extends java.util.Date

        java.util.Date date = new Date(1592055964263L);
        //util ---> sql;
        //向下转型
        Date date1 = (Date)date;
        //构造器
        Date date2 = new Date(date.getTime());


        //sql ---> util
        java.util.Date date3 = d;


        //String ---> sql.Date
        Date date4 = Date.valueOf("2019-3-8");

    }
}
