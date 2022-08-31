package com.vamshi.coding.lis;

import java.util.Arrays;

// things to remember, dp size should match the recursion call recursion(s,t,n-1,m-1,dp)
//

public class DP41_lis_recursion {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 4, 11, 1, 16, 8};

        int n = arr.length;

        int[][] dp = new int[n][n+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }


        System.out.println(" result is " + recursion(arr, 0, -1,n,dp));
        printDp(n,n+1,dp);

    }

    private static int recursion(int[] arr, int index, int prev_index, int size, int[][] dp) {
        if(index == size){
            return 0;
        }
        if(dp[index][prev_index+1] != -1){
            return dp[index][prev_index+1];
        }

        int notTaken = recursion(arr, index+1, prev_index,size,dp);
        int taken = (int)Math.pow(10,-7);
        if(prev_index == -1 || arr[index] > arr[prev_index]){
            taken = 1+ recursion(arr, index+1, index,size,dp);
        }
        return dp[index][prev_index+1] = Math.max(taken, notTaken);
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
