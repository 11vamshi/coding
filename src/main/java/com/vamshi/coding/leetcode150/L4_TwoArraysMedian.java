package com.vamshi.coding.leetcode150;

public class L4_TwoArraysMedian {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] merge = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = -1;

        while (i < nums1.length && j < nums2.length){

            if(nums1[i] <= nums2[j]){
                merge[++k] = nums1[i];
                i++;
            }else{
                merge[++k] = nums2[j];
                j++;
            }
        }
        while (i < nums1.length){
            merge[++k] = nums1[i];
            i++;
        }

        while (j < nums2.length){
            merge[++k] = nums2[j];
            j++;
        }
        if(merge.length % 2 == 0){
            int mid1 = merge[(merge.length/2)-1];
            int mid2 = merge[merge.length/2];
            return (double)(mid1+mid2)/2;
        }

        return merge[merge.length/2];
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2}, nums2 = {3,4};

        L4_TwoArraysMedian l4_twoArraysMedian = new L4_TwoArraysMedian();

        double result  = l4_twoArraysMedian.findMedianSortedArrays(nums1, nums2);

        System.out.println("result is " + result);

    }
}
