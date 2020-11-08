package com.yz.commonclass12;

/**
 * @Auther:yangwlz
 * @Date: 10:04 : 2020/10/18
 * @Description: com.yz.commonclass
 * @version: 1.0
 */
public class TestInteger01 {
    //属性
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        //物极必反
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(Integer.MIN_VALUE-1);

        //构造方法，没有空参构造器
        Integer value = new Integer(12);
        System.out.println(value.toString());

        Integer value2 = new Integer("45");
        //  1、this.value = parseInt(s, 10);    2、抛出NumberFormatException
        System.out.println(value2.toString());

        //包装类：自动装箱和拆箱
        Integer i = 12;          //int ---> Integer
        Integer i2 = new Integer("45");
        int num = i2;
        System.out.println(num);


    }
}
