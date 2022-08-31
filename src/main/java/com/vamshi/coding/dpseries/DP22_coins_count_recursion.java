package com.vamshi.coding.dpseries;

// same as dp 20, except commented lines, and return type is long, since result can be big number

import java.util.Arrays;

public class DP22_coins_count_recursion {

    public static void main(String[] args) {


//        int[] num = new int[]{1, 2, 3};

        int[] num = new int[]{17, 10, 5};


        int x = 6;
        int n = num.length;

        long dp[][] = new long[n][x+1];
        for(long[] row:dp){
            Arrays.fill(row, -1);
        }

        long result = recursion(num,n-1,x, dp);
//        if(result >= Math.pow(10,9)){
//            result = -1;
//        }

        System.out.println(" result is " + result);
        printDp(n, x, dp);
    }

    public static long recursion(int[] arr, int n, int x, long[][] dp){

        // not needed since it will anyways be covered by below base case
//        if(maxWeight == 0){
//            //
//        }

        if(n == 0){
            if(x % arr[0] == 0){
//                return dp[n][x] = x/arr[0];
                return dp[n][x] = 1;
            }
//            return dp[n][x] = (int)Math.pow(10, 9);
            return dp[n][x] = 0;
        }

        if(dp[n][x] != -1){
            return dp[n][x];
        }

        long notTaken = recursion(arr,n-1,x, dp);

//        int taken = (int)Math.pow(10,9);
        long taken = 0;
        if(x >= arr[n]){
//            taken = 1 + recursion(arr,n,x-arr[n], dp);
              taken =       recursion(arr,n,x-arr[n], dp);
        }

//        return dp[n][x] = Math.min(taken, notTaken);
        return dp[n][x] = taken+notTaken;
    }


    private static void printDp(int n, int k, long[][] dp) {
        //printing dp
        for(int i=0; i < n; i++){
            for(int j=0; j <= k; j++){
                System.out.print(dp[i][j] + "\t");

            }
            System.out.println();
        }
    }

}

