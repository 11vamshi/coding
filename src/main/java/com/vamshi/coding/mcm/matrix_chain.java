package com.vamshi.coding.mcm;

import java.util.Arrays;

public class matrix_chain {
    public static void main(String[] args) {

        int[] arr = new int[]{10, 15, 20, 25};
        int N = arr.length;

        int[][] dp = new int[N][N];

        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        System.out.println("result is " + rec(1, N-1, N, arr, dp));

    }

    public static int rec(int i, int j, int n, int[] arr, int[][] dp){
        if(i == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int maxi = (int)Math.pow(10,7);
        for(int k = i; k < j; k++){
            int count = arr[i-1] * arr[k] * arr[j]
                    + rec(i, k, n, arr, dp)
                    + rec(k+1, j, n, arr, dp);
            maxi = Math.min(maxi, count);
        }

        return dp[i][j] = maxi;
    }

}
//         A  B  C
//       10 20 30 40
//       0  1  2  3
//
//k = 1 => A, BC
//10 * 20 * 40 + f(1,1) + f(2,3)
//
//k = 2 => AB, C
//10 * 30 * 40 * f(1,2) + f(3,3)
//
//
//f(2,3)
//
//k = 2
//20 * 30 * 40 + f(2,2) + f(3,3)
//
//f(1,2)
//k = 1
//10 * 20 * 30 + f(1,1) + f(2,2)
//
//
//          A  B  C   D
//         10 20 30 40 50
//         0  1  2  3  4
//
//i=1
//AB CD
//k = 2
//10 * 30 * 50 + f(1,2) + f(3,4)





