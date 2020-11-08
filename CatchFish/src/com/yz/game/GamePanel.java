package com.yz.game;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * @Auther:yangwlz
 * @Date: 19:37 : 2020/10/29
 * @Description: com.yz.fish
 * @version: 1.0
 */
public class GamePanel extends JPanel {

    //Fish List load fish
    java.util.List<Fish> fishs = new ArrayList<>();
    Net net = new Net();


    public GamePanel() {
        this.setBackground(Color.yellow);

        //初始化20条鱼，加入到list中
        for (int i = 0; i < 20; i++) {
            fishs.add(new Fish(this));
        }
    }

    public void action() {                //每条鱼都动起来
        for(Fish f : fishs) {
            f.start();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(App.getImg("/fishimages/bg.jpg"), 0, 0, null);

        g.setColor(Color.RED);
        g.setFont(new Font("微软雅黑", Font.BOLD, 15));
        g.drawString("分数", 20, 30);
        g.drawString("子弹数 ：100", 300, 30);

        //g.drawImage(f.img, f.getX(), f.getY(), f.img.getWidth(), f.img.getHeight(),null);
        //g.drawImage(f1.img, f1.getX(), f1.getY(), f1.img.getWidth(), f1.img.getHeight(),null);
        //g.drawImage(f2.img, f2.getX(), f2.getY(), f2.img.getWidth(), f2.img.getHeight(),null);
        //g.drawImage(f3.img, f3.getX(), f3.getY(), f3.img.getWidth(), f3.img.getHeight(),null);


        //产生的鱼都画出来
        for(Fish f : fishs) {
            g.drawImage(f.img, f.x, f.y, f.img.getWidth(), f.img.getHeight(),null);
        }


        g.drawImage(net.img, net.x, net.y, net.width, net.height,null);

    }
}
