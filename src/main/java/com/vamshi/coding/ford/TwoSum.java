package com.vamshi.coding.ford;

import java.util.Arrays;

// gives TLE on leetcode, use hashmap approach
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        int[] res = new int[2];
        Arrays.sort(nums);

        int low = 0;
        int high = nums.length-1;
        while(low < high){
            if(nums[low] + nums[high] == target){
                res = new int[]{nums[low], nums[high]};
            }else if(nums[low] + nums[high] < target){
                low++;
            }else{
                high--;
            }
        }
        return res;
    }
}
