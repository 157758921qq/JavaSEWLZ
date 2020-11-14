package client;

import java.awt.*;
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
    int id;
    TankPanel tp;
    int x, y;
    Dir dir;
    boolean isLive = true;
    Rectangle rect;
    boolean isGood;
    int tankId;

    private static int ID = 1;



    public Missile(int tankId, int x, int y, Dir dir, TankPanel tp, boolean isGood) {
        this.tankId = tankId;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tp = tp;
        rect = new Rectangle(this.x,this.y, Missile.WIDTH, Missile.HEIGHT);
        this.isGood = isGood;
        this.id = ID++;
    }

    public Missile( int x, int y, Dir dir, TankPanel tp, boolean isGood) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tp = tp;
        rect = new Rectangle(this.x,this.y, Missile.WIDTH, Missile.HEIGHT);
        this.isGood = isGood;
    }

    public void draw(Graphics g) {
        if(isLive){
            if(isGood){
                Color c = g.getColor();
                g.setColor(Color.MAGENTA);
                g.fillOval(x, y, Missile.WIDTH, Missile.HEIGHT);
                g.setColor(c);
            }
            else {
                Color c = g.getColor();
                g.setColor(Color.BLACK);
                g.fillOval(x, y, Missile.WIDTH, Missile.HEIGHT);
                g.setColor(c);
            }

        }

        move();

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
        rect.x = x;
        rect.y = y;

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





    public Rectangle getRect() {
        return new Rectangle(x,y, WIDTH,HEIGHT);
    }

    //子弹撞击坦克
    public boolean hitWithTank(Tank t) {
        if(this.isLive && this.isGood != t.isGood && t.life>0 && this.getRect().intersects(t.getRect())) {
            t.life -= 20;
            if(t.life <= 0) {
                //坦克死亡
                t.die();
            }
            this.isLive = false;
            MissileDeadMsg msg = new MissileDeadMsg(tankId, id);
            tp.nc.send(msg);
            //this.tp.explodeList.add(new client.Explode(x,y,this.tp));
            return true;
        }
        return false;
    }
}
