package com.vamshi.coding.dpseries;

import java.util.Arrays;

// things to remember
// you need a k+1 table


// TC with dp Reason: At max, there will be N*M calls and result stored in dp

// same as DP 14, except dp is int dp instead of boolean, and this also considers '0's
// s1 - s2 = d => s1 = d+s2;
// s1 + s2 = total    => d+s2 + s2 = total     => s2 = total-d/2

public class DP18_CountAllSubSetsWithDifferenceK_Recursion {

    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {



        int[] arr = new int[]{1, 0, 8, 5, 1, 4};
        int n = arr.length;
        int d = 17;

        int totalSum = 0;

        // Iterate over the array and add the element to 'totalSum'.
        for (int i = 0; i < n; ++i) {
            totalSum += arr[i];
        }

        // If totalSum is less than 'D', or their difference is odd.
        if (totalSum < d || ((totalSum - d) % 2) == 1) {
            // Then no partitions are possible.
            System.out.println("no partitions");;
            // return 0;
        }

        // We want to find the number of subsets, with subset sum target.
        int target = (totalSum - d) / 2;

        /*
         * Create a 2D dp table.
         * dp[i][j] represents the number of subsets which form a sum of j
         * if we only consider first i elements.
         */
        int[][] dp = new int[n + 1][target + 1];

        // Initialize all the values to -1.
        for(int row[]: dp)
            Arrays.fill(row,-1);

        System.out.println("result is " + recursion( arr, n-1, target, dp));

    }

    public static int recursion(int[] arr, int n, int k, int[][] dp){

        if(n == 0){
            if(k==0 && arr[0]==0)
                return 2;
            if(k==0 || k == arr[0])
                return 1;
            return 0;
        }

        if(dp[n][k] != -1){
            return dp[n][k];
        }

        int notTaken = recursion(arr,n-1,k, dp);

        int taken = 0;
        if(k >= arr[n]){
            taken = recursion(arr,n-1,k-arr[n], dp);
        }
        return dp[n][k] = (taken + notTaken) % mod;


    }


    private static void printDp(int n, int k, int[][] dp) {
        //printing dp
        for(int i=0; i < n; i++){
            for(int j=0; j <= k; j++){
                System.out.print(dp[i][j] + "\t");

            }
            System.out.println();
        }
    }

}

