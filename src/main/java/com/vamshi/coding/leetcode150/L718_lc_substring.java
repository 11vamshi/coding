package com.vamshi.coding.leetcode150;

import static com.vamshi.coding.leetcode150.L1143_lcs_rec.printDp;

public class L718_lc_substring {

    private int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < text2.length(); j++) {
            dp[0][j] = 0;
        }
        int max = 0;
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);

                }
            }


        }
        printDp(text1.length() + 1, text2.length(), dp);
        return max;
    }
    public static void main(String[] args) {
        L718_lc_substring l718_lc_substring = new L718_lc_substring();
        String text1 = "abcd", text2 = "ababc";

        int res = l718_lc_substring.longestCommonSubsequence(text1, text2);

        System.out.println(" result is " + res);
    }
}
