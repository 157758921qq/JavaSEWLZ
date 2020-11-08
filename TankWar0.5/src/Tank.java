import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @Auther:yangwlz
 * @Date: 10:50 : 2020/11/3
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Tank {
    int x, y;                                                //坦克位置
    boolean bL = false, bU = false, bR = false, bD = false;  //记录左上右下的键是否被按下
    Dir dir;
    public static final int speed = 5;
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    Dir ptDir = Dir.D;
    TankPanel tp;

    public Tank() {
    }

    public Tank(int x, int y, Dir dir, TankPanel tp) {   //构建坦克
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tp = tp;
    }

    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, Tank.WIDTH, Tank.HEIGHT);
        g.setColor(c);

        //根据炮筒的方向，画一条直线
        g.setColor(Color.ORANGE);
        switch (ptDir) {
            case L:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x-5, y+Tank.HEIGHT / 2);
                break;
            case LU:

                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x, y);
                break;
            case U:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH / 2, y - 5);
                break;
            case UR:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH, y);
                break;
            case R:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH + 5, y + Tank.HEIGHT / 2);
                break;
            case RD:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH, y + Tank.HEIGHT);
                break;
            case D:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x + Tank.WIDTH / 2, y + Tank.HEIGHT + 5);
                break;
            case DL:
                g.drawLine(x + Tank.WIDTH / 2, y + Tank.HEIGHT / 2, x, y + Tank.HEIGHT );
                break;
        }
        g.setColor(c);

        this.move();
    }

    //tank的移动是根据方向来移动
    public void move() {
        switch (dir) {
            case L:
                x -= speed;
                break;
            case LU:
                x -= speed;
                y -= speed;
                break;
            case U:
                y -= speed;
                break;
            case UR:
                x += speed;
                y -= speed;
                break;
            case R:
                x += speed;
                break;
            case RD:
                x += speed;
                y += speed;
                break;
            case D:
                y += speed;
                break;
            case DL:
                x -= speed;
                y += speed;
                break;
            case STOP:
                break;
        }

        if(this.dir != Dir.STOP) {
            this.ptDir = dir;
        }

        //坦克越界检查
        checkBounds();
    }

    private void checkBounds() {

        if(this.x < 0)
            this.x = 0;
        if(this.x > TankClient.GAME_WIDTH - Tank.WIDTH)
            this.x = TankClient.GAME_WIDTH - Tank.WIDTH;
        if(this.y < 0)
            this.y = 0;
        if(y > TankClient.GAME_HEIGHT - Tank.HEIGHT)
            this.y = TankClient.GAME_HEIGHT - Tank.HEIGHT;

    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            //对control键按键的处理
            case KeyEvent.VK_CONTROL:
//                tp.missile = fire();
                fire();
                break;

            case KeyEvent.VK_LEFT:
                //根据按键控制方向
                this.bL = true;
                break;

            case KeyEvent.VK_UP:
                this.bU = true;
                break;

            case KeyEvent.VK_RIGHT:
                this.bR = true;
                break;

            case KeyEvent.VK_DOWN:
                this.bD = true;
                break;

            default:
                break;
        }
        //根据按键来得到方向
        locationDir();
    }

    private void fire() {
        int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
        int y = this.y + Tank.HEIGHT / 2 - Missile.HEIGHT / 2;
        Missile missile = new Missile(x, y, this.ptDir, this.tp);
        this.tp.missileList.add(missile);
    }

    private void locationDir() {
        if (bL && !bU && !bR && !bD) this.dir = Dir.L;
        else if (bL && bU && !bR && !bD) this.dir = Dir.LU;
        else if (!bL && bU && !bR && !bD) this.dir = Dir.U;
        else if (!bL && bU && bR && !bD) this.dir = Dir.UR;
        else if (!bL && !bU && bR && !bD) this.dir = Dir.R;
        else if (!bL && !bU && bR && bD) this.dir = Dir.RD;
        else if (!bL && !bU && !bR && bD) this.dir = Dir.D;
        else if (bL && !bU && !bR && bD) this.dir = Dir.DL;
        else if (!bL && !bU && !bR && !bD) this.dir = Dir.STOP;
        System.out.println("坦克的方向dir= " + dir);
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                //根据按键控制方向
                this.bL = false;
                break;
            case KeyEvent.VK_UP:
                this.bU = false;
                break;
            case KeyEvent.VK_RIGHT:
                this.bR = false;
                break;
            case KeyEvent.VK_DOWN:
                this.bD = false;
                break;
            default:
                break;
        }
        //根据按键来得到方向
        locationDir();
    }


}
