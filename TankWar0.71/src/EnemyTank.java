import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @Auther:yangwlz
 * @Date: 10:50 : 2020/11/3
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class EnemyTank {
    boolean isLive = true;
    int x, y;                                                //坦克位置
    Dir dir;
    public static final int speed = 5;
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    Dir ptDir = Dir.D;
    TankPanel tp;
    Rectangle rect;

    public EnemyTank() {
    }

    public EnemyTank(int x, int y, Dir dir, TankPanel tp) {   //构建坦克
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tp = tp;
        rect = new Rectangle(this.x, this.y, EnemyTank.WIDTH,EnemyTank.HEIGHT);
    }

    public void draw(Graphics g) {

        if(isLive){
            Color c = g.getColor();
            g.setColor(Color.DARK_GRAY);
            g.fillOval(x, y, EnemyTank.WIDTH, EnemyTank.HEIGHT);
            g.setColor(c);

            //根据炮筒的方向，画一条直线
            g.setColor(Color.DARK_GRAY);
            switch (ptDir) {
                case L:
                    g.drawLine(x + EnemyTank.WIDTH / 2, y + EnemyTank.HEIGHT / 2, x-5, y+ EnemyTank.HEIGHT / 2);
                    break;
                case LU:

                    g.drawLine(x + EnemyTank.WIDTH / 2, y + EnemyTank.HEIGHT / 2, x, y);
                    break;
                case U:
                    g.drawLine(x + EnemyTank.WIDTH / 2, y + EnemyTank.HEIGHT / 2, x + EnemyTank.WIDTH / 2, y - 5);
                    break;
                case UR:
                    g.drawLine(x + EnemyTank.WIDTH / 2, y + EnemyTank.HEIGHT / 2, x + EnemyTank.WIDTH, y);
                    break;
                case R:
                    g.drawLine(x + EnemyTank.WIDTH / 2, y + EnemyTank.HEIGHT / 2, x + EnemyTank.WIDTH + 5, y + EnemyTank.HEIGHT / 2);
                    break;
                case RD:
                    g.drawLine(x + EnemyTank.WIDTH / 2, y + EnemyTank.HEIGHT / 2, x + EnemyTank.WIDTH, y + EnemyTank.HEIGHT);
                    break;
                case D:
                    g.drawLine(x + EnemyTank.WIDTH / 2, y + EnemyTank.HEIGHT / 2, x + EnemyTank.WIDTH / 2, y + EnemyTank.HEIGHT + 5);
                    break;
                case DL:
                    g.drawLine(x + EnemyTank.WIDTH / 2, y + EnemyTank.HEIGHT / 2, x, y + EnemyTank.HEIGHT );
                    break;
            }
            g.setColor(c);
        }

        this.move();
        getRect();

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

            this.ptDir = dir;
        rect.x = x;
        rect.y = y;
        //坦克越界检查
        checkBounds();
    }

    private void checkBounds() {

        if(this.x < 0)
            this.x = 0;
        if(this.x > TankClient.GAME_WIDTH - EnemyTank.WIDTH)
            this.x = TankClient.GAME_WIDTH - EnemyTank.WIDTH;
        if(this.y < 0)
            this.y = 2;
        if(y > TankClient.GAME_HEIGHT - EnemyTank.HEIGHT -30)
            this.y = TankClient.GAME_HEIGHT - EnemyTank.HEIGHT -30;

    }


    public Rectangle getRect() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}
