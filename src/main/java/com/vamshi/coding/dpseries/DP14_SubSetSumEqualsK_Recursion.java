package com.vamshi.coding.dpseries;

import java.util.Arrays;


// things to remember
// you need a k+1 table
// base conditions changed a little bit compared to striver's ans to make it easy tp understand
// next solutions

// TC exponential without dp
// TC with dp Reason: At max, there will be N*M calls of recursion. because might be stored in dp

public class DP14_SubSetSumEqualsK_Recursion {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 4, 8, 6};

        int n = arr.length;
        int k = 5;


        int dp[][] = new int[n][k+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        System.out.println(" result is " + recursion(arr,n-1,k, dp));

    }

    public static boolean recursion(int[] arr, int n, int k, int[][] dp){

        if(n == 0){
            if(k==0 || k == arr[0])
                return true;
            return false;
        }

        if(dp[n][k] != -1){
            return dp[n][k] == 1;
        }

        boolean notTaken = recursion(arr,n-1,k, dp);

        boolean taken = false;
        if(k >= arr[n]){
            taken = recursion(arr,n-1,k-arr[n], dp);
        }
        dp[n][k] = (taken || notTaken)?1:0;
        return taken || notTaken;

    }

    private static void printDp(int n, int k, boolean[][] dp) {
        //printing dp
        for(int i=0; i < n; i++){
            for(int j=0; j <= k; j++){
                System.out.print(dp[i][j] + "\t");

            }
            System.out.println();
        }
    }

}

