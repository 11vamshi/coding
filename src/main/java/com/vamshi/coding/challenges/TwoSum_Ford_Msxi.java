package com.vamshi.coding.challenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

// two pointer approach will not give indices, map approach gives indices
public class TwoSum_Ford_Msxi {
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

    // map approach gives indices, also sorting is not required
    public int[] twoSumUsingMap(int[] nums, int target){

        int[] res = new int[2];

        Map<Integer, Integer> twoSumMap = new HashMap<>();


        for(int i=0; i< nums.length;i++){
            int required = target - nums[i];
            if(twoSumMap.containsKey(required)){
                res = new int[]{i, twoSumMap.get(required)};
            }else{
                twoSumMap.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum_Ford_Msxi twoSum_ford_msxi = new TwoSum_Ford_Msxi();
        int[] nums = {3,2,4};
        int[] res = twoSum_ford_msxi.twoSumUsingMap(nums, 6);

        IntStream.of(res).forEach(System.out::println);
    }

}
