import java.awt.*;

/**
 * @Auther:yangwlz
 * @Date: 13:26 : 2020/11/4
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Missile {
    public static final int MSPEED = 15;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    TankPanel tp;
    int x, y;
    Dir dir;
    boolean isLive = true;


    public Missile() {
    }

    public Missile(int x, int y, Dir dir, TankPanel tp) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tp = tp;
    }

    public void draw(Graphics g) {
        if(isLive){
            Color c = g.getColor();
            g.setColor(new Color(172, 220, 239));
            g.fillOval(x, y, Missile.WIDTH, Missile.HEIGHT);
            g.setColor(c);

            move();
        }


    }

    private void move() {
        switch(dir) {
            case L:
                x -= MSPEED;
                break;
            case LU:
                x -= MSPEED;
                y -= MSPEED;
                break;
            case U:
                y -= MSPEED;
                break;
            case UR:
                x += MSPEED;
                y -= MSPEED;
                break;
            case R:
                x += MSPEED;
                break;
            case RD:
                x += MSPEED;
                y += MSPEED;
                break;
            case D:
                y += MSPEED;
                break;
            case DL:
                x -= MSPEED;
                y += MSPEED;
                break;
        }

        //检查子弹有没有出界
        checkMissileBounds();

    }

    private void checkMissileBounds() {
        if(x < 0 || x > TankClient.GAME_WIDTH || y<0 || y>TankClient.GAME_HEIGHT) {
            //子弹出界, 1.false之后不再draw 2。missileList中将子弹移除
            this.isLive = false;
            //
        }
    }
}
