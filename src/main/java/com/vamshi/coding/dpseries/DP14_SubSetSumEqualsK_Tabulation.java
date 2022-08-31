package com.vamshi.coding.dpseries;

import java.util.Arrays;


// things to remember
// you need a k+1 table
// base conditions changed a little bit compared to striver's ans to make it easy tp understand
// next solutions

// TC exponential without dp
// TC with dp Reason: At max, there will be N*M calls of recursion. because might be stored in dp

public class DP14_SubSetSumEqualsK_Tabulation {

    public static void main(String[] args) {

        int[] arr = new int[]{4, 3, 2, 1};

        int n = arr.length;
        int k = 5;

        boolean[][] dp = new boolean[n][k+1];

        tabulation(arr, n, k, dp);

        //printing dp
        printDp(n, k, dp);

        System.out.println("result is "+ dp[n-1][k]);
    }

    private static void tabulation(int[] arr, int n, int k, boolean[][] dp) {
        for(boolean[] row: dp){
            Arrays.fill(row, false);
        }


        dp[0][0] = true;

        // first element can be part of subset, if it is less than or = to target
        if(k >= arr[0]){
            dp[0][arr[0]] = true;
        }

        boolean taken = false;
        boolean notTaken = false;
        for(int index=1; index < n; index++){
            for(int currentTarget=0; currentTarget <= k; currentTarget++){
                // target could have been achieved with subset ending at previous index
                notTaken = dp[index-1][currentTarget];


                // target-arr[index] could have been achieved with subset ending at previous index
                if(currentTarget >= arr[index]){
                    taken = dp[index-1][currentTarget-arr[index]];
                }


                dp[index][currentTarget] = taken||notTaken;
            }

        }
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

