package com.vamshi.coding.llAndArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15_ThreeSum {


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i < nums.length-2; i++){

            if(i == 0 || (i>0 && nums[i] != nums[i-1])){

                int constant = nums[i];
                int left = i+1;
                int right = nums.length-1;

                while (left < right){
                    if(-constant == nums[left] + nums[right]){
                        result.add(Arrays.asList(constant, nums[left], nums[right]));

                        while(nums[left+1] == nums[left]){
                            left++;
                        }
                        while(nums[right-1] == nums[right]){
                            right--;
                        }
                        left++;
                        right--;

                    }else if(-constant < nums[left] + nums[right]){
                        right--;
                    }else{
                        left++;
                    }
                }

            }


        }
        return result;
    }

}
