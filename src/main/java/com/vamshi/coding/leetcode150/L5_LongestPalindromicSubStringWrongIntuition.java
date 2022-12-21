package com.vamshi.coding.leetcode150;

import static com.vamshi.coding.leetcode150.L1143_lcs_rec.printDp;

// longest palindromic subsequence logic fails here
public class L5_LongestPalindromicSubStringWrongIntuition {

    public String longestPalindrome(String s) {
        String rev = reverse(s);

        int[][] dp = new int[s.length()+1][s.length() +1];

        int max = 0;
        String res = "";
        for(int i=1; i <= s.length();i++){
            for(int j=1; j <= s.length();j++) {
                if(s.charAt(i-1) == rev.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];

                    max = Math.max(max, dp[i][j]);
                }

            }
        }
        printDp(s.length() + 1, s.length(), dp);

        for(int i=0; i < dp.length;i++){
        for(int j=0; j < dp[0].length;j++) {
            if(dp[i][j] == max){
                        res = s.substring(i-max,i);
                    }
                }
            }

        return res;
    }

    public static void main(String[] args) {
        L5_LongestPalindromicSubStringWrongIntuition l5_longestPalindromicSubStringWrongIntuition = new L5_LongestPalindromicSubStringWrongIntuition();
        String s = "aacabdacaa";  // "aacabdkacaa"



        System.out.println("result is " + l5_longestPalindromicSubStringWrongIntuition.longestPalindrome(s));

    }

    private static String reverse(String s){
        String rev = "";
        for(int i=0; i < s.length(); i++){
            rev = s.charAt(i) + rev;
        }
        return rev;
    }

}
