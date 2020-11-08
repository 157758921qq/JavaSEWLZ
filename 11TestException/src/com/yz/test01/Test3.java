package com.yz.test01;

import java.util.Scanner;

/**
 * @Auther:yangwlz
 * @Date: 7:36 : 2020/10/16
 * @Description: com.yz.test01
 * @version: 1.0
 */
public class Test3 {
    public static void main(String[] args) {

    }
}

class Student {
    private String name;
    private String sex;
    private int age;

    public Student() {
    }

    public Student(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {
        if(sex.equals("男") || sex.equals("女")) {
            this.sex = sex;
        } else {
            throw new RuntimeException("性别有误");   //制造运行时异常
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
