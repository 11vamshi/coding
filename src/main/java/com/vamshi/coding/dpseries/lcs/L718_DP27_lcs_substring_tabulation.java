package com.vamshi.coding.dpseries.lcs;

import java.util.Arrays;

// things to remember, dp size should match the recursion call recursion(s,t,n-1,m-1,dp)
//

public class L718_DP27_lcs_substring_tabulation {

    public static void main(String[] args) {

        String s = "adebc";
        String t = "dcadb";

        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n+1][m+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        System.out.println(" result is " + tabulation(s,t,n,m,dp));
        printDp(n,m,dp);

        // to print the longest substring, we need to find the biggest number in dp
        // then do append all the characters until i-1,j-1 become 0 , same as previous question


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
        int maxSubstring = 0;
        for(int i=1; i <= n; i++){
            for(int j=1; j <= m; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxSubstring = Math.max(maxSubstring, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return maxSubstring;
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
