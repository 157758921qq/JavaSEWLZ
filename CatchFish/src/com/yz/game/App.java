package com.yz.game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Auther:yangwlz
 * @Date: 9:11 : 2020/10/30
 * @Description: com.yz.game
 * @version: 1.0
 *
 * 图片加载类，使用地址获取图片
 */
public class App {
    public static BufferedImage getImg(String path) {
        BufferedImage img = null;
        try {
            //根据地址获取图片
            img = ImageIO.read(App.class.getResource(path));
            return img;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
