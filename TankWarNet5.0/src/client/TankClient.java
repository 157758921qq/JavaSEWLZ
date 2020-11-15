package client;

import server.TankServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther:yangwlz
 * @Date: 21:24 : 2020/11/2
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class TankClient extends JFrame {

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    //ConnDialog dialog = new ConnDialog();


    public void launchFrame() {
        this.setTitle("坦克大战01");
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
