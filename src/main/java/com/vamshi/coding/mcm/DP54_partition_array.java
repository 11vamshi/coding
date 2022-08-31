package com.vamshi.coding.mcm;

import java.util.Arrays;

public class DP54_partition_array {

    public static void main(String[] args) {
        int[] num = new int[]{1, 20, 13, 4, 4, 1};
        int n = num.length;
        int k = 3;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        System.out.println("result is " + rec(0,n, k, num, dp));
    }

    private static int rec(int i, int n, int k, int[] num, int[] dp){

        if(i ==n ){

            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int maxi = (int)Math.pow(10,-7);
        int maxiSum = (int)Math.pow(10,-7);
        int sum;
        int length = 0;
        for(int j = i; j < Math.min(n,i+k); j++){
            length = length+1;
            maxi = Math.max(maxi, num[j]);

            sum = (maxi*length) + rec(j+1,n, k, num, dp);
            maxiSum = Math.max(sum,maxiSum);
        }

        return dp[i] = maxiSum;
    }

}
