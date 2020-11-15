package client;

/**
 * @Auther:yangwlz
 * @Date: 21:32 : 2020/11/2
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        TankClient tc = new TankClient();
        TankPanel tp = new TankPanel();
        tc.add(tp);
        tc.launchFrame();

        new Thread(()-> {
            for(;;){
                try {
                    Thread.sleep(100);
                    tp.repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ).start();
    }
}
