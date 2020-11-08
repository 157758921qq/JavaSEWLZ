package com.yz.game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

/**
 * @Auther:yangwlz
 * @Date: 20:43 : 2020/10/29
 * @Description: Game
 * @version: 1.0
 */
public class Fish extends Thread {      //Fish 继承了Thread类
    int x, y, width, height;
    GamePanel gp;
    BufferedImage img;
    Random rd;

    //用来存放鱼游动时所有的图片
    java.util.List<BufferedImage> animation = new ArrayList<>();


    public Fish(GamePanel gp)  {
        this.gp = gp;
        rd = new Random();
        int index = rd.nextInt(9) + 1;   //产生[1, 9]之间的随机数
        //加载鱼游动时动画图片
        this.img = App.getImg("/fishimages/fish0"+ index +"_01.png");

        width = img.getWidth();
        height = img.getHeight();

        //鱼动起来
        String fishName = "/fishimages/fish0"+index+"_";
        for (int i = 0; i < 10; i++) {
            int fi = i+1;
            String prefix = (fi==10?"":"0")+fi;
            String imageName = fishName + prefix +".png";
            BufferedImage img = App.getImg(imageName);
            //加入到animation中
            animation.add(img);
        }

        //确定鱼的显示
        img = animation.get(0);

        x = rd.nextInt(800 - width);
        y = rd.nextInt(400 - height - 30);
    }

    @Override
    public void run() {
        super.run();

        while(true) {
            move();
            try {
                Thread.sleep(100);
                this.gp.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    int step = 0;

    private void move() {
        step++;
        img = animation.get(step%10);
        //重新获取图片的大小
        width = img.getWidth();
        height = img.getHeight();

        if(x <= -width)
            //鱼重新出现
            getOut();


        //向左移动
        x -= 3;

    }

    /**
     * 鱼被捕
     * 鱼越界
     */
    private void getOut() {
        x = 800;
        y = rd.nextInt(480 - height);
    }

    //检查(netX netY）的坐标是否在鱼的范围内
    public boolean contains(int netX, int netY) {
        int dx = netX - x;
        int dy = netY - y;
        return dx >= 0 && dx <= width && dy >= 0 && dy <= height;
    }
}
