package com.vamshi.coding.array1;

//local maximum and global maximum approach
public class Kadane {
    public static void main(String[] args) {
        int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int maxi = array[0];
        int maxEndingHere = array[0];

        for(int i=1; i < array.length;i++){
            maxEndingHere= Math.max(array[i], array[i] + maxEndingHere);
            maxi = Math.max(maxi, maxEndingHere);
        }
    }

}
