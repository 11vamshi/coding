package com.vamshi.coding.sorting;

public class Practise {

    public static void main(String[] args) {
        int arr[] = {-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55,-28,-46};
        int n = arr.length;

        mergeSort(0, n - 1, arr);

        System.out.println("after sort ");
        for (int a : arr) {
            System.out.print(a + " ");

        }

    }

    private static void mergeSort(int low, int high, int[] arr) {
        if(low == high){
            return;
        }
        int mid = (low + high) /2;

        mergeSort(0, mid, arr);
        mergeSort(mid+1, high, arr);

        merge(low, high, arr);

    }

    private static void merge(int low, int high, int[] arr) {
        int i = low;
        int mid = (low + high)/2;
        int j = mid +1;
        while(i <= mid){
            if(arr[i] <= arr[j]){
                i++;
            }else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}