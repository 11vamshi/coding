package com.vamshi.coding.mcm;

import java.util.Arrays;

public class DP51_balloon_burst_tab {

    public static void main(String[] args) {
        int[] a = new int[]{7, 1, 8};
        int n = a.length;

        int[] a2 = new int[a.length + 2];
        for (int i = a.length; i > 0; i--) {

            a2[i] = a[i - 1];
        }
        a2[0] = 1;
        a2[a.length+1] = 1;

        int[][] dp = new int[a2.length+1][a2.length+1];

        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        System.out.println("result is " + tabulation(1,n,a2, dp));

    }

    public static int tabulation(int dum, int n, int[] a2, int[][] dp){


        for(int i =n; i>=1;i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) dp[i][j] = 0;

                int maxi = (int) Math.pow(10, -7);
                for (int ind = i; ind <= j; ind++) {
                    int cost = a2[i - 1] * a2[ind] * a2[j + 1]
                            + dp[i][ind - 1]
                            + dp[ind + 1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
        }

}
