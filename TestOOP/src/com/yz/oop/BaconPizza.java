package com.yz.oop;

/**
 * @Auther:yangwlz
 * @Date: 14:34 : 2020/10/14
 * @Description: com.yz.oop
 * @version: 1.0
 */
public class BaconPizza extends Pizza {
    private int weight;                //重量

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public BaconPizza() {
    }

    public BaconPizza(String name, int size, int price, int weight) {
        super(name, size, price);
        this.weight = weight;
    }

    @Override
    public String showInfo() {
        return super.showInfo()+", weight=" + weight +"克"+
                '}';
    }
}
