package com.vamshi.coding.array1;

public class L75_Sort012 {

    public static void main1(String[] args) {
        int[] a = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

        int lo = 0;
        int mid = 0;
        int hi = a.length-1;
        int temp;

         while(mid<=hi){

             if(a[mid] == 0){
                temp = a[mid];
                a[mid] = a[lo];
                a[lo] = temp;
                lo++;
                mid++;
             }else if(a[mid] == 1){
                mid++;
             }else{
                 temp = a[mid];
                 a[mid] = a[hi];
                 a[hi] = temp;

                 hi--;
             }
         }
        System.out.println("result is " );
         for(int i:a){
             System.out.print(i + " ");
         }

    }
    public static void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high=nums.length-1;

        while(mid < high){
            if(nums[mid] == 0){
                int swap = nums[mid];
                nums[mid] =nums[low];
                nums[low++]= swap;
                mid++;
            } else if(nums[mid] == 1){
                mid++;
            } else{
                int swap = nums[mid];
                nums[mid] =nums[high];
                nums[high--]= swap;
            }

        }
    }




    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        System.out.println("result is " );
        for(int i:nums){
            System.out.print(i + " ");
        }

    }
}
