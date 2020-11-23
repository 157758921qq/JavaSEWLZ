package com.yz.client;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Auther:yangwlz
 * @Date: 20:01 : 2020/11/5
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Explode {
    Object o;
    TankPanel tp;
    int x, y;
    int step = 0;
    //int[] diameter = {4, 7, 12,18, 26, 32, 49, 30, 14, 6};
    boolean isLiving = true;


    public static BufferedImage[] explodes = new BufferedImage[11];
    static {

        for (int i = 0; i < 11; i++) {
            try {
                explodes[i] = ImageIO.read(Explode.class.getClassLoader().getResourceAsStream("images/" + i  + ".gif"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
    public Explode(int x, int y, TankPanel tp, Object o) {
        this.x = x;
        this.y = y;
        this.tp = tp;
        this.o = o;
    }

    public void draw(Graphics g) {
        if (!isLiving) return;
        if(o instanceof EnemyTank) {
            if (step == explodes.length) {
                isLiving = false;
                step = 0;
                return;
            }

            g.drawImage(explodes[step], x, y, null);
            x = ((EnemyTank) o).x;
            y = ((EnemyTank) o).y;
            step++;
        }
        if(o instanceof Tank) {
            if (step == explodes.length) {
                isLiving = false;
                step = 0;
                return;
            }

            g.drawImage(explodes[step], x, y, null);
            x = ((Tank)o).x;
            y = ((Tank)o).y;
            step++;
        }

    }
}