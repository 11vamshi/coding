package com.vamshi.coding.dpseries.stocks;

import java.util.Arrays;
import java.util.List;

public class DP36_buy_sell_stock_2_rec {

    public static void main(String[] args) {

        long[] values = new long[]{7, 6, 5, 4, 3, 2, 1};

        int n = values.length;

        long[][] dp = new long[n][2];
        for(long[] row: dp){
            Arrays.fill(row, -1);
        }


        System.out.println("result is " + recursion(values, n, 0,1, dp));
    }

    public static long recursion(long[] values, int n, int index, int buy, long[][] dp){

        if(index == n)
        {
            return 0;
        }

        if(dp[index][buy] != -1){
            return dp[index][buy];
        }

        long profit =0;
        if(buy == 1){
            profit = Math.max(
                     -values[index] + recursion(values, n, index+1,0, dp),
                    recursion(values, n, index+1,1, dp));
        }else{
            profit = Math.max(
                     values[index] + recursion(values, n, index+1,1, dp),
                     recursion(values, n, index+1,0, dp));
        }

        return dp[index][buy] = profit;
    }
}
