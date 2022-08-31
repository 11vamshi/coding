package com.vamshi.coding.dpseries.lcs;

import java.util.Arrays;

// things to remember, dp size should match the recursion call recursion(s,t,n-1,m-1,dp)
//

public class DP34_wildcard_match_tabulation {

    public static void main(String[] args) {

        String s = "ba*a?";
        String t = "baaabab";

        int n = s.length();
        int m = t.length();

        boolean dp[][] = new boolean[n+1][m+1];
        for(boolean[] row:dp){
            Arrays.fill(row, false);
        }

        System.out.println(" result is " + tabulation(s,t,n,m,dp));
        printDp(n,m,dp);

    }

    private static boolean tabulation(String s, String t, int n, int m, boolean[][] dp) {
        dp[0][0] = true;

        // first row all 0's, since we exhausted pattern 's' but still few characters left in 't'
        for(int i=1; i <= m; i++){
            dp[0][i] = false;
        }

        // first column not all 0's, if we have *'s
        for(int i=1; i <= n; i++){
            dp[i][0] = dp[i-1][0] && (s.charAt(i - 1) == '*');
        }

        for(int i=1; i <= n; i++){
            for(int j=1; j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1) || s.charAt(i-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(s.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    private static void printDp(int n, int k, boolean[][] dp) {
        //printing dp
        for(int i=0; i <= n; i++){
            for(int j=0; j <= k; j++){
                System.out.print(dp[i][j] + "\t");

            }
            System.out.println();
        }
    }

}
