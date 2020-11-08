import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
    Dir ptDir;
    boolean isLive = true;
    Rectangle rect;



    public Missile(int x, int y, Dir ptDir, TankPanel tp) {
        this.x = x;
        this.y = y;
        this.ptDir = ptDir;
        this.tp = tp;
        rect = new Rectangle(this.x,this.y, Missile.WIDTH, Missile.HEIGHT);
    }

    public void draw(Graphics g) {
        if(isLive){
            Color c = g.getColor();
            g.setColor(new Color(172, 220, 239));
            g.fillOval(x, y, Missile.WIDTH, Missile.HEIGHT);
            g.setColor(c);
        }


        move();
        getRect();


    }

    private void move() {
        switch(ptDir) {
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

    //打击一辆坦克
    public boolean hitTank(EnemyTank et) {
        if(this.isLive && et.isLive) {    //都活着才撞击
            if(this.rect.intersects(et.rect)){
//System.out.println("子弹和坦克发生碰撞");
                this.isLive = false;
                //list中移除
                et.isLive = false;
                return true;
            }
        }
        return false;
    }

    //打击list中的敌方坦克
    public void hitTanks(List<EnemyTank> enemyTankList) {
        for (int i = 0; i < enemyTankList.size(); i++) {
            EnemyTank enemyTank = enemyTankList.get(i);
            if(enemyTank.isLive && this.isLive) {
                if(this.rect.intersects(enemyTank.rect)){
//System.out.println("子弹和坦克发生碰撞");
                    this.isLive = false;
                    //list中移除
                    enemyTank.isLive = false;
                    enemyTankList.remove(i);
                }
            }
        }
    }



    public void getRect() {
        rect.x = x;
        rect.y = y;
    }
}
