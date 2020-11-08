package com.yz.game;

import javax.swing.*;

/**
 * @Auther:yangwlz
 * @Date: 19:17 : 2020/10/29
 * @Description: com.yz.fish
 * @version: 1.0
 */
public class GameFrame extends JFrame {

    public GameFrame() {
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);          //居中显示
        this.setDefaultCloseOperation(3);          //关闭按钮
        this.setTitle("捕鱼游戏");
        this.setResizable(false);                   //窗口不能改变
        //设置Logo图标
       // this.setIconImage(ResourceMgr.fish01[0]);
        setIconImage(App.getImg("/fishimages/fish01_01.png"));

    }
}
