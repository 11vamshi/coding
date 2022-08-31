package com.vamshi.coding.dpseries.lcs;

import java.util.Arrays;

// things to remember, dp size should match the recursion call recursion(s,t,n-1,m-1,dp)
//

public class DP32_subsequence_countin_recursion {
    static int mod = (int)(Math.pow(10,9)+7);

    public static void main(String[] args) {

        String s = "codingniinjas";
        String t = "in";

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

        // order of this if matters
        if(m < 0){    // exhaused s2, which means we found all characters in s2
            return 1;
        }

        if(n < 0){    // exhaused s1, but not everything in s2 is found
            return 0;
        }

        if(dp[n][m] != -1){
            return dp[n][m];
        }

        if(s.charAt(n) == t.charAt(m)){
            return dp[n][m] = (recursion(s,t,n-1,m-1,dp) // this can be a potential match
                    + recursion(s,t,n-1,m,dp)) % mod;   // or we can find potential match again, so we stay
                                                    // at same index for s2
         }
        return dp[n][m] = recursion(s,t,n-1,m,dp) % mod;
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
