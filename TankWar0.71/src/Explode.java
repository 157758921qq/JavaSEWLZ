import java.awt.*;

/**
 * @Auther:yangwlz
 * @Date: 20:01 : 2020/11/5
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Explode {
    TankPanel tp;
    int x, y;
    int step = 0;
    int[] diameter = {4, 7, 12,18, 26, 32, 49, 30, 14, 6};
    boolean isLiving = true;

    public Explode(int x, int y, TankPanel tp) {
        this.x = x;
        this.y = y;
        this.tp = tp;
    }
    public void draw(Graphics g) {
        if(!isLiving) return;
        if(step == diameter.length) {
            isLiving = false;
            step = 0;
            return;
        }
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillOval(x,y,diameter[step], diameter[step]);
        g.setColor(c);
        step++;
    }
}
