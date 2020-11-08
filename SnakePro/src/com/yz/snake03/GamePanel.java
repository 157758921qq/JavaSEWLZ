package com.yz.snake03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Currency;

/**
 * @Auther:yangwlz
 * @Date: 22:26 : 2020/10/4
 * @Description: com.yz.snake01
 * @version: 1.0
 *  窗体中加入面板，面板是一个透明的容器，必须继承JPanel类
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

    //加入一个定时器
    Timer timer;

    //定义食物的位置
    int foodX, foodY;

    //定义一个积分
    int score;

    //蛇的生死，是否死亡
    boolean isDie;

    //定义游戏时间
    long oldTime, newTime;

    //定义一个初始化的方法，用来初始化小蛇的坐标：
    public void init(){
        //初始化蛇头的坐标, 把坐标放在数组中
        snakeX[0] = 135;
        snakeY[0] = 260;
        snakeX[1] = 110;
        snakeY[1] = 260;
        snakeX[2] = 85;
        snakeY[2] = 260;
        length = 3;
        direction = "R";
        isStart = false;    //游戏最开始是暂停的

        foodX = 160;
        foodY = 385;

        score = 0;
        isDie = false;    //是否死亡，false，未死亡，表示蛇是活着的
        oldTime = System.currentTimeMillis();

    }


    //初始化的内容
    public GamePanel(){
        init();

        //将整个屏幕的焦点放在面板上
        this.setFocusable(true);
        //面板加入监听器，监听键盘的按键，控制游戏的开始、暂停，控制蛇的上下左右运动
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {   //监听是否做过键盘的按压
                super.keyPressed(e);
                //获取按键的代码
                int keyCode = e.getKeyCode();
                if(keyCode == 32) {               //按下空格键
                   if(isDie){                     //如果小蛇已经死亡，重新初始化游戏
                       //初始化游戏
                       init();
                       isDie = false;
                   } else {
                       isStart = !isStart;
                       //刷新页面
                       repaint();                          //这个方法会调用 paintComponent(),重新绘制页面
                   }
                }

                //监听上下左右按键，改变方向，注意一点，
                if(keyCode == KeyEvent.VK_UP){
                    if(!direction.equals("D"))       //不向下时，才能改变方向向上
                        direction = "U";
                }
                if(keyCode == KeyEvent.VK_RIGHT){
                    if(!direction.equals("L"))
                        direction = "R";
                }
                if(keyCode == KeyEvent.VK_DOWN){
                    if(!direction.equals("U"))
                        direction = "D";
                }
                if(keyCode == KeyEvent.VK_LEFT){
                    if(!direction.equals("R"))
                        direction = "L";
                }

            }
        });

        //初始化定时器, 每100毫秒，执行一次ActionPerformed()中的动作
        //定时器中执行的是：
        //如果游戏开始 并且 小蛇死亡
        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //改变蛇的坐标
                if(isStart && isDie == false){                   //游戏开始，小蛇行走  并且  小蛇是活着的
                    //改变蛇的坐标
                    //后一节走到前一节
                    //身子先动，蛇头后动
                    for (int i = length-1; i > 0 ; i--) {
                        snakeX[i] = snakeX[i-1];
                        snakeY[i] = snakeY[i-1];
                    }

                    //蛇头后动
                    switch (direction) {
                        case "U" :
                            snakeY[0] =  snakeY[0] - 25;
                            break;
                        case "R" :
                            snakeX[0] =  snakeX[0] + 25;
                            break;
                        case "D" :
                            snakeY[0] =  snakeY[0] + 25;
                            break;
                        case "L" :
                            snakeX[0] =  snakeX[0] - 25;
                            break;
                    }

                    //对蛇越界的处理
                    if(snakeX[0] > 775){
                        snakeX[0] = 10;
                    }

                    if(snakeX[0] < 10){
                        snakeX[0] = 760;
                    }
                    
                    if(snakeY[0] < 85)
                        snakeY[0] = 535;

                    if(snakeY[0] > 535)
                        snakeY[0] = 85;

                    //蛇头和食物的碰撞， 吃食物
                    if(snakeX[0] == foodX && snakeY[0] == foodY){
                        score += 10;
                        length++;
                        //随机产生食物的位置坐标 foodX 或  foodY
                        // foodX [10, 35,    ,    760]   不是785， 30个25
                        // foodY [85, 110,   ,    535]   不是560， 18个25

                        foodX = (int) (Math.random() * 30) *25 + 10;
                        foodY = (int) (Math.random() * 18) *25 + 85;

                    }

                    //小蛇死亡的判定
                    //如果蛇头撞到任意一节身子死亡
                    for (int i = 1; i < length; i++                                                                 ) {
                        if(snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]){
                            isDie = true;
                            newTime = System.currentTimeMillis();
                        }
                    }

                    //在定时器中处理小蛇运动的快慢
                    if(score >= 30 && score <=60) {
                        //调整定时器的delay
                        timer.setDelay(80);
                    }
                    if(score >70 && score < 100){
                        timer.setDelay(50);
                    }
                    if(score >=100)
                        timer.setDelay(30);
                    

                    repaint();
                }
            }
        });

        //定时器启动
        timer.start();
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
        g.setColor(new Color(128, 0, 128));
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
        if(isStart == false) {                                              //游戏暂停
            //面板中有一段文字
            g.setColor(new Color(159, 123, 214));
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("点击空格开始游戏", 250, 330);
        }


        Images.foodImg.paintIcon(this, g, foodX, foodY);

        g.setColor(new Color(7, 25, 34));
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        g.drawString("本次的分数：", 650,30);
        g.setColor(new Color(242, 23, 32));
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        g.drawString(""+score, 700,55);


        if(isDie) {                                                 //小蛇死亡
            //面板中有一段文字
            g.setColor(new Color(159, 123, 214));
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("小蛇死亡，游戏结束", 250, 330);
            long timeDis = newTime-oldTime;                         //1m = 1000毫秒
            long hour = timeDis/(60*60*1000);                       //除以1000换成秒，除以60换成分，除以60换成小时
            long minute = (timeDis - hour*60*60*1000)/(60*1000);
            long second = (timeDis - hour*60*60*1000 - minute*60*1000)/1000;
           // System.out.println(hour+ "时" + minute + "分 " + second+"秒");
            g.setColor(new Color(214, 19, 7));
            g.drawString("游戏进行了"+minute+"分"+second+"秒", 250, 430);
        }
    }
}
