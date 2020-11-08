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
    int x = 50;
    int y = 50;

    public TankPanel() {
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_LEFT:
                        x -= 5;
                        break;

                    case KeyEvent.VK_UP:
                        y -= 5;
                        break;

                    case KeyEvent.VK_RIGHT:
                        x += 5;
                        break;

                    case KeyEvent.VK_DOWN:
                        y += 5;
                        break;

                    default:
                        break;

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(new Color(172, 220, 239));


        Color c = g.getColor();
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 30, 30);
        g.setColor(c);



    }
}
