package com.vamshi.coding.leetcode150;

import java.util.Arrays;

public class L1143_lcs_rec {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0; i < dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        int res = rec(text1, text1.length()-1,text2, text2.length()-1, dp);
        printDp(text1.length()+1, text2.length(), dp);
       return res;
    }

    private int rec(String text1, int idx1, String text2, int idx2, int[][] dp) {

        // mistake here, you wrote if(idx1 == 0 || idx2 == 0){
        if(idx1 < 0 || idx2 < 0){
            return 0;
        }

        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }

        int noSkip = (int)Math.pow(10,-7);
        if(text1.charAt(idx1) == text2.charAt(idx2) ){
             noSkip = 1 + rec(text1, idx1-1, text2,idx2-1, dp);
        }

        int skip1 = rec(text1, idx1-1, text2,idx2, dp);
        int skip2 = rec(text1, idx1, text2,idx2-1, dp);


        int temp = Math.max(skip1, skip2);
        // optimization, since matching characters will always fetch better final result, can be directly
        // returned, refer striver's answer
        return dp[idx1][idx2] = Math.max(noSkip, temp);
    }


    static void printDp(int n, int k, int[][] dp) {
        //printing dp
        for(int i=0; i < n; i++){
            for(int j=0; j <= k; j++){
                System.out.print(dp[i][j] + "\t");

            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        L1143_lcs_rec l1143_lcsRec = new L1143_lcs_rec();
        String text1 = "abcde", text2 = "ace";

        int res = l1143_lcsRec.longestCommonSubsequence(text1, text2);

        System.out.println(" result is " + res);
    }
}
