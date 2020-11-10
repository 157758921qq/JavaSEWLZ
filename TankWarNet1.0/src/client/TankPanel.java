package client;

import server.TankServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Auther:yangwlz
 * @Date: 21:28 : 2020/11/2
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class TankPanel extends JPanel {

    Tank tank;
    NetClient nc;
    //client.EnemyTank enemyTank = new client.EnemyTank(400, 350, client.Dir.U, this);
    //直接new一个外部类的内部类Outer.Inner inner=outer.new Inner();
    //client.Tank.Pt pt;
    List<Missile> missileList = new ArrayList<>();
    //List<client.EnemyTank> enemyTankList = new ArrayList<>();
    //List<client.Explode> explodeList = new ArrayList<>();
    Random rd = new Random();
//    client.Wall w1 = new client.Wall(100, 200, 20, 150, this);
//    client.Wall w2 = new client.Wall(500, 100, 300, 20, this);
    List<Tank> tanks = new ArrayList<>();


    public TankPanel() {
        this.setFocusable(true);

        tank = new Tank(50, 50, Dir.D, this);
        nc = new NetClient(this);
        nc.connect("127.0.0.1", TankServer.TCP_PORT);



//        for (int i = 0; i < 14; i++) {
//            enemyTankList.add(new client.EnemyTank(50 + 40*(i+1), 400 + rd.nextInt(30)*(i+1), client.Dir.U, this));
//        }

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                tank.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                tank.keyReleased(e);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        //g.drawString("弹药数量= " + missileList.size(), 20, 20);
        //g.drawString("敌方坦克数量= " + enemyTankList.size(), 200, 20);
        g.setColor(c);

        this.setBackground(Color.CYAN);   //172, 220, 239
        tank.draw(g);

        for (int i = 0; i < missileList.size(); i++) {
            Missile missile = missileList.get(i);
            if(!missile.isLive)
                missileList.remove(i);
            missile.draw(g);
            //missile.hitTanks(enemyTankList);
            //missile.hitWall(w1);
            //missile.hitWall(w2);
            //missile.hitWithTank(tank);
        }
//
//        for(client.Explode e : explodeList) {
//            e.draw(g);
//        }

//        for (int i = 0; i < enemyTankList.size(); i++) {
//            client.EnemyTank enemyTank = enemyTankList.get(i);
//            if(!enemyTank.isLive)
//                enemyTankList.remove(i);
//            else {
//                enemyTank.draw(g);
//                enemyTank.hitsWithBadTanks(enemyTankList);
//                enemyTank.hitWall(w1);
//                enemyTank.hitWall(w2);
//            }
//        }

//        w1.draw(g);
//        w2.draw(g);
        //enemyTank.draw(g);


//        if(null != missile)
//            missile.draw(g);

        for( Tank t : tanks) {
            t.draw(g);
        }


    }
}
