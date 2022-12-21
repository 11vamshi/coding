package com.vamshi.coding.leetcode150;

import static com.vamshi.coding.leetcode150.L1143_lcs_rec.printDp;

public class L1143_lcs_tab {


    private int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int i=0;i < text1.length();i++){
            dp[i][0] = 0;
        }

        for(int j=0;j < text2.length();j++){
            dp[0][j] = 0;
        }
        for(int i=1;i <= text1.length();i++){
            for(int j=1;j <= text2.length();j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    // forgot else
                }else{
                int skipText1 = dp[i-1][j];
                int skipText2 = dp[i][j-1];
                dp[i][j] = Math.max(skipText1, skipText2);
                }
            }
        }
        printDp(text1.length()+1, text2.length(), dp);
        return dp[text1.length()][text2.length()];
    }


    public static void main(String[] args) {
        L1143_lcs_tab l1143_lcs_tab = new L1143_lcs_tab();
        String text1 = "abcde", text2 = "ace";

        int res = l1143_lcs_tab.longestCommonSubsequence(text1, text2);

        System.out.println(" result is " + res);
    }

}
