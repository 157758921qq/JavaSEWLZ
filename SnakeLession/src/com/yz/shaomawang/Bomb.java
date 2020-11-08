package com.yz.shaomawang;

import java.awt.*;

/**
 * @Auther:yangwlz
 * @Date: 16:52 : 2020/11/7
 * @Description: com.yz.shaomawang
 * @version: 1.0
 */
public class Bomb {
    int foodX, foodY;
    GamePanel gp;

    public Bomb(int x, int y, GamePanel gp) {
        this.foodX = x;
        this.foodY = y;
        this.gp = gp;
    }

    public void draw(Graphics g) {
        Images.foodImg.paintIcon(gp, g, foodX, foodY);
    }

}
