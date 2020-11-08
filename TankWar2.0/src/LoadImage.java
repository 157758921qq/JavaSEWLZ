import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Auther:yangwlz
 * @Date: 17:14 : 2020/11/6
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class LoadImage {
    public static BufferedImage getImg (String path) {
        BufferedImage img;
        try {
            img = ImageIO.read(LoadImage.class.getClassLoader().getResourceAsStream(path));
            return img;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
