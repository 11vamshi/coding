package com.vamshi.coding.Practise;

import java.util.Arrays;

public class L322_MinCoins {

     public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];

        for (int i=0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        int result = rec(coins, dp, amount, coins.length-1);

        if(result >= Math.pow(10,9)){
            result = -1;
        }
        return result;
    }

    private int rec(int[] coins, int[][] dp, int amount, int current_index) {


        if(current_index == 0){
            if(amount % coins[current_index] == 0){
                return amount/coins[current_index];
            }
            else {
                return (int)Math.pow(10, 9);
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

        L322_MinCoins l322_minCoins = new L322_MinCoins();

        int result = l322_minCoins.coinChange(coins, 11);

        System.out.println("result is " + result);

    }
}
