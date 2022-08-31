package com.vamshi.coding.mcm;

import java.util.Arrays;

public class DP52_boolean_to_true_rec_with_memoization {

    static int prime = (int)Math.pow(10,9)+7;
    public static void main(String[] args) {
        String exp2 = "T^T^F";
        char[] exp = exp2.toCharArray();
        int n = exp.length;
        int[][][] dp = new int[n][n][2];

        for(int[][] rows:dp){
            for(int[] row:rows){
                Arrays.fill(row, -1);
            }
        }
        System.out.println("result is " + recursion(0, exp.length-1, 1, exp, dp));

    }

    private static int recursion(int i, int j, int isTrue, char[] exp, int[][][] dp){

        if(i > j){return 0;}

        if(i==j){
            if(isTrue == 1){
                return exp[i] == 'T'?1:0;
            }else{
                return exp[i] == 'F'?1:0;
            }
        }

        if(dp[i][j][isTrue] != -1){
            return dp[i][j][isTrue];
        }
        int ways=0;
        for(int index=i+1;index <= j-1; index+=2 ){
            int lt = recursion(i,index-1, 1, exp,dp);
            int lf = recursion(i,index-1, 0, exp, dp);

            int rt = recursion(index+1, j, 1, exp, dp);
            int rf = recursion(index+1, j, 0, exp, dp);

            if(exp[index] == '&'){
                if(isTrue ==1){
                    ways = (ways+ (rt*lt) % prime ) % prime;
                }else {
                    ways = (ways+ (rt*lf) % prime + (rf*lt) % prime + (rf*lf) % prime ) % prime;
                }
            }else if(exp[index] == '|'){
                if(isTrue ==1){
                    ways = (ways+ (lt*rt) % prime + (lt*rf) % prime + (lf*rt) % prime) % prime;
                }else {
                    ways = (ways+ (rf*lf) % prime ) % prime;
                }
            }else{
                if(isTrue ==1){
                    ways = (ways+ (lt*rf) % prime + (lf*rt) % prime) % prime;
                }else {
                    ways = (ways+ (lt*rt) % prime + (rf*lf) % prime ) % prime;
                }
            }
        }
        return dp[i][j][isTrue] = ways;
    }
}
