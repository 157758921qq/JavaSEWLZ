package com.yz.snake01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


/**
 * @Auther:yangwlz
 * @Date: 10:52 : 2020/10/16
 * @Description: com.yz.snake01
 * @version: 1.0
 */
public class GamePanel extends JPanel {

    Snake s;
    Food f;
    Score score;
    Timer timer;
    boolean isStart;
    Explode e;
    //游戏是否开始
    List<Explode> explodes = new ArrayList<>();;

    public void init() {
        s = new Snake(this);
        f = new Food(160, 385, this);


        score = new Score(0, this);
        isStart = true;
    }


    public GamePanel() {
        init();
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {    //Panel对键盘的监听
                super.keyPressed(e);
                int keyCode = e.getKeyCode();
                if(keyCode == 32) {

                    //如果按了空格键
                    if(s.isDie) {
                        //System.out.println("3232323");
                        init();
                        s.isDie = false;
                        timer.start();
                    } else {   //按下空格并且蛇活着
                               //游戏暂停
                        isStart = !isStart;
                        repaint();
                    }
                }
                s.keyPressed(e);                             //根据按键改变蛇的方向
            }
        });


        //定时器
        timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isStart){                             //如果游戏开始
                    s.move();
                    s.hitWithsFood(f);
                    if(s.hitWithsbody())
                    {
                        //游戏结束
                        timer.stop();
                    }

                }

                repaint();
            }
        });

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
        g.setColor(new Color(0, 0, 0));
        for (int i = 0; i < 20; i++) {
            g.drawLine(10, 85+(25*i),(775+10), 85+(25*i));
        }
        //先画竖线，一共31个格子，需要画32条线
        for (int i = 0; i < 32; i++) {
            g.drawLine((10+25*i), 85, (10+25*i), 85+(25*19));
        }


        s.draw(g);
        f.draw(g);
        if(e != null)
            e.draw(g);

        //当score达到30, 60, 90分时时，发生爆炸
//        switch (score.getScore()) {
//            case 30 :
//                for (int i = 0; i < 3 ; i++) {
//                    explodes.get(i).draw(g);
//                }
//                break;
//            case 60 :
//                for (int i = 3; i < 9 ; i++) {
//                    explodes.get(i).draw(g);
//                }
//                break;
//            case 90 :
//                for (int i = 9; i < 18 ; i++) {
//                    explodes.get(i).draw(g);
//                }
//                break;
//            case 120 :
//                for (int i = 18; i < 30 ; i++) {
//                    explodes.get(i).draw(g);
//                }
//                break;
//            case 160 :
//                for (int i = 30; i < 45 ; i++) {
//                    explodes.get(i).draw(g);
//                }
//                break;
//        }







        if(!isStart) {                                                 //小蛇死亡
            //面板中有一段文字
            g.setColor(new Color(159, 123, 214));
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("游戏暂停，点击空格开始游戏！", 50, 330);
        }

        if(s.isDie) {                                                 //小蛇死亡
            //面板中有一段文字
            g.setColor(new Color(159, 123, 214));
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));
            g.drawString("小蛇死亡，游戏结束", 250, 330);
            g.drawString("按空格键从新开始", 250, 430);
        }

        g.setColor(new Color(242, 23, 32));
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        g.drawString("您的得分："+score.getScore(), 600,55);
    }

    public void add(Explode explode) {
            this.e = explode;
    }
}

