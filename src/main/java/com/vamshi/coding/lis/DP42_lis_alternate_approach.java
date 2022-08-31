package com.vamshi.coding.lis;

import java.util.Arrays;

public class DP42_lis_alternate_approach {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 4, 11, 1, 16, 8};

        int n = arr.length;

        // since every element can act as lis individually
        int[] dp = new int[n];
            Arrays.fill(dp, 1);

            int maxi = 1;
            for(int i=0; i < n; i++){
                for(int prev=0; prev < i; prev++){

                    if(arr[prev] < arr[i] && dp[i] < (1 + dp[prev])  ){
                        dp[i] = 1 + dp[prev];
                    }
                }
            maxi = Math.max(maxi, dp[i]);
            }

        System.out.println(" result is " + maxi);


    }


}
