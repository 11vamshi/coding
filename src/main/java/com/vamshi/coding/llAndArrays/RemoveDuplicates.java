package com.vamshi.coding.llAndArrays;

public class RemoveDuplicates {

    // [0,0,1,1,1,2,2,3,3,4]
    public static void main(String[] args) {
        int[] input = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println("result is " + removeDuplicates(input));
    }

    public static int removeDuplicates(int[] nums) {

        if(nums.length == 0 || nums.length == 1 ){
            return nums.length;
        }
        int temp=1;

        for(int i=1; i < nums.length;i++){
            if(nums[i] == nums[i-1]){
                continue;
            }
            nums[temp] = nums[i];
            temp = temp+1;

        }

        return temp;
    }

}
