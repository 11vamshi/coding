package com.vamshi.coding.dpseries.oneD;

import java.util.Arrays;

public class L198_House_Robber {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rec(nums, nums.length-1, dp);
    }

    private int rec(int[] nums, int index, int[] dp){

        if(index < 0 ){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }
        int taken = nums[index] + rec(nums, index - 2, dp);
        int notTaken = rec(nums, index - 1, dp);

        return dp[index] = Math.max(taken, notTaken);
    }
}
