package com.vamshi.coding.leetcode.array;

public class L189_RotateArray {
    public static void rotate(int[] nums, int k) {

        k = k % nums.length; // you forgot this line

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private static void reverse(int[] nums, int i, int j){
        int temp = nums[0];

        while(i < j){
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        rotate(new int[]{-1}, 3);
    }

}
