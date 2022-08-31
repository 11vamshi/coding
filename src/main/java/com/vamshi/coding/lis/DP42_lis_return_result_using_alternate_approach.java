package com.vamshi.coding.lis;

import java.util.Arrays;

public class DP42_lis_return_result_using_alternate_approach {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 4, 11, 1, 16, 8};

        int n = arr.length;

        // since every element can act as lis individually
        int[] dp = new int[n];
            Arrays.fill(dp, 1);

        int[] hash = new int[n];


            int maxi = 1;
            int lastIndex = 0;
            for(int i=0; i < n; i++){
                hash[i] = i;
                for(int prev=0; prev < i; prev++){

                    if(arr[prev] < arr[i] && dp[i] < (1 + dp[prev])  ){
                        dp[i] = 1 + dp[prev];
                        hash[i] = prev;
                    }
                }
            if(maxi < dp[i]){
                maxi = dp[i];
                lastIndex = i;
            }

            }

        System.out.println(" result is " + maxi);

        int[] result = new int[maxi];
        result[0] = arr[lastIndex];
        int index = 1;
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            result[index] = arr[lastIndex];
            index++;
        }

        for(int i =0; i < result.length; i++){
            System.out.print(" " + result[i]);
        }

    }


}
