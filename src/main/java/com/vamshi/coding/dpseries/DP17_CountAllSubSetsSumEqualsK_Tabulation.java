package com.vamshi.coding.dpseries;

import java.util.Arrays;

// things to remember
// you need a k+1 table


// TC with dp Reason: At max, there will be N*M calls and result stored in dp

// same as DP 14, except dp is int dp instead of boolean, and to consider 0's
// in input string base conditions differ and inner loop at 50 starts at index=0

public class DP17_CountAllSubSetsSumEqualsK_Tabulation {

    public static void main(String[] args) {

        int[] arr = new int[]{4, 3, 2, 1};

        int n = arr.length;
        int k = 5;

        int[][] dp = new int[n][k+1];

        tabulation(arr, n, k, dp);

        //printing dp
        printDp(n, k, dp);

        System.out.println("result is "+ dp[n-1][k]);
    }

    private static void tabulation(int[] arr, int n, int k, int[][] dp) {
        for(int[] row: dp){
            Arrays.fill(row, 0);
        }

        if(arr[0] == 0){
            dp[0][0] = 2;
        }else{
            dp[0][0] = 1;
        }

        // first element can be part of subset, if it is less than or = to target
        if(k >= arr[0] && arr[0]!=0){
            dp[0][arr[0]] = 1;
        }


        for(int index=1; index < n; index++){

            for(int currentTarget=0; currentTarget <= k; currentTarget++){

                int taken = 0;
                int notTaken = 0;

                // target could have been achieved with subset ending at previous index
                notTaken = dp[index-1][currentTarget];


                // target-arr[index] could have been achieved with subset ending at previous index
                if(currentTarget >= arr[index]){
                    taken = dp[index-1][currentTarget-arr[index]];
                }


                dp[index][currentTarget] = taken+notTaken;
            }

        }
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

