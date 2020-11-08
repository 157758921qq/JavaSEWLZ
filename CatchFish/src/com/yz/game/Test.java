package com.yz.game;

/**
 * @Auther:yangwlz
 * @Date: 19:20 : 2020/10/29
 * @Description: com.yz.fish
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        GameFrame gf = new GameFrame();
        GamePanel gp = new GamePanel();
        gp.action();
        gf.add(gp);
        gf.setVisible(true);

    }
}
