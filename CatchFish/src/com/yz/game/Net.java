package com.yz.game;

import java.awt.image.BufferedImage;

/**
 * @Auther:yangwlz
 * @Date: 18:50 : 2020/10/30
 * @Description: com.yz.game
 * @version: 1.0
 */
public class Net {
    BufferedImage img;
    int x, y, width, height;
    boolean show;                    //是否显示当前网对象

    public Net() {
        img = App.getImg("/fishimages/net_1.png");
        width = img.getWidth();
        height = img.getHeight();
        this.x = 200;
        this.y = 200;
    }
}
