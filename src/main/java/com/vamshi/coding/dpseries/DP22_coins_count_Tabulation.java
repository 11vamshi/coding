package com.vamshi.coding.dpseries;

// same as DP20, for chnages in base conditions refer DP22 recursion, you need a long dp

import java.util.Arrays;

public class DP22_coins_count_Tabulation {

    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {


        int[] num = new int[]{1,2,3};


        int x = 7;
        int n = num.length;

        int dp[][] = new int[n][x+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        int result = tabulation(num,n,x, dp);
        if(result >= Math.pow(10,9)){
            result = -1;
        }

        System.out.println(" result is " + result);
        printDp(n, x, dp);

    }


    private static int tabulation(int[] arr, int n, int x, int[][] dp) {

        // same as DP20, for chnages in base conditions refer DP22 recursion
        return 1;
    }


    private static void printDp(int n, int k, int[][] dp) {
        //printing dp
        for(int i=0; i < n; i++){
            for(int j=0; j <= k; j++){
                System.out.print(dp[i][j] + "\t");

            }
            System.out.println();
        }
    }

}

