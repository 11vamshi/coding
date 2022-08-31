package com.vamshi.coding.dpseries.stocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP37_buy_sell_stock_3_rec {

    public static void main(String[] args) {



        ArrayList<Integer> values =
                new ArrayList<>();
        values.add(7);
        values.add(6);values.add(5);values.add(4);values.add(3);values.add(2);values.add(1);

        int n = values.size();

        int[][][] dp = new int[n][2][3];
        for(int[][] row: dp){
            for(int[] row1: row) {
                Arrays.fill(row1, -1);
            }
        }


        System.out.println("result is " + recursion(values, n, 0,1,2, dp));
    }

    public static int recursion(ArrayList<Integer> values, int n, int index, int buy, int cap, int[][][] dp){

        if(index == n || cap == 0)
        {
            return 0;
        }

        if(dp[index][buy][cap] != -1){
            return dp[index][buy][cap];
        }

        int profit =0;
        if(buy == 1){
            profit = Math.max(
                     -values.get(index) + recursion(values, n, index+1,0, cap, dp),
                    recursion(values, n, index+1,1, cap, dp));
        }else{
            profit = Math.max(         // sell makes a transaction
                     values.get(index) + recursion(values, n, index+1,1, cap-1,dp),
                     recursion(values, n, index+1,0, cap, dp));
        }

        return dp[index][buy][cap] = profit;
    }
}
