package com.yz.oop;

/**
 * @Auther:yangwlz
 * @Date: 14:31 : 2020/10/14
 * @Description: com.yz.oop
 * @version: 1.0
 */
public class FruitsPizza extends Pizza {

    private String burdening;                      //配料

    public String getBurdening() {
        return burdening;
    }

    public void setBurdening(String burdening) {
        this.burdening = burdening;
    }

    public FruitsPizza(String name, int size, int price, String burdening) {
        super(name, size, price);
        this.burdening = burdening;
    }

    public FruitsPizza() {
    }


    @Override
    public String showInfo() {
        return super.showInfo()+", burdening= "+burdening+"配料"+
                '}';
    }
}
