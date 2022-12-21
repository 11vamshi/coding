package com.vamshi.coding.dpseries;

// things to remember
// you need a k+1 table


// TC with dp Reason: At max, there will be N*M calls and result stored in dp

// same as DP 18, except base condition changes the way we fill dp, we fill
// dp from arr[0] to

import java.util.Arrays;


public class DP20_min_coins_Tabulation {

    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {


        int[] num = new int[]{1,2,5};


        int x = 11;
        int n = num.length;

        int dp[][] = new int[n][x+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        int result = tabulation(num,n,x, dp);
        if(result >= Math.pow(10,9)){
            result = -1;
        }

        System.out.println(" result is " + result);
        printDp(n, x, dp);

    }


    private static int tabulation(int[] arr, int n, int amount, int[][] dp) {

        for(int i=0; i<=amount; i++){
            if(i % arr[0] == 0){
                dp[0][i] = i/arr[0];
            }else{
                dp[0][i] = (int)Math.pow(10,9);
            }
        }

        for(int index=1; index < n; index++){

            for(int currentTarget=0; currentTarget <= amount; currentTarget++){

                // target could have been achieved with subset ending at previous index
                int notTaken = dp[index-1][currentTarget];

                int taken = (int)Math.pow(10,9);
                // target-arr[index] could have been achieved with subset ending at previous index
                if(currentTarget >= arr[index]){
                    taken = 1 + dp[index][currentTarget-arr[index]];
                }

                dp[index][currentTarget] = Math.min(taken,notTaken);
            }

        }

        return dp[n-1][amount];
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

