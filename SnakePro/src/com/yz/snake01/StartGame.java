package com.yz.snake01;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther:yangwlz
 * @Date: 22:16 : 2020/10/4
 * @Description: com.yz.snake01
 * @version: 1.0
 *  这里是main函数的入口
 */
public class StartGame {
    public static void main(String[] args) {

        JFrame jf = new JFrame();          //创建一个窗体对象
        jf.setTitle("贪吃蛇小游戏");

        //屏幕的宽和高
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        //屏幕居中，并设置窗口宽和高
        jf.setBounds((width-800)/2, (height-600)/2, 800, 600);

        //窗口的关闭功能
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置窗体不可改变
        jf.setResizable(false);

        //在窗体中添加面板
        GamePanel gp = new GamePanel();
        jf.add(gp);


        //默认情况下窗体是隐藏的
        jf.setVisible(true);

    }


}
