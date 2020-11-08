package com.yz.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Auther:yangwlz
 * @Date: 15:02 : 2020/10/30
 * @Description: com.yz.image
 * @version: 1.0
 */
public class ResourceMgr {
    public static BufferedImage img = null;

    public static BufferedImage getImgResource(String path) {
        try {
            img = ImageIO.read(ResourceMgr.class.getResource(path));
            return img;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
