package com.vamshi.coding.dpseries.lcs;

import java.util.Arrays;

// things to remember, dp size should match the recursion call recursion(s,t,n-1,m-1,dp)
//

public class DP25_lcs_tabulation {

    public static void main(String[] args) {

        String s = "ab";
        String t = "defg";

        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n+1][m+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        System.out.println(" result is " + tabulation(s,t,n,m,dp));
        printDp(n,m,dp);

    }

    private static int tabulation(String s, String t, int n, int m, int[][] dp) {
        // first column all 0's
        for(int i=0; i <= n; i++){
            dp[i][0] = 0;
        }
        // first row all 0's
        for(int i=0; i <= m; i++){
            dp[0][i] = 0;
        }

        for(int i=1; i <= n; i++){
            for(int j=1; j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    private static void printDp(int n, int k, int[][] dp) {
        //printing dp
        for(int i=0; i <= n; i++){
            for(int j=0; j <= k; j++){
                System.out.print(dp[i][j] + "\t");

            }
            System.out.println();
        }
    }

}
