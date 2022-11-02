package com.vamshi.coding.array2;

import java.util.Arrays;

public class Practise {

    public int[][] merge(int[][] intervals) {

        int[][] res= new int[intervals.length][2];
        int resIndex=0;

        for(int i = 1; i < intervals.length; i++){

            int[] prev = intervals[i-1];
            int[] curr = intervals[i];

            if(curr[0] <= prev[1]){
                int[] list = {prev[0], curr[1]};
                res[resIndex] = list;
            }else{


            }
        }


        return res;


    }


    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        Practise practise = new Practise();
        int[][] res = practise.merge(intervals);

        Arrays.stream(res).sequential().forEach(System.out::println);
    }
}
