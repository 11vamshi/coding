package com.vamshi.coding.sort;

import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {1,3,2,3,1};
        int n = arr.length;

        mergeSort(0, n-1,arr);

        System.out.println("after sort " );
        for (int a:arr) {
            System.out.print(a + " ");

        }

    }

    private static void mergeSort(int left, int right, int[] arr) {

        if(left == right){
            return;
        }
        int mid = (left + right)/2;

        mergeSort(left, mid, arr);
        mergeSort(mid+1, right, arr);

        merge(left, mid+1, right, arr);
    }

    private static void merge(int left, int mid, int right, int[] arr) {

        int i = left;
        int j = mid;
        int temp_index=left;

        int [] temp = new int[right+1];

        while(i < mid && j <= right){
            if(arr[i] <= arr[j]){
                temp[temp_index++] = arr[i++];
            }else{
                temp[temp_index++] = arr[j++];
            }
        }

        while (i < mid){
            temp[temp_index++] = arr[i++];
        }
        while (j <= right){
            temp[temp_index++] = arr[j++];
        }

        for(int a=left; a <= right; a++){
            arr[a] = temp[a];
        }
    }

}
