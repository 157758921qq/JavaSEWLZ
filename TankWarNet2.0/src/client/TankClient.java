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


    public void launchFrame() {
        this.setTitle("坦克大战01");
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    class ConnDialog extends JDialog {
        Button b = new Button("确定");
        TextField tfIP = new TextField("127.0.0.1", 12);
        TextField tfPort = new TextField(""+ TankServer.TCP_PORT, 4);
        TextField tfMyUDPPort = new TextField("2223", 4);

        public ConnDialog() {
            super(TankClient.this, true);
            this.setLayout(new FlowLayout());
            this.add(new Label("IP:"));
            this.add(tfIP);
            this.add(new Label("Port:"));
            this.add(tfPort);
            this.add(new Label("My UDP Port:"));
            this.add(tfMyUDPPort);
            this.add(b);
            this.setLocation(300, 300);
            this.pack();
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    setVisible(false);
                }
            });

            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String IP = tfIP.getText().trim();
                    int port = Integer.parseInt(tfPort.getText().trim());
                    int myUDPPort = Integer.parseInt(tfMyUDPPort.getText().trim());

                    setVisible(false);
                }
            });
        }
    }
}
