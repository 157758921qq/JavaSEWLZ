package com.yz.shaomawang;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * @Auther:yangwlz
 * @Date: 16:50 : 2020/10/17
 * @Description: com.yz.shaomawang
 * @version: 1.0
 * 这个类加载图片
 *
 */
public class Images {
    //将图片对应的路径封装为对象
    public static URL bodyURL = Images.class.getResource("/images/body.png");
    //然后再根据路径，将路径封装为对应的图片的对象
    public static ImageIcon bodyImg = new ImageIcon(bodyURL);



    public static URL downURL = Images.class.getResource("/images/down.png");
    //然后再根据路径，将路径封装为对应的图片的对象
    public static ImageIcon downImg = new ImageIcon(downURL);



    public static URL foodURL = Images.class.getResource("/images/food.png");
    //然后再根据路径，将路径封装为对应的图片的对象
    public static ImageIcon foodImg = new ImageIcon(foodURL);



    public static URL headerURL = Images.class.getResource("/images/header.jpg");
    //然后再根据路径，将路径封装为对应的图片的对象
    public static ImageIcon headerImg = new ImageIcon(headerURL);



    public static URL leftURL = Images.class.getResource("/images/left.png");
    //然后再根据路径，将路径封装为对应的图片的对象
    public static ImageIcon leftImg = new ImageIcon(leftURL);



    public static URL rightURL = Images.class.getResource("/images/right.png");
    //然后再根据路径，将路径封装为对应的图片的对象
    public static ImageIcon rightImg = new ImageIcon(rightURL);



    public static URL upURL = Images.class.getResource("/images/up.png");
    //然后再根据路径，将路径封装为对应的图片的对象
    public static ImageIcon upImg = new ImageIcon(upURL);


    //将16张爆炸图片导入到内存中
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            for(int i=0; i<16; i++)
                explodes[i] = ImageIO.read(Images.class.getClassLoader().getResourceAsStream("images/e" + (i+1) + ".gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
