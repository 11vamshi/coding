package com.vamshi.coding.dpseries.oneD;

public class DP1_ClimblingStairs {

    public static int countDistinctWayToClimbStair(long nStairs) {

        int dp[] = new int[(int) (nStairs+1)];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i <nStairs;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[(int) nStairs];

    }

    public static void main(String[] args) {
        System.out.println(" result is " + countDistinctWayToClimbStair(4));
    }

}
