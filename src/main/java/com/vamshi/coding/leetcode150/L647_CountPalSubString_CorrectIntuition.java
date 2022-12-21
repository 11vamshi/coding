package com.vamshi.coding.leetcode150;


// prereq = L5
// https://www.youtube.com/watch?v=XmSOWnL6T_I&ab_channel=Pepcoding

public class L647_CountPalSubString_CorrectIntuition {

    public int longestPalindrome(String s) {
        int count=0;

        int[][] dp = new int[s.length()][s.length()];

        for(int gap=0; gap < s.length(); gap++) {

//            commented nested loops will give error, since we need a different pattern of strings
//            for(int i=0; i < s.length(); i++) {
//                for(int j=i+gap; j < s.length(); j++) {
//
//
//
//                }
//            }

            for (int i = 0, j = i + gap; j < s.length(); j++, i++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (gap == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 1 : 0;
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] > 0) {
                        dp[i][j] = 1;
                    }
                }

                if (dp[i][j] == 1) {
                    count++;
                }
            }
        }
        printdp(s.length(), s.length(), dp);
        return count;
    }

    private void printdp(int n, int k, int[][] dp) {

        //printing dp
        for(int i=0; i < n; i++){
            for(int j=0; j < k; j++){
                System.out.print(dp[i][j] + "\t");

            }
            System.out.println();
        }
    }

        public static void main(String[] args) {
            L647_CountPalSubString_CorrectIntuition l5_longestPalSubString_correctIntuition = new L647_CountPalSubString_CorrectIntuition();
            String s = "aacabdacaa";  // "aacabdkacaa"

            System.out.println("result is " + l5_longestPalSubString_correctIntuition.longestPalindrome(s));

        }
    }

