package com.vamshi.coding.binarysearch;

import java.util.Arrays;

public class bsearch_rec {

    public static void main(String[] args) {
        int[] arr = new int[]{1,0,-1,0,-2,2};
        int n = arr.length;
        int target = 10;

        Arrays.sort(arr);
        int res = bs(0, n-1, arr, target);
        System.out.println("result is " + res);

    }
    public static int bs(int start, int end, int[] arr, int target){
        if(start > end){
            return -1;
        }

        int mid = (start + end/2);
        if(target == arr[mid]){
            return mid;
        }else if(target > arr[mid]){
            return bs(mid+1, end, arr, target);
        }else{
            return bs(start, mid-1, arr, target);
        }

    }
}
