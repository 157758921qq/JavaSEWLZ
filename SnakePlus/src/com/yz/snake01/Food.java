package com.yz.snake01;

import java.awt.*;

/**
 * @Auther:yangwlz
 * @Date: 10:56 : 2020/10/16
 * @Description: com.yz.snake01
 * @version: 1.0
 */
public class Food {
    int foodX, foodY;
    GamePanel gp;

    public Food() {
    }

    public Food(int foodX, int foodY, GamePanel gp) {
        this.foodX = foodX;
        this.foodY = foodY;
        this.gp = gp;
    }

    public void draw(Graphics g) {
        Images.foodImg.paintIcon(gp, g, foodX, foodY);
    }
}
