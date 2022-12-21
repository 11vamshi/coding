package com.vamshi.coding.leetcode150;

// theory
// https://www.youtube.com/watch?v=UflHuQj6MVA&ab_channel=TECHDOSE
// code
//https://www.youtube.com/watch?v=fxwvVnBMN6I&ab_channel=CodewithAlisha

public class L5_LongestPalSubString_CorrectIntuition {

    public String longestPalindrome(String s) {
        int maxLength=0;
        String res = "";
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
            // or j = i+gap does not matter
            for (int i = 0, j = gap; j < s.length(); j++, i++) {
                 if (i == j) {
                    dp[i][j] = 1;
                } else if (gap == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 2 : 0;
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] > 0) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                }

                if (dp[i][j] > 0) {
                    if ((j - i + 1) > maxLength) {
                        maxLength = j - i + 1;
                        res = s.substring(i, j);
                    }

                }
            }
        }
        printdp(s.length(), s.length(), dp);
        return res;
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
            L5_LongestPalSubString_CorrectIntuition l5_longestPalSubString_correctIntuition = new L5_LongestPalSubString_CorrectIntuition();
            String s = "aacabdacaa";  // "aacabdkacaa"

            System.out.println("result is " + l5_longestPalSubString_correctIntuition.longestPalindrome(s));

        }
    }

