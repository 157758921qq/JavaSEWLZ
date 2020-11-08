//package com.yz.game;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.util.Objects;
//
///**
// * @Auther:yangwlz
// * @Date: 20:09 : 2020/10/29
// * @Description: Game
// * @version: 1.0
// */
//public class ResourceMgr {
//
//    public static BufferedImage bg, welcome, net09 ;
//    public static BufferedImage[] fish01 = new BufferedImage[10];
//    public static BufferedImage[] fish01_catch = new BufferedImage[2];
//
//    public static BufferedImage[] fish02 = new BufferedImage[10];
//    public static BufferedImage[] fish02_catch = new BufferedImage[2];
//
//    public static BufferedImage[] fish03 = new BufferedImage[10];
//    public static BufferedImage[] fish03_catch = new BufferedImage[2];
//
//    public static BufferedImage[] fish04 = new BufferedImage[10];
//    public static BufferedImage[] fish04_catch = new BufferedImage[2];
//
//    public static BufferedImage[] fish05 = new BufferedImage[10];
//    public static BufferedImage[] fish05_catch = new BufferedImage[2];
//
//    public static BufferedImage[] fish06 = new BufferedImage[10];
//    public static BufferedImage[] fish06_catch = new BufferedImage[2];
//
//    public static BufferedImage[] fish07 = new BufferedImage[10];
//    public static BufferedImage[] fish07_catch = new BufferedImage[2];
//
//    public static BufferedImage[] fish08 = new BufferedImage[10];
//    public static BufferedImage[] fish08_catch = new BufferedImage[4];
//
//    public static BufferedImage[] fish09 = new BufferedImage[10];
//    public static BufferedImage[] fish09_catch = new BufferedImage[4];
//
//    public static BufferedImage[] fish13 = new BufferedImage[10];
//    public static BufferedImage[] Fish13_catch = new BufferedImage[4];
//
//    public static BufferedImage[] fish14 = new BufferedImage[10];
//    public static BufferedImage[] Fish14_catch = new BufferedImage[4];
//
//    public static BufferedImage[] net = new BufferedImage[7];
//
//
//
//
//    static {  //bg, welcome, net09 ;
//        try {
//            bg = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bg.jpg"));
//
//            welcome = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/welcome.jpg"));
//
//            net09 = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/net09.png"));
//
//
//            /**
//             * 对子弹图片的导入
//             * 使用的是数组
//             */
//            for(int i=0; i<10; i++) {
//                fish01[i] = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/fish01_" + (i + 1) + ".png")));
//            }
//            for(int i=0; i<10; i++) {
//                fish02[i] = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/fish02_" + (i + 1) + ".png")));
//            }
//            for(int i=0; i<10; i++) {
//                fish03[i] = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/fish03_" + (i + 1) + ".png")));
//            }
//            for(int i=0; i<10; i++) {
//                fish04[i] = ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/fish04_" + (i + 1) + ".png")));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
