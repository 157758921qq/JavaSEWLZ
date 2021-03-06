package com.yz.snake01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @Auther:yangwlz
 * @Date: 22:26 : 2020/10/4
 * @Description: com.yz.snake01
 * @version: 1.0
 *  窗体中加入面板，面板是一个透明的容器
 *      这个容器里可以放：snake、food等
 *      这个类必须要继承JPanel，只有继承了JPanel才是一个面板
 */
public class GamePanel extends JPanel {
    //将蛇对应的所有x轴坐标放入数组中
    int[] snakeX = new int[500];
    //将蛇对应的所有y轴坐标放入数组中
    int[] snakeY = new int[500];
    //蛇的长度
    int length;
    //定义蛇的行走方向
    String direction;
    //初始化游戏状态
    boolean isStart;
    //定义一个初始化的方法，用来初始化小蛇的坐标：
    public void init(){
        //初始化蛇头的坐标, 把
        snakeX[0] = 135;
        snakeY[0] = 260;
        snakeX[1] = 110;
        snakeY[1] = 260;
        snakeX[2] = 85;
        snakeY[2] = 260;
        length = 3;
        direction = "R";
        isStart = false;    //游戏最开始是暂停的
    }

    public GamePanel(){
        init();

        //将整个屏幕的焦点放在面板上
        this.setFocusable(true);
        //面板加入监听器
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {   //监听是否做过键盘的按压
                super.keyPressed(e);
                //获取按键的代码
                int keyCode = e.getKeyCode();
                if(keyCode == 32) {    //按下空格键
                    isStart = !isStart;
                    //刷新页面
                    repaint();   //这个方法会调用 paintComponent(),重新绘制页面
                }
            }
        });
    }







    //这个方法是画图的逻辑，对应的方法 ---> 所有画图的逻辑都写在里面
    //这个方法底层直接调用，不用我们调
    @Override
    protected void paintComponent(Graphics g) {         //Graphics g是画笔
        super.paintComponent(g);
        //面板是透明的，给面板设置一个背景色
        this.setBackground(new Color(172, 220, 239));

        //在面板上的操作
        //画一张header图片  宽 694X81     窗口的宽800-694）/2 =   还剩 790
        Images.headerImg.paintIcon(this, g, 53, 0);


        //画一张游戏区域 宽775/ 25 = 31    高475/25= 19
        g.setColor(new Color(239,219,218));
        g.fillRect(10, 85, 775, 475);

        //画出小格子
        //先画横线，一共19个格子，需要画20条线
        g.setColor(new Color(0, 0, 0));
        for (int i = 0; i < 20; i++) {
            g.drawLine(10, 85+(25*i),(775+10), 85+(25*i));
        }
        //先画竖线，一共31个格子，需要画32条线
        for (int i = 0; i < 32; i++) {
            g.drawLine((10+25*i), 85, (10+25*i), 85+(25*19));
        }

        //在对应的坐标位置，将蛇对应的图片放进去
        //画蛇头
        switch (direction) {
            case "U" :
                Images.upImg.paintIcon(this,g,snakeX[0],snakeY[0]);
                break;
            case "R" :
                Images.rightImg.paintIcon(this,g,snakeX[0],snakeY[0]);
                break;
            case "D" :
                Images.downImg.paintIcon(this,g,snakeX[0],snakeY[0]);
                break;
            case "L" :
                Images.leftImg.paintIcon(this,g,snakeX[0],snakeY[0]);
                break;
        }

        //画蛇身子
        for (int i = 1; i < length; i++) {
            Images.bodyImg.paintIcon(this, g, snakeX[i], snakeY[i]);
        }
        //Images.bodyImg.paintIcon(this,g,snakeX[2],snakeY[2]);


        //根据游戏的状态绘制
        if(isStart == false) {            //游戏暂停
            //面板中有一段文字
            g.setColor(new Color(159, 123, 214));
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("点击空格开始游戏", 250, 330);
        }

    }
}
