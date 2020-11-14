package client;

import java.io.DataInputStream;
import java.net.DatagramSocket;

/**
 * @Auther:yangwlz
 * @Date: 9:50 : 2020/11/14
 * @Description: client
 * @version: 1.0
 */
public interface Msg {
    int TANK_NEW_MSG = 1;
    int TANK_MOVE_MSG = 2;
    int MISSILE_NEW_MSG = 3;
    int TANK_DEAD_MSG = 4;
    int MISSILE_DEAD_MSG = 5;

    public void send(DatagramSocket ds, String IP, int udpPort) ;
    public void parse(DataInputStream dis);
}






















