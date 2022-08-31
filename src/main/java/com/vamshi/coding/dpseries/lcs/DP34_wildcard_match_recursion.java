package com.vamshi.coding.dpseries.lcs;

import java.util.Arrays;

// things to remember, dp size should match the recursion call recursion(s,t,n-1,m-1,dp)
//

public class DP34_wildcard_match_recursion {

    public static void main(String[] args) {

        String s = "ba*a?";
        String t = "baaabab";

        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n][m];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        System.out.println(" result is " + recursion(s,t,n-1,m-1,dp));
        printDp(n,m,dp);

    }

    private static boolean recursion(String s, String t, int n, int m, int[][] dp) {
        if(n < 0 && m < 0){
            return true;
        }
        if(n < 0){
            return false;
        }
        if(m < 0){
            for(int i =0; i <= n; i++){
                if(s.charAt(i)!= '*'){
                    return false;
                }
            }
            return true;
        }
        if(dp[n][m] != -1){
            return dp[n][m] ==1;
        }

        boolean taken = false;
        boolean notTaken = false;
        if(s.charAt(n) == t.charAt(m) || '?' == s.charAt(n)){
            return recursion(s,t,n-1,m-1,dp);
        }
        if('*' == s.charAt(n)){
            taken = recursion(s, t, n-1, m, dp);  // star used as empty character
            notTaken = recursion(s, t, n , m-1, dp); // * can be reused
        }
        dp[n][m] = (taken || notTaken) ?1:0;
        return (taken||notTaken);
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
