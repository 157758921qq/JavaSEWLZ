package com.yz.test01;

/**
 * @Auther:yangwlz
 * @Date: 20:46 : 2020/10/15
 * @Description: com.yz.test01
 * @version: 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        int[][] arr = new int[3][];
        arr[0] = new int[]{3, 6};
        arr[1] = new int[]{2, 4, 6};
        arr[2] = new int[]{0};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
