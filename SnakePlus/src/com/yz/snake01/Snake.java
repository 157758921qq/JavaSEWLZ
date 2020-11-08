package com.yz.snake01;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @Auther:yangwlz
 * @Date: 10:55 : 2020/10/16
 * @Description: com.yz.snake01
 * @version: 1.0
 */
public class Snake {
    GamePanel gp;
    int length = 3;
    int[] snakeX = new int[500];
    int[] snakeY = new int[500];
    String direction = "R";
    Boolean isDie;

    public Snake(GamePanel gp) {
            this.gp = gp;
            snakeX[0] = 135;
            snakeY[0] = 260;
            snakeX[1] = 110;
            snakeY[1] = 260;
            snakeX[2] = 85;
            snakeY[2] = 260;
            isDie = false;          //蛇是活着的
    }


   //蛇自己把自己画出来是最好的，它对自己更了解
    public void draw(Graphics g) {
        //在对应的坐标位置，将蛇对应的图片放进去
        //画蛇头

        switch (direction) {
            case "U" :
                Images.upImg.paintIcon(gp,g,snakeX[0],snakeY[0]);
                break;
            case "R" :
                Images.rightImg.paintIcon(gp,g,snakeX[0],snakeY[0]);
                break;
            case "D" :
                Images.downImg.paintIcon(gp,g,snakeX[0],snakeY[0]);
                break;
            case "L" :
                Images.leftImg.paintIcon(gp,g,snakeX[0],snakeY[0]);
                break;
        }

        //画蛇身子
        for (int i = 1; i < length; i++) {
            Images.bodyImg.paintIcon(gp, g, snakeX[i], snakeY[i]);
        }
        //Images.bodyImg.paintIcon(this,g,snakeX[2],snakeY[2]);


    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println("按键= " + keyCode);
        //初始化后，增加键盘监听
        //监听上下左右按键，改变方向，注意一点，
        if(keyCode == KeyEvent.VK_UP){
            if(!direction.equals("D"))       //不向下时，才能改变方向向上
                direction = "U";
        }
        if(keyCode == KeyEvent.VK_RIGHT){
            if(!direction.equals("L"))
                direction = "R";
        }
        if(keyCode == KeyEvent.VK_DOWN){
            if(!direction.equals("U"))
                direction = "D";
        }
        if(keyCode == KeyEvent.VK_LEFT){
            if(!direction.equals("R"))
                direction = "L";
        }
    }

    public void move() {
        System.out.println("-------");
        //定时器

        for (int i = length - 1; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }
        //蛇头后动
        switch (direction) {
            case "U" :
                snakeY[0] =  snakeY[0] - 25;
                break;
            case "R" :
                snakeX[0] =  snakeX[0] + 25;
                break;
            case "D" :
                snakeY[0] =  snakeY[0] + 25;
                break;
            case "L" :
                snakeX[0] =  snakeX[0] - 25;
                break;
        }
        checkBound();
    }

    private void checkBound() {
        //对蛇越界的处理
        if(snakeX[0] > 775){
            snakeX[0] = 10;
        }

        if(snakeX[0] < 10){
            snakeX[0] = 760;
        }

        if(snakeY[0] < 85)
            snakeY[0] = 535;

        if(snakeY[0] > 535)
            snakeY[0] = 85;
    }


    public void hitWithsFood(Food f) {
        //蛇头和食物的碰撞， 吃食物
        if(snakeX[0] == f.foodX && snakeY[0] == f.foodY){

            //score += 10;
            //产生一个爆炸, 放到List中
            this.gp.add(new Explode(this.gp.f.foodX, this.gp.f.foodY, this.gp));
            //new Explode(this.snakeX[0], this.snakeY[0],this.gp);


            gp.score.add10Score();
            length++;
            //随机产生食物的位置坐标 foodX 或  foodY
            // foodX [10, 35,    ,    760]   不是785， 30个25
            // foodY [85, 110,   ,    535]   不是560， 18个25

            f.foodX = (int) (Math.random() * 30) *25 + 10;
            f.foodY = (int) (Math.random() * 18) *25 + 85;
            for (int i = length-1; i > 0; i--) {
                //蛇身与食物重合
                if(snakeX[i] == f.foodX && snakeY[i] == f.foodY){
                    f.foodX = (int) (Math.random() * 30) *25 + 10;
                    f.foodY = (int) (Math.random() * 18) *25 + 85;
                }
            }

        }
    }

    //蛇头和蛇身体相碰，蛇死亡
    public boolean hitWithsbody() {
        for (int i = length-1; i >0 ; i--) {
            if(snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                isDie = true;
                return true;
            }
        }
        return false;
    }
}
