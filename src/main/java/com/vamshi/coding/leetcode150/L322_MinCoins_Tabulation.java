package com.vamshi.coding.leetcode150;

import static com.vamshi.coding.leetcode150.L322_MinCoins_Rec.printDp;

public class L322_MinCoins_Tabulation {

    public static void main(String[] args) {
        int[] coins = {1,2,5};

        L322_MinCoins_Tabulation l322MinCoinsTabulation = new L322_MinCoins_Tabulation();

        int result = l322MinCoinsTabulation.coinChange(coins, 11);

        System.out.println("result is " + result);

    }

    private int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];

        for(int i=0; i <= amount; i++){
            if(i % coins[0] == 0){
                dp[0][i] = i/coins[0];
            }else{
                dp[0][i] = (int)Math.pow(10, 9);
            }
        }

        for(int i=1; i < coins.length; i++){
        for(int j=0; j <= amount; j++) {
            int notTaken = dp[i-1][j];

            int taken = (int)Math.pow(10,9);
            if(j >= coins[i]){
                taken = 1 + dp[i][j-coins[i]];
            }

            dp[i][j] = Math.min(taken, notTaken);
            }
        }
        printDp(coins.length, amount, dp);

        return dp[coins.length-1][amount];
    }
}
