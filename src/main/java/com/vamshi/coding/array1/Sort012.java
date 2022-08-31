package com.vamshi.coding.array1;

public class Sort012 {

    public static void main(String[] args) {
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
}
