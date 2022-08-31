package com.vamshi.coding.dpseries;

// things to remember
// you need a k+1 table


// TC with dp Reason: At max, there will be N*M calls and result stored in dp

// same as DP 18, except base conditions change, and the value of array element is in different array
// s1 - s2 = d => s1 = d+s2;
// s1 + s2 = total    => d+s2 + s2 = total     => s2 = total-d/2

import java.util.Arrays;

public class DP23_unbounded_knapsack_Recursion {

    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {


        int[] weight = new int[]{5,10,20};
        int[] value = new int[]{7, 2, 4};
        int n = weight.length;
        int maxWeight = 15;

        int dp[][] = new int[n][maxWeight+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        System.out.println(" result is " + recursion(weight,value,n-1,maxWeight, dp));


    }


    public static int recursion(int[] weight, int[] value, int n, int maxWeight, int[][] dp){

        // not needed since it will anyways be covered by below base case
//        if(maxWeight == 0){
//            //
//        }

        if(n == 0){
            if(maxWeight >= weight[0]){
                return (value[0])*(maxWeight/weight[0]);
            }
            return 0;
        }

        if(dp[n][maxWeight] != -1){
            return dp[n][maxWeight];
        }

        int notTaken = recursion(weight,value,n-1,maxWeight, dp);

        int taken = (int)Math.pow(10,-9);
        if(maxWeight >= weight[n]){
            // difference from 0,1 since you can take same item multiple times
            taken = value[n] + recursion(weight,value,n,maxWeight-weight[n], dp);
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

