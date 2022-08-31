package com.vamshi.coding.dpseries.lcs;

import java.util.Arrays;

// things to remember, dp size should match the recursion call recursion(s,t,n-1,m-1,dp)
//

public class DP33_edit_distance_recursion {

    public static void main(String[] args) {

        String s = "whgtdwhgtdg";
        String t = "aswcfg";

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
        if(n < 0){
            return m+1; // we need to insert m characters from t
        }

        if(m < 0){
            return n+1; // we need to delete n characters from s
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(s.charAt(n) == t.charAt(m)){
            return dp[n][m] = recursion(s,t,n-1,m-1,dp);
        }
        int insertion = 1 + recursion(s,t,n,m-1,dp);
        int deletion = 1 + recursion(s,t,n-1,m,dp);
        int replacement = 1 + recursion(s,t,n-1,m-1,dp);

        return dp[n][m] = Math.min(Math.min(insertion,deletion),replacement);
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
