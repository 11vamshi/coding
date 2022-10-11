package com.vamshi.coding.dpseries.lcs;

import java.util.Arrays;

public class L300_lis_recursion {

    public static int lengthOfLIS(int[] nums) {

        int[][] dp = new int[nums.length][nums.length + 1];

        for(int[] arr:dp)
            Arrays.fill(arr, -1);

        return lis(nums, dp, nums.length-1, nums.length);
    }

    private static int lis(int[] nums, int[][] dp, int index, int next_index) {
        if(index < 0){
            return 0;
        }

        if(dp[index][next_index] != -1) {
            return dp[index][next_index];
        }
        int notTaken = lis(nums, dp, index-1, next_index);
        int taken = Integer.MIN_VALUE;
        if( next_index == nums.length || nums[index] < nums[next_index]){
            taken = 1 + lis(nums, dp, index-1, index);
        }

        return dp[index][next_index] = Math.max(notTaken, taken);
    }

    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};

        lengthOfLIS(nums);

    }

}
