package com.vamshi.coding.challenges;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumRatingSum_Ford_Msxi {

    public static void main(String[] args) {
        int[] ratings = {-1,3,4,-2,5,-7};

        List<Integer> arr = Arrays.stream(ratings).boxed().collect(Collectors.toList());

        System.out.println("maximum contiguous sum is " + maximumSum(arr));
    }


    // 2 5 7

    // 1st iteration = 2, 2
    // 2nd = 7,7
    // 3rd = 14, 14


    //2 -1 7 -1

    // 1st iteration = 2, 2
    // 2nd = -1,2
    // 3rd = 7, 7
    public static long maximumSum(List<Integer> list) {

        int sumSoFar = 0;
        long maxSum = 0;
        for(int i =0; i < list.size(); i++){
            sumSoFar = Math.max(sumSoFar + list.get(i), list.get(i) );
            maxSum = Math.max(maxSum, sumSoFar);
        }
        return maxSum;

    }
}
