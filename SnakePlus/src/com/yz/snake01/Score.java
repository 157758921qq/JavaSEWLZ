package com.yz.snake01;

/**
 * @Auther:yangwlz
 * @Date: 18:57 : 2020/10/16
 * @Description: com.yz.snake01
 * @version: 1.0
 */
public class Score {
    private int score;
    private GamePanel gp;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Score() {
    }

    public Score(int score, GamePanel gp) {
        this.score = score;
        this.gp = gp;
    }

    public void add10Score() {
        score += 10;
    }

}
