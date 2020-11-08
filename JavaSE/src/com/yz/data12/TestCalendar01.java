package com.yz.data12;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @Auther:yangwlz
 * @Date: 11:10 : 2020/10/18
 * @Description: com.yz.data12
 * @version: 1.0
 */
public class TestCalendar01 {
    public static void main(String[] args) {

        //Calendar 是一个抽象类，不可以直接创建对象
        //GregorianCalendar 是之类
        Calendar cal = new GregorianCalendar();
        Calendar cal2 =  Calendar.getInstance();
        System.out.println(cal);

        //常用的方法
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH));

        //当月最大和最小的天数
        System.out.println(cal.getActualMaximum(Calendar.DATE));  //当月日期的最大天数

        //set
        cal.set(Calendar.YEAR, 1990);
        System.out.println(cal);


    }
}
