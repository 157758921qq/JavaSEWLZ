package com.yz.shaomawang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @Auther:yangwlz
 * @Date: 16:36 : 2020/10/17
 * @Description: com.yz.shaomawang
 * @version: 1.0
 */
public class GamePanel extends JPanel {            //继承JPanel，这样才能是个画布
    //蛇身长度 = 3
    String dir = "D";             //蛇的方向

    int length = 3;
    int[] snakeX = new int[500];
    int[] snakeY = new int[500];
    Bomb bomb;

    //定时器
    Timer timer;

    //构造函数,在构造函数里，初始化蛇
    public GamePanel() {
        bomb = new Bomb(20, 23, this);
        //初始化蛇
        snakeX[0] = 135;
        snakeY[0] = 260;
        snakeX[1] = 110;
        snakeY[1] = 260;
        snakeX[2] = 85;
        snakeY[2] = 260;

        //获得画布的焦点
        this.setFocusable(true);
        //键盘的监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keyCode = e.getKeyCode();                //获得按键的值
                System.out.println(keyCode);                 //在控制台打印出来
                switch(keyCode) {
                    case KeyEvent.VK_W:
                        if(!dir.equals("S"))
                            dir = "W";
                        break;
                    case KeyEvent.VK_S:
                        dir = "S";
                        break;

                    case KeyEvent.VK_A:
                        dir = "A";
                        break;

                    case KeyEvent.VK_D:
                        dir = "D";
                        break;

                    default:
                        break;
                }
            }
        });

        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //定时器里的任务
                for (int i = length-1; i > 0 ; i--) {
                    snakeX[i] = snakeX[i-1];
                    snakeY[i] = snakeY[i-1];
                }

                //蛇头后动
                switch (dir) {
                    case "W" :
                        snakeY[0] =  snakeY[0] - 25;
                        break;
                    case "D" :
                        snakeX[0] =  snakeX[0] + 25;
                        break;
                    case "S" :
                        snakeY[0] =  snakeY[0] + 25;
                        break;
                    case "A" :
                        snakeX[0] =  snakeX[0] - 25;
                        break;
                }

                if(snakeX[0] >= 825)
                    snakeX[0] = 0;

                if(snakeX[0] == bomb.foodX && snakeY[0] == bomb.foodY) {
                    length++;
                    bomb.foodX = (int) (Math.random() * 30) *25 + 10;
                    bomb.foodY = (int) (Math.random() * 18) *25 + 85;
                }



                repaint();                              //
            }
        });

        //定时器启动
        timer.start();
    }

    //重写JPanel里的方法，这样才能得到系统的画笔
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        this.setBackground(new Color(172, 220, 239));   //设置背景颜色


        bomb.draw(g);
        g.setColor(new Color(255,255,255));
//        g.drawLine(0, 20, 800, 20);              //画线
//        g.drawLine(0, 45, 800, 45);
//        g.drawLine(25, 20, 25, 575);

//        for (int i = 0; i < 24; i++) {
//                g.drawLine(0, 20+25*i, 800, 20+25*i);
//        }
//
//        for (int i = 0; i < 32; i++) {
//            g.drawLine(0, 20+25*i, 800, 20+25*i);
//        }


        Images.rightImg.paintIcon(this, g, snakeX[0], snakeY[0]);
//        switch (dir) {
//            case "U" :
//                Images.upImg.paintIcon(this,g,snakeX[0],snakeY[0]);
//                break;
//            case "R" :
//                Images.rightImg.paintIcon(this,g,snakeX[0],snakeY[0]);
//                break;
//            case "D" :
//                Images.downImg.paintIcon(this,g,snakeX[0],snakeY[0]);
//                break;
//            case "L" :
//                Images.leftImg.paintIcon(this,g,snakeX[0],snakeY[0]);
//                break;
//        }
        Images.bodyImg.paintIcon(this, g, snakeX[1],snakeY[1]);
        Images.bodyImg.paintIcon(this, g, snakeX[2],snakeY[2]);


    }
}
