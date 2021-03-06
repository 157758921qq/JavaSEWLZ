package client;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @Auther:yangwlz
 * @Date: 10:50 : 2020/11/3
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Tank {
    int id;
    int x, y;                                                //坦克位置
    boolean bL = false, bU = false, bR = false, bD = false;  //记录左上右下的键是否被按下
    Dir dir;
    public static final int speed = 20;
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;
    public Rectangle rect;
//    Dir ptDir = Dir.D;
    TankPanel tp;
    boolean isMoving = false;
    int life = 100;
    boolean isLive = true;
    BloodBar bb = new BloodBar();
    boolean isGood;

    public Tank() {
    }

    public Tank(int x, int y, Dir dir, boolean isGood, TankPanel tp) {   //构建坦克
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.isGood = isGood;
        this.tp = tp;
        rect = new Rectangle(this.x, this.y, Tank.WIDTH,Tank.HEIGHT);
    }

    public void draw(Graphics g) {
        if(!isLive) return;

        if(isGood){
            Color c = g.getColor();
            g.setColor(Color.MAGENTA);
            g.setFont(new Font("微软雅黑", 10, 15));
            g.drawString("TankId:"+id, x-30, y-15);        //画坦克的ID
            g.fillOval(x, y, Tank.WIDTH, Tank.HEIGHT);


            bb.draw(g);
            //根据炮筒的方向，画一条直线
            switch (dir) {
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
        } else {
            Color c = g.getColor();
            g.setColor(Color.BLACK);
            g.setFont(new Font("微软雅黑", 10, 15));
            g.drawString("TankId:"+id, x-30, y-15);        //画坦克的ID
            g.fillOval(x, y, Tank.WIDTH, Tank.HEIGHT);


            bb.draw(g);
            //根据炮筒的方向，画一条直线

            switch (dir) {
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
        }

        this.move();
        getRect();

    }

    //tank的移动是根据方向来移动
    public void move() {
        if(!isMoving) return;
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
            //this.ptDir = dir;
        //坦克越界检查
        checkBounds();
    }

    private void checkBounds() {

        if(this.x < 0)
            this.x = 0;

        if(this.y < 0)
            this.y = 1;

        if(this.x > TankClient.GAME_WIDTH - Tank.WIDTH)
            this.x = TankClient.GAME_WIDTH - Tank.WIDTH;

        if(y > TankClient.GAME_HEIGHT - Tank.HEIGHT -30)
            this.y = TankClient.GAME_HEIGHT - Tank.HEIGHT-30;

    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            //对control键按键的处理

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
        rect.x = x;
        rect.y = y;
        //根据按键来得到方向
        locationDir();
    }

    private Missile fire() {
        int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
        int y = this.y + Tank.HEIGHT / 2 - Missile.HEIGHT / 2;
        Missile missile = new Missile(this.id, x, y, this.dir, this.tp, isGood);
        this.tp.missileList.add(missile);
        MissileNewMsg msg = new MissileNewMsg(missile);
        tp.nc.send(msg);
        return missile;
    }
//    public Missile fire(Dir dir) {
//        int x = this.x + Tank.WIDTH / 2 - Missile.WIDTH / 2;
//        int y = this.y + Tank.HEIGHT / 2 - Missile.HEIGHT / 2;
//        Missile missile = new Missile(this.id, x, y, dir, this.tp, true);
//        this.tp.missileList.add(missile);
//        return missile;
//    }

//    private void superFire() {
//        Dir[] dirs = Dir.values();
//        for (int i = 0; i < 8; i++) {
//            fire(dirs[i]);
//        }
//    }

    private void locationDir() {
        Dir oldDir = this.dir;
        if(!bL && !bU && !bR && !bD){
            isMoving = false;
        } else {
            isMoving = true;
            if (bL && !bU && !bR && !bD) this.dir = Dir.L;
            else if (bL && bU && !bR && !bD) this.dir = Dir.LU;
            else if (!bL && bU && !bR && !bD) this.dir = Dir.U;
            else if (!bL && bU && bR && !bD) this.dir = Dir.UR;
            else if (!bL && !bU && bR && !bD) this.dir = Dir.R;
            else if (!bL && !bU && bR && bD) this.dir = Dir.RD;
            else if (!bL && !bU && !bR && bD) this.dir = Dir.D;
            else if (bL && !bU && !bR && bD) this.dir = Dir.DL;
        }

        if(dir != oldDir) {             //方向改变了，坦克移动的消息发给服务器端
            TankMoveMsg tankMoveMsg = new TankMoveMsg(x, y, this.id, this.dir);
            tp.nc.send(tankMoveMsg);

        }
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_CONTROL:
                fire();
                //superFire();
                break;
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

    public Rectangle getRect() {
        return new Rectangle(x,y, WIDTH,HEIGHT);
    }

//    public boolean hitWithFood(Food f) {
//        if(f.isLive) {
//            if(this.getRect().intersects(f.getRect())) {
//                f.isLive = false;
//                this.life = 100;
//                return true;
//            }
//        }
//        return false;
//    }

    public void die() {
        this.isLive = false;
        TankDeadMsg msg = new TankDeadMsg(this.id);
        tp.nc.send(msg);
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
