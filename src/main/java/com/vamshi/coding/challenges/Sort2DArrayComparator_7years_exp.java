package com.vamshi.coding.challenges;

import java.util.Arrays;
import java.util.Comparator;

public class Sort2DArrayComparator_7years_exp {

    public static void main(String[] args) {
        int[][] a = {{2,3,9,5},
            {2,7,4,1},
            {9,4,6,3}};

        int sortColumn = 2;

        new Sort2DArrayComparator_7years_exp().sort2D(a, sortColumn);

    }


    public void sort2D(int[][] arr, int sortColumn){

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[sortColumn-1] > o2[sortColumn-1]){
                    return 1;
                }else if(o1[sortColumn-1] < o2[sortColumn-1]){
                    return -1;
                }else {
                    return 0;
                }
            }
        });

    }
}
