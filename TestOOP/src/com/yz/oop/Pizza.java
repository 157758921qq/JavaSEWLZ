package com.yz.oop;

/**
 * @Auther:yangwlz
 * @Date: 10:54 : 2020/10/14
 * @Description: com.yz.oop
 * @version: 1.0
 * 父类：披萨类
 */
public class Pizza {
    private String name;
    private int size;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Pizza() {
    }

    public Pizza(String name, int size, int price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }


    public String showInfo() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price ;
    }


}
