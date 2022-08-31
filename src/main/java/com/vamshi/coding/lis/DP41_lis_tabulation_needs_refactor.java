package com.vamshi.coding.lis;

import java.util.Arrays;

// things to remember, dp size should match the recursion call recursion(s,t,n-1,m-1,dp)
//

public class DP41_lis_tabulation_needs_refactor {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 4, 11, 1, 16, 8};

        int n = arr.length;

        int[][] dp = new int[n+1][n+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }


        System.out.println(" result is " + tabulation(arr, n,dp));
        printDp(n+1,n+1,dp);

    }

    private static int tabulation(int[] arr, int size, int[][] dp) {
        for(int i=0; i <= size ; i++){
            dp[size][i] = 0;
        }
        int notTaken;
        int taken = 0;
        for(int index=size-1; index >=0;index--){
            for(int prev_index=index-1; prev_index >=-1;prev_index--){
                 notTaken = dp[index+1][prev_index+1];
                if(prev_index == -1 || arr[index] > arr[prev_index]){
                    taken = 1 + dp[index+1][index+1];
                }
                dp[index][prev_index+1] = Math.max(taken, notTaken);
            }
        }
        return dp[0][0];

    }

    private static void printDp(int n, int k, int[][] dp) {
        //printing dp
        for(int i=0; i < n; i++){
            for(int j=0; j < k; j++){
                System.out.print(dp[i][j] + "\t");

            }
            System.out.println();
        }
    }

}
