package com.vamshi.coding.array2;


// pre-req - merge sort
public class L493_InversionsCount {

    public static void main(String[] args) {
        int arr[] = {1,3,2,3,1};
        int n = arr.length;

        int res = mergeSort(0, n-1,arr);

        System.out.println("after sort " + res);
        for (int a:arr) {
            System.out.print(a + " ");

        }

    }

    private static int mergeSort(int left, int right, int[] arr) {
        int inv_count = 0;
        if(left == right){
            return 0;
        }
        int mid = (left + right)/2;

        inv_count = inv_count + mergeSort(left, mid, arr);
        inv_count = inv_count + mergeSort(mid+1, right, arr);

        inv_count = inv_count + merge(left, mid+1, right, arr);
    return inv_count;
    }

    private static int merge(int left, int mid, int right, int[] arr) {

        int inv_count = 0;
        int j = mid;

        for(int i=left;i <mid;i++){
            while(j <= right && arr[i] > arr[j]){
                j++;
            }
            inv_count = inv_count + (j-mid);
        }

        int i = left;
        j = mid;
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
        return inv_count;
    }
}
