package com.vamshi.coding.leetcode150;

import java.util.Arrays;

public class L322_MinCoins_Rec {

     public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount+1];

        for (int i=0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        int result = rec(coins, dp, amount, coins.length-1);

        // forgot this
        if(result >= Math.pow(10,9)){
            result = -1;
        }

        printDp(coins.length, amount, dp);
        return result;
    }

    private int rec(int[] coins, int[][] dp, int amount, int current_index) {


        if(current_index == 0){
            if(amount % coins[current_index] == 0){
                return dp[current_index][amount] = amount/coins[current_index];
            }
            else {
                return dp[current_index][amount] = (int)Math.pow(10, 9);
            }
        }

        if(dp[current_index][amount] != -1){
            return dp[current_index][amount];
        }

        int notTaken = rec(coins, dp, amount, current_index-1);

        int taken = (int)Math.pow(10, 9);
        if(amount >= coins[current_index]){
            taken = 1 + rec(coins, dp, amount-coins[current_index], current_index);
        }


        return dp[current_index][amount] = Math.min(taken, notTaken);
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};

        L322_MinCoins_Rec l322_minCoinsRec = new L322_MinCoins_Rec();

        int result = l322_minCoinsRec.coinChange(coins, 11);

        System.out.println("result is " + result);

    }

    static void printDp(int n, int k, int[][] dp) {
        //printing dp
        for(int i=0; i < n; i++){
            for(int j=0; j <= k; j++){
                System.out.print(dp[i][j] + "\t");

            }
            System.out.println();
        }
    }
}
