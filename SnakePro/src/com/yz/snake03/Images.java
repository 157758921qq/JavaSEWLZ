package com.yz.snake03;

import javax.swing.*;
import java.net.URL;

/**
 * @Auther:yangwlz
 * @Date: 22:08 : 2020/10/4
 * @Description: com.yz.snake01
 * @version: 1.0
 * Images类的作用：
 *      1、静态加载图片,
 *      2、方法为什么static的，调用方便
 *
 */
public class Images {
    //将图片对应的路径封装为对象
    //反射
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

}
