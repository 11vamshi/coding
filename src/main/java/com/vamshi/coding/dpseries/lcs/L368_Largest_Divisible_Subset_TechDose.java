package com.vamshi.coding.dpseries.lcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L368_Largest_Divisible_Subset_TechDose {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int[] dp = new int[nums.length];

        // since every number can form a subset by itself
        Arrays.fill(dp, 1);

        int max =1;
        for(int i = 1 ; i < nums.length; i++){

            for(int j=0 ; j < i ; j++ ){

                if(nums[i] % nums[j] == 0 && dp[j]>=dp[i]){
                    dp[i] = dp[j] + 1;
                }
                max = Math.max(max, dp[i]);
        }

    }
        // iterate dp array from righ to left

        List<Integer> result = new ArrayList<>();

        int rightMost = -1;
        for(int i = nums.length-1; i >= 0; i--){

            if(dp[i] == max && (rightMost == -1 || rightMost % nums[i] == 0)){
                result.add(nums[i]);
                rightMost = nums[i];
                max = max-1;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        largestDivisibleSubset(nums).forEach(System.out::println);

    }
}
