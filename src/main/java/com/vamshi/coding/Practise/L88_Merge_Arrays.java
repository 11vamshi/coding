package com.vamshi.coding.Practise;

import java.awt.*;
import java.util.stream.IntStream;

// since arrays indices can o negative, we used while(m >= 0 && n >= 0 ){ and not || like in merge linked list
public class L88_Merge_Arrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        m = m-1;
        n = n-1;
        int j = nums1.length-1;

        while(m >= 0 && n >= 0 ){
            if(nums1[m] < nums2[n] ){
                nums1[j] = nums2[n];
                n--;
            }else{
                nums1[j] = nums1[m];
                m--;
            }
            j--;
        }

        while(m >= 0 ){
            nums1[j] = nums1[m];
            j--;
            m--;
        }
        while(n >= 0 ){
            nums1[j] = nums2[n];
            j--;
            n--;
        }

        IntStream.of(nums1).forEach(System.out::println);

    }

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};


        L88_Merge_Arrays l88_merge_arrays = new L88_Merge_Arrays();

        l88_merge_arrays.merge(nums1, 3, nums2, 3);
    }
}
