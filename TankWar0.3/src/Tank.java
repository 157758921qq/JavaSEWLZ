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

    public Tank(int x, int y, Dir dir) {   //构建坦克
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(new Color(172, 220, 239));
        g.fillOval(x, y, 30, 30);
        g.setColor(c);
        this.move();
    }

    //tank的移动是根据方向来移动
    public void move(){
        switch(dir) {
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
        }
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
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

    private void locationDir() {
        if(bL && !bU && !bR && !bD) this.dir = Dir.L;
        else if(bL && bU && !bR && !bD) this.dir = Dir.LU;
        else if(!bL && bU && !bR && !bD) this.dir = Dir.U;
        else if(!bL && bU && bR && !bD) this.dir = Dir.UR;
        else if(!bL && !bU && bR && !bD) this.dir = Dir.R;
        else if(!bL && !bU && bR && bD) this.dir = Dir.RD;
        else if(!bL && !bU && !bR && bD) this.dir = Dir.D;
        else if(bL && !bU && !bR && bD) this.dir = Dir.DL;
        else if(!bL && !bU && !bR && !bD) this.dir = Dir.STOP;

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
