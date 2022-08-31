package com.vamshi.coding.dpseries;

// things to remember
// you need a k+1 table


// TC with dp Reason: At max, there will be N*M calls and result stored in dp

// same as DP 18, except base condition changes the way we fill dp, we fill
// dp from arr[0] to

import java.util.Arrays;

public class DP19_0_1_knapsack_Tabulation {

    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {

//        int[] weight = new int[]{1, 2, 4, 5};
//        int[] value = new int[]{5, 4, 8, 6};
//        int n = weight.length;
//        int maxWeight = 5;

        int[] weight = new int[]{35, 45, 21, 9, 13,
                25, 37, 38, 36, 41, 21, 46, 43, 1, 4, 34, 31, 41, 39, 27, 5, 1, 33, 38, 1, 27, 1};
        int[] value = new int[]{11, 39, 61, 61, 67, 1, 7, 81, 29, 5, 21, 1, 1, 65, 28, 1, 23, 33, 79, 1,
                13, 45, 41, 51, 28, 49, 79 };
        int n = weight.length;
        int maxWeight = 451;

        int dp[][] = new int[n][maxWeight+1];
        for(int[] row:dp){
            Arrays.fill(row, 0);
        }



        System.out.println(" max value " + tabulation(weight,value,n,maxWeight, dp));
        printDp(n,maxWeight,dp);

    }


    private static int tabulation(int[] arr, int[] val, int n, int maxWeight, int[][] dp) {

        for(int i=arr[0]; i<=maxWeight; i++){
            dp[0][i] = val[0];
        }

        for(int index=1; index < n; index++){

            for(int currentTarget=0; currentTarget <= maxWeight; currentTarget++){

                // target could have been achieved with subset ending at previous index
                int notTaken = dp[index-1][currentTarget];

                int taken = (int)Math.pow(10,-9);
                // target-arr[index] could have been achieved with subset ending at previous index
                if(currentTarget >= arr[index]){
                    taken = val[index] + dp[index-1][currentTarget-arr[index]];
                }


                dp[index][currentTarget] = Math.max(taken,notTaken);
            }

        }
        return dp[n-1][maxWeight];
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

