package com.vamshi.coding.dpseries;

// things to remember
// you need a k+1 table


//int notTaken = recursion(arr,n-1,x, dp);
//
//        int taken = (int)Math.pow(10,9);
//        if(x >= arr[n]){
//        not moving to next index because same coin can be reused, infinite supply
//        taken = 1 + recursion(arr,n,x-arr[n], dp);
//        }

//if(result >= Math.pow(10,9)){
//        result = -1;
//        }

// TC with dp Reason: At max, there will be N*M calls and result stored in dp


// same as DP 19, except different base conditions and add '1' when taken
// s1 - s2 = d => s1 = d+s2;
// s1 + s2 = total    => d+s2 + s2 = total     => s2 = total-d/2

import java.util.Arrays;

public class DP20_min_coins_recursion {

    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {


//        int[] num = new int[]{1, 2, 3};

        int[] num = new int[]{17, 10, 5};


        int x = 6;
        int n = num.length;

        int dp[][] = new int[n][x+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        int result = recursion(num,n-1,x, dp);
        if(result >= Math.pow(10,9)){
            result = -1;
        }

        System.out.println(" result is " + result);
        printDp(n, x, dp);
    }

    public static int recursion(int[] arr, int n, int x, int[][] dp){

        // not needed since it will anyways be covered by below base case
//        if(maxWeight == 0){
//            //
//        }

        if(n == 0){
            if(x % arr[0] == 0){
                return dp[n][x] = x/arr[0];
            }
            return dp[n][x] = (int)Math.pow(10, 9);
        }

        if(dp[n][x] != -1){
            return dp[n][x];
        }

        int notTaken = recursion(arr,n-1,x, dp);

        int taken = (int)Math.pow(10,9);
        if(x >= arr[n]){
            taken = 1 + recursion(arr,n,x-arr[n], dp);
        }

        return dp[n][x] = Math.min(taken, notTaken);
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

