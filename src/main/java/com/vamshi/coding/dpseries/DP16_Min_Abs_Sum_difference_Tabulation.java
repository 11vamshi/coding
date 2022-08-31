package com.vamshi.coding.dpseries;

// things to remember
// you need a k+1 table

// same as DP14, except use the last row of dp which gives

public class DP16_Min_Abs_Sum_difference_Tabulation {



    // same as DP14, except find sum of all elements

    int sum_all = 0;
    // get sum_all of all elements

    // get tabulation solution from DP 14, with k as sum_all


    int mini = (int)Math.pow(10, 7);


    // further optimization can be done if we only loop through half of dp or create a dp
    // with k = sum_all/2 or sum_all+1/2(if sum_all is odd) in the previous step
//    for( int s1 = 0; s1 <= sum_all; s1++){
//        if(dp[n-1][s1] == true){
//            mini = Math.min(mini, Math.abs((sum_all-s1)-s1));
//        }
//
//    }
//
//    return mini;




//20   4  5  6  8   9
//     16 15 14 12  11
//     12 10 8  4   2
}

