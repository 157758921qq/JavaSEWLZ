package com.yz.data12;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther:yangwlz
 * @Date: 10:57 : 2020/10/18
 * @Description: com.yz.data12
 * @version: 1.0
 */
public class TestSimpleDateFormat03 {
    public static void main(String[] args) {
        //String ---> java.util.Date
        //分解：
        //1、String --> java.sql.Date
        //2、java.sql.Date --> java.util.Date
        java.sql.Date date = java.sql.Date.valueOf("2015-9-24");
        java.util.Date date1 = date;
        System.out.println(date1.toString());


        //parse() & format()

        //"2015/9/24", SimpleDateFormat  extends DateFormat(抽象类)
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String ---> Date
        try {
            Date d = df.parse("2019-4-6 12:25:54");
            System.out.println(d);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Date ---> String
        String format = df.format(new Date());
        System.out.println(format);

    }
}
