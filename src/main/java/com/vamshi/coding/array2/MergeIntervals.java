package com.vamshi.coding.array2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        res.add(intervals[0]);
        int res_index = 0;

        int prev[] = intervals[0];

        int start = intervals[0][0];
        int end = intervals[0][1];


        for(int i=1; i < intervals.length; i++){

            if(intervals[i][0] <= end){
                res.set(res_index, new int[]{start, intervals[i][1]});
                prev = res.get(res_index);
                start = res.get(res_index)[0];
                end = res.get(res_index)[1];
                res_index++;
            }else{
                res.add(res_index, new int[]{intervals[i][0], intervals[i][1]});
                prev = res.get(res_index);
                start = res.get(res_index)[0];
                end = res.get(res_index)[1];
                res_index++;
            }

        }

        int[][] resultArray = res.toArray(new int[0][]);

        for(int i=0; i < resultArray.length;i++){
            System.out.println(resultArray[i][0] + " " + resultArray[i][1]);
        }

    }
}
