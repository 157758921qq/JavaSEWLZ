package com.yz.newadddate12;

import java.time.LocalDateTime;

/**
 * @Auther:yangwlz
 * @Date: 16:14 : 2020/10/18
 * @Description: com.yz.newadddate12
 * @version: 1.0
 */
public class TestLocalDateTime02 {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());

        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());

        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());

        System.out.println("----------------------------------------");
        //with方法
        LocalDateTime localDateTime1 = localDateTime.withMonth(9);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);

        //加减的方法.plusMonths(4)

    }
}
