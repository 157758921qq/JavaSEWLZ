import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @Auther:yangwlz
 * @Date: 21:28 : 2020/11/2
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class TankPanel extends JPanel {

    Missile missile;
    Tank tank;
    //直接new一个外部类的内部类Outer.Inner inner=outer.new Inner();
    //Tank.Pt pt;




    public TankPanel() {
        tank = new Tank(50, 50, Dir.STOP, this);

        this.setFocusable(true);
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
        this.setBackground(new Color(125,125,125));   //172, 220, 239
        tank.draw(g);

        if(null != missile)
            missile.draw(g);


    }
}
