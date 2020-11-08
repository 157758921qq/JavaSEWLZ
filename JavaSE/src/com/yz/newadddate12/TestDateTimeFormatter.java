package com.yz.newadddate12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @Auther:yangwlz
 * @Date: 16:23 : 2020/10/18
 * @Description: com.yz.newadddate12
 * @version: 1.0
 */
public class TestDateTimeFormatter {
    public static void main(String[] args) {
        //格式化类：DateTimeFormatter
        //常用方法
        DateTimeFormatter df3 = DateTimeFormatter.ofPattern("yyy-MM-dd hh:mm:ss");
        //LocalDateTime -->  String
        LocalDateTime now2 = LocalDateTime.now();
        String format = df3.format(now2);
        System.out.println(format);

        //String --> LocalDateTime
        TemporalAccessor parse = df3.parse("2020-10-18 04:37:55");
        System.out.println(parse);

    }
}






















