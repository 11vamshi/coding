package com.vamshi.coding.dpseries.lcs;

import java.util.Arrays;

// things to remember, dp size should match the recursion call recursion(s,t,n-1,m-1,dp)
//

public class DP25_lcs_recursion {

    public static void main(String[] args) {

        String s = "ab";
        String t = "defg";

        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        System.out.println(" result is " + recursion(s,t,n-1,m-1,dp));
        printDp(n,m,dp);

    }

    private static int recursion(String s, String t, int n, int m, int[][] dp) {
        if(n < 0 || m < 0){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(s.charAt(n) == t.charAt(m)){
            return 1 + recursion(s,t,n-1,m-1,dp);
        }
        return dp[n][m] = Math.max(recursion(s,t,n-1,m,dp), recursion(s,t,n,m-1,dp));
    }

    private static void printDp(int n, int k, int[][] dp) {
        //printing dp
        for(int i=0; i < n; i++){
            for(int j=0; j < k; j++){
                System.out.print(dp[i][j] + "\t");

            }
            System.out.println();
        }
    }

}
