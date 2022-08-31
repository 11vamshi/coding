package com.vamshi.coding.dpseries;

import java.util.Arrays;

// things to remember
// you need a k+1 table
// prereq dp 17
// if you forget mod, you wil fail few tests


// TC with dp Reason: At max, there will be N*M calls and result stored in dp

// same as DP 14, except dp is int dp instead of boolean, and to consider 0's
// in input string base conditions differ and inner loop at 71 starts at index=0

// s1 - s2 = d => s1 = d+s2;
// s1 + s2 = total    => d+s2 + s2 = total     => s2 = total-d/2

public class DP18_CountAllSubSetsWithDifferenceK_Tabulation {

    static int mod =(int)(Math.pow(10,9)+7);

    public static void main(String[] args) {

//        int[] arr = new int[]{1, 0, 8, 5, 1, 4};
        int arr[] = {0, 4, 0, 0, 13, 7, 10, 6, 4, 2, 7};
        int n = arr.length;
        int k = 0;

        int d = 3;

        for(int i=0; i <arr.length; i++){
            k+=arr[i];
        }

        if(k-d < 0 || (k-d) % 2 == 1 ) {
            System.out.println("no subsets possible");
//            return 0;
        }


        k = (k-d)/2;
        int[][] dp = new int[n][k+1];


        tabulation(arr, n, k, dp);

        // printing dp
        printDp(n, k, dp);

        System.out.println(" result is "+ dp[n-1][k]);
    }

    private static void tabulation(int[] arr, int n, int k, int[][] dp) {
        for(int[] row: dp){
            Arrays.fill(row, 0);
        }

        // this considers if first element is '0'
        if(arr[0] == 0){
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        }

        // first element can be part of subset, if it is less than or = to target
        if(k >= arr[0] && arr[0]!=0){
            dp[0][arr[0]] = 1;
        }


        for(int index=1; index < n; index++){

            for(int currentTarget=0; currentTarget <= k; currentTarget++){



                // target could have been achieved with subset ending at previous index
                int notTaken = dp[index-1][currentTarget];

                int taken = 0;
                // target-arr[index] could have been achieved with subset ending at previous index
                if(currentTarget >= arr[index]){
                    taken = dp[index-1][currentTarget-arr[index]];
                }


                dp[index][currentTarget] = (taken+notTaken) % mod;
            }

        }
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

