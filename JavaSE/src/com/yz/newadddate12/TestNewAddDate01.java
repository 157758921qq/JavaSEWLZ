package com.yz.newadddate12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Auther:yangwlz
 * @Date: 13:06 : 2020/10/18
 * @Description: com.yz.newadddate12
 * @version: 1.0
 */
public class TestNewAddDate01 {
    public static void main(String[] args) {
        //LocalDate  LocalTime   LocalDateTime
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);        //年月日


        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);        //时分秒


        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);    //年月日，时分秒


        //方法2  of();
        LocalDate of = LocalDate.of(2010, 5, 6);
        System.out.println(of);
        LocalTime of1 = LocalTime.of(12, 35, 56);
        System.out.println(of1);
        LocalDateTime of2 = LocalDateTime.of(1890, 12, 23, 13, 24, 15);
        System.out.println(of2);

    }
}

















