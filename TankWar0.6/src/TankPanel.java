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
    //EnemyTank enemyTank = new EnemyTank(400, 350, Dir.U, this);
    //直接new一个外部类的内部类Outer.Inner inner=outer.new Inner();
    //Tank.Pt pt;
    List<Missile> missileList = new ArrayList<>();
    List<EnemyTank> enemyTankList = new ArrayList<>();
    Random rd = new Random();




    public TankPanel() {
        this.setFocusable(true);


        tank = new Tank(50, 50, Dir.STOP, this);
        for (int i = 0; i < 14; i++) {
            enemyTankList.add(new EnemyTank(200 + rd.nextInt(40)*(i+1), 300 + rd.nextInt(30)*(i+1), Dir.U, this));
        }

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
        g.drawString("弹药数量= " + missileList.size(), 20, 20);
        g.drawString("敌方坦克数量= " + enemyTankList.size(), 200, 20);
        g.setColor(c);

        this.setBackground(Color.WHITE);   //172, 220, 239
        tank.draw(g);

        for (int i = 0; i < missileList.size(); i++) {
            Missile missile = missileList.get(i);
            if(!missile.isLive)
                missileList.remove(i);
            missile.draw(g);
            missile.hitTanks(enemyTankList);
        }



        for (int i = 0; i < enemyTankList.size(); i++) {
            EnemyTank enemyTank = enemyTankList.get(i);
            if(!enemyTank.isLive)
                enemyTankList.remove(i);
            enemyTank.draw(g);
        }

        //enemyTank.draw(g);


//        if(null != missile)
//            missile.draw(g);


    }
}
