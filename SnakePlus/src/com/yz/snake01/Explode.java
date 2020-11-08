package com.yz.snake01;

import java.awt.*;

/**
 * @Auther:yangwlz
 * @Date: 18:59 : 2020/10/16
 * @Description: com.yz.snake01
 * @version: 1.0
 */
public class Explode {
    GamePanel gp;
    int explodeX, explodeY;
    int step = 0;
    boolean live = true;

    public Explode(int x, int y, GamePanel gp) {
        this.gp = gp;
        this.explodeX = x;
        this.explodeY = y;
    }


    public void draw(Graphics g){
        if(this.live) {
            System.out.println("爆炸咯");
            g.drawImage(Images.explodes[step], explodeX, explodeY, null);
            step++;
            if(step >= Images.explodes.length ) {
                this.die();
            }
        }
    }
    private void die() {
        this.live = false;
    }

    public void changePos() {
        explodeX = (int) (Math.random() * 30) *25 + 10;
        explodeY = (int) (Math.random() * 18) *25 + 85;
    }

}
