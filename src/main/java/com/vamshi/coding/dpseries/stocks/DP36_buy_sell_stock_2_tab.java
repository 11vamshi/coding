package com.vamshi.coding.dpseries.stocks;

import java.util.Arrays;

public class DP36_buy_sell_stock_2_tab {

    public static void main(String[] args) {

        long[] values = new long[]{7, 6, 5, 4, 3, 2, 1};

        int n = values.length;

        long[][] dp = new long[n+1][2];
        for(long[] row: dp){
            Arrays.fill(row, -1);
        }


        System.out.println("result is " + tabulation(values, n, dp));
    }

    public static long tabulation(long[] values, int n, long[][] dp){

        // no need of base conditions for tabulation stock questions if dp is filled with 0's, DP27
        dp[n][0] = 0; dp[n][1] = 0;

        for (int i = n-1; i >=0; i-- ){
            for (int buy = 0; buy <=1 ; buy++ ){
                if(buy ==1 ){
                    dp[i][buy] = Math.max(-values[i] + dp[i+1][0], dp[i+1][1]);
                }else{
                    dp[i][buy] = Math.max(values[i] + dp[i+1][1], dp[i+1][0]);
                }

            }
        }
        return dp[0][1];
    }
}
