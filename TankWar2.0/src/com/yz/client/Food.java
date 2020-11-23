package com.yz.client;

import java.awt.*;

/**
 * @Auther:yangwlz
 * @Date: 16:08 : 2020/11/6
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Food {
    int x, y, w, h;
    TankPanel t;
    Rectangle rect;
    boolean isLive = true;

    int[][] pos = {
        {350, 300},
        {360, 300},
        {375, 275},
        {400, 200},
        {360, 270},
        {360, 290},
        {340, 280}
    };

    int step = 0;

    public Food() {
    }

    public Food(int x, int y) {
        this.x = pos[0][0];
        this.y = pos[0][1];
        w = h = 15;
        rect = new Rectangle(x,y,w,h);
    }

    public void draw(Graphics g) {
        if(isLive) {
            Color c = g.getColor();
            g.setColor(Color.GREEN);
            g.fillOval(x, y, w, h);
            g.setColor(c);

            move();
        }
    }

    public void move() {
        step++;
        if(step == pos.length) {
            step = 0;
        }
        x = pos[step][0];
        x = pos[step][1];

        rect.x = x;
        rect.y = y;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, w,h);
    }

}
