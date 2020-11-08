package client;

import javax.swing.*;

/**
 * @Auther:yangwlz
 * @Date: 21:24 : 2020/11/2
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class TankClient extends JFrame {

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;


    public void launchFrame() {
        this.setTitle("坦克大战01");
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
