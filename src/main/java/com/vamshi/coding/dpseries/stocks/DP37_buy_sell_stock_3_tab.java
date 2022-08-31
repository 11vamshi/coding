package com.vamshi.coding.dpseries.stocks;

import java.util.ArrayList;
import java.util.Arrays;

public class DP37_buy_sell_stock_3_tab {

    public static void main(String[] args) {


        ArrayList<Integer> values =
                new ArrayList<>();
        values.add(7);
        values.add(6);values.add(5);values.add(4);values.add(3);values.add(2);values.add(1);


        int n = values.size();

        int[][][] dp = new int[n+1][2][3];

        for(int[][] row: dp){
            for(int[] row1: row) {
                Arrays.fill(row1, 0);
            }
        }


        System.out.println("result is " + tabulation(values, n, dp));
    }

    public static int tabulation(ArrayList<Integer> values, int n, int[][][] dp){

        // base cases not needed, since dp initiased with 0's, but needed if inittiazed to -1
//        for(int buy=0; buy <=1; buy++){
//            for(int cap=0; cap <=2; cap++){
//                dp[n][buy][cap] = 0;
//            }
//        }
//
//        for(int i=0; i<=n; i++){
//            for(int buy=0; buy <=1; buy++){
//                dp[i][buy][0] = 0;
//            }
//        }

        for (int i = n-1; i >=0; i-- ){
            for (int buy = 0; buy <=1 ; buy++ ){
                for (int cap = 1; cap <=2 ; cap++ ) {
                    if (buy == 1) {
                        dp[i][buy][cap] = Math.max(-values.get(i) + dp[i + 1][0][cap],
                                dp[i + 1][1][cap]);
                    } else {
                        dp[i][buy][cap] = Math.max(values.get(i) + dp[i + 1][1][cap-1],
                                dp[i + 1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}
