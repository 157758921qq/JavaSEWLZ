package com.yz.commonclass12;

/**
 * @Auther:yangwlz
 * @Date: 10:23 : 2020/10/18
 * @Description: com.yz.commonclass
 * @version: 1.0
 */
public class TestInteger02 {
    public static void main(String[] args) {
        //比较compareTo()
        Integer i1 = new Integer(12);
        Integer i2 = new Integer((12));
        System.out.println(i1.compareTo(i2));


        //equals()
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        //Integer对象通过自动装箱来完成
        Integer i5 = 12;
        Integer i6 = 12;
        System.out.println(i5.equals(i6));
        //如果自动装箱值在-128 ~ 127之间，比较的是具体的值
        //否则，比较的是对象的地址

        //intValue（）          Integer ---> int
        //parseInt(String s)    String  ---> int
        int i8 = Integer.parseInt("18");
        System.out.println(i8);


        //toString： Integer ---> String
        Integer i10 = 130;
        System.out.println(i10.toString());
    }
}
