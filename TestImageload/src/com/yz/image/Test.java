package com.yz.image;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @Auther:yangwlz
 * @Date: 15:09 : 2020/10/30
 * @Description: com.yz.image
 * @version: 1.0
 */
public class Test extends JFrame {

    static BufferedImage img;
    public Test() {
        this.setSize(800, 400);
        this.setLocationRelativeTo(null);          //居中显示
        this.setDefaultCloseOperation(3);          //关闭按钮
        this.setTitle("捕鱼游戏");
        this.setResizable(false);                   //窗口不能改变
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.setVisible(true);
        img = ResourceMgr.getImgResource("/images/bg.jpg");

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img, 0, 0, null);
    }

}
