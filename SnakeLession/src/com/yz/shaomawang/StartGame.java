package com.yz.shaomawang;

import javax.swing.*;

/**
 * @Auther:yangwlz
 * @Date: 16:18 : 2020/10/17
 * @Description: com.yz.shaomawang
 * @version: 1.0
 */
public class StartGame {
                                                                //这是个main函数的入口
    public static void main(String[] args) {
        //这个main函数运行后，
        JFrame jf = new JFrame();
        jf.setTitle("同学的小游戏");                            //设置窗体的标题
        //窗口的关闭功能
        jf.setDefaultCloseOperation(3);

        jf.setResizable(false);
        jf.setBounds(300, 50, 800, 620);

        GamePanel gp = new GamePanel();                        //new 产生一张画布
        jf.add(gp);

        jf.setVisible(true);                                   //设置可见

    }
}
