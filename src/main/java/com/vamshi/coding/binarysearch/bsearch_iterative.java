package com.vamshi.coding.binarysearch;

import java.util.Arrays;

public class bsearch_iterative {

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,-1,0,-2,2};
        int n = arr.length;
        int target = -2;

        Arrays.sort(arr);
        int res = bs(0, n-1, arr, target);
        System.out.println("result is " + res);

    }
    public static int bs(int start, int end, int[] arr, int target){
        while(start<=end){

            int mid = (start+end)/2;

            if(target == arr[mid]){
                return mid;
            }else if(target > arr[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
}
