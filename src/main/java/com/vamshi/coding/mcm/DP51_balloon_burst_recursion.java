package com.vamshi.coding.mcm;

import java.util.Arrays;

public class DP51_balloon_burst_recursion {

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

        System.out.println("result is " + recursion(1,n,a2, dp));

    }

    public static int recursion(int i, int j, int[] a2, int[][] dp){
        if(i> j) return 0;

        if(dp[i][j] !=-1){
            return dp[i][j];
        }

        int maxi = (int)Math.pow(10,-7);
        for(int ind =i; ind <=j; ind++){
            int cost = a2[i-1] * a2[ind] * a2[j+1]
                    + recursion(i, ind-1, a2, dp)
                    + recursion(ind+1, j, a2, dp);
            maxi = Math.max(maxi, cost);
        }

        return dp[i][j] = maxi;
    }



}
