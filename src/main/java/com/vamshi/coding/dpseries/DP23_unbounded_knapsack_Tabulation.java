package com.vamshi.coding.dpseries;

// things to remember
// you need a k+1 table


// TC with dp Reason: At max, there will be N*M calls and result stored in dp

// same as DP 18, except base condition changes the way we fill dp, we fill
// dp from arr[0] to

import java.util.Arrays;

public class DP23_unbounded_knapsack_Tabulation {

    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {

//        int[] weight = new int[]{1, 2, 4, 5};
//        int[] value = new int[]{5, 4, 8, 6};
//        int n = weight.length;
//        int maxWeight = 5;

        int[] weight = new int[]{5,10,20};
        int[] value = new int[]{7, 2, 4};
        int n = weight.length;
        int maxWeight = 15;

        int dp[][] = new int[n][maxWeight+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        System.out.println(" max value " + tabulation(weight,value,n,maxWeight, dp));
        printDp(n,maxWeight,dp);

    }

    private static int tabulation(int[] arr, int[] val, int n, int maxWeight, int[][] dp) {

        for(int i=0; i<=maxWeight; i++){
            dp[0][i] = (val[0])*(i/arr[0]);
        }

        for(int index=1; index < n; index++){

            for(int currentTarget=0; currentTarget <= maxWeight; currentTarget++){

                // target could have been achieved with subset ending at previous index
                int notTaken = dp[index-1][currentTarget];

                int taken = (int)Math.pow(10,-9);

                if(currentTarget >= arr[index]){
                    taken = val[index] + dp[index][currentTarget-arr[index]];
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

