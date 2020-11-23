package com.yz.client;

import java.awt.*;

/**
 * @Auther:yangwlz
 * @Date: 10:43 : 2020/11/6
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Wall {
    int x, y, w, h;
    TankPanel tp;

    public Wall(int x, int y, int w, int h, TankPanel tp) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.tp = tp;
    }

    public void draw(Graphics g) {
        g.fillRect(x,y,w,h);
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, w, h);
    }


}
