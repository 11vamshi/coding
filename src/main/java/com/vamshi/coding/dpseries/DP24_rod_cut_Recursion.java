package com.vamshi.coding.dpseries;

// things to remember
// you need a k+1 table


// TC with dp Reason: At max, there will be N*M calls and result stored in dp

// same as unbounded knapsack
// same as DP 18, except base conditions change, and the value of array element is in different array
// s1 - s2 = d => s1 = d+s2;
// s1 + s2 = total    => d+s2 + s2 = total     => s2 = total-d/2

import java.util.Arrays;

public class DP24_rod_cut_Recursion {

    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {

        int[] value = new int[]{2, 5, 7, 8, 10};
        int n = value.length;
        int maxWeight = 5;

        int dp[][] = new int[n][maxWeight+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        System.out.println(" result is " + recursion(value,n-1,maxWeight, dp));


    }


    public static int recursion(int[] value, int n, int maxWeight, int[][] dp){

        // not needed since it will anyways be covered by below base case
//        if(maxWeight == 0){
//            //
//        }

        if(n == 0){
            if(maxWeight >= n+1){
                return (value[0])*(maxWeight/(n+1));
            }
            return 0;
        }

        if(dp[n][maxWeight] != -1){
            return dp[n][maxWeight];
        }

        int notTaken = recursion(value,n-1,maxWeight, dp);

        int taken = (int)Math.pow(10,-9);
        if(maxWeight >= n+1){
            // difference from 0,1 since you can take same item multiple times
            taken = value[n] + recursion(value,n,maxWeight-(n+1), dp);
        }


        return dp[n][maxWeight] = Math.max(taken, notTaken);
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

