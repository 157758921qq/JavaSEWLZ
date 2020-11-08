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
    Tank tank = new Tank(50, 50, Dir.R);

    public TankPanel() {
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
        tank.paint(g);

    }
}
