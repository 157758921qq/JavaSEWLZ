import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

/**
 * @Auther:yangwlz
 * @Date: 10:50 : 2020/11/3
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class EnemyTank {
    boolean isLive = true;
    int x, y;                                                //坦克位置
    int oldX, oldY;
    Dir dir;
    public static final int speed = 10;
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    Dir ptDir = Dir.D;
    Random rd = new Random();
    Random r = new Random();
    TankPanel tp;
    Rectangle rect;
    int step = rd.nextInt(12) + 3;
    int life = 100;
    BloodBar bb = new BloodBar();

    public EnemyTank() {
    }

    public EnemyTank(int x, int y, Dir dir, TankPanel tp) {   //构建敌方坦克
        this.x = x;
        this.y = y;
        this.oldX = x;
        this.oldY = y;
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
            bb.draw(g);
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
        rect.x = x;
        rect.y = y;


    }

    //tank的移动是根据方向来移动
    public void move() {
        oldX = x;
        oldY = y;
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
        }

            this.ptDir = dir;

        rect.x = x;
        rect.y = y;
        //坦克越界检查
        checkBounds();

        Dir[] dirs = Dir.values();
        if(step == 0) {                         //step 等于 0， 时转方向
            step = rd.nextInt(12) + 3;
            int i = rd.nextInt(dirs.length);
            dir = dirs[i];
        }
        step--;


        if(r.nextInt(100) > 96)
            this.fire();
    }

    private void fire() {
        int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
        int y = this.y + Tank.HEIGHT / 2 - Missile.HEIGHT / 2;
        Missile missile = new Missile(x, y, this.ptDir, this.tp, false);
        this.tp.missileList.add(missile);
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

    public boolean hitsWithBadTanks(List<EnemyTank> enemyTankList) {
        for (int i = 0; i < enemyTankList.size(); i++) {
            EnemyTank enemyTank = enemyTankList.get(i);
            if(this != enemyTank) {
                if(this.isLive && enemyTank.isLive && this.getRect().intersects(enemyTank.getRect())) {
                    this.stay();
                    enemyTank.stay();
                    return true;
                }
            }
        }
        return false;
    }

    private void stay() {
        this.x = oldX;
        this.y = oldY;
    }

    public boolean hitWall(Wall w) {
        if(this.isLive && this.getRect().intersects(w.getRect())) {
            this.stay();
            return true;
        }
        return false;
    }


    //血条
    class BloodBar {
        public void draw(Graphics g) {
            Color c = g.getColor();
            g.setColor(Color.BLACK);
            g.drawRect(x-2, y-10, WIDTH+2,10);
            g.setColor(c);

            g.setColor(Color.YELLOW);
            int w = WIDTH * life/100;
            g.fillRect(x,y-8, w,6);
            g.setColor(c);
        }
    }
}
