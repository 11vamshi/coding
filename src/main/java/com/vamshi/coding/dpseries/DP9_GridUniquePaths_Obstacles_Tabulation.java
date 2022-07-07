package com.vamshi.coding.dpseries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// tabulation starts from the top right, with base case and fill up the table,
// we are not crossing boundaries anywhere
// TC m*n, since we are pre-calculating and storing for future use
// SC m*n for dp, which can be further optimised

// this solution although passing all tests, failing on submission, solution at the bottom is
// success on submission
public class DP9_GridUniquePaths_Obstacles_Tabulation {

    public static void main(String[] args) {

        ArrayList<List<Integer>> maze = new ArrayList<>();

//        maze.add(List.of(0,0,0));
//        maze.add(List.of(0,-1,0));
//        maze.add(List.of(0,0,0));
        maze.add(List.of(0, -1));
        maze.add(List.of(-1, 0));

        int n = maze.size();
        int m = maze.get(0).size();

        int[][] dp = new int[n][m];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(i==0 && j==0){
                    dp[i][j] = 1;
                }
                else if (maze.get(i).get(j) == -1){
                    dp[i][j] = 0;
                }
                else{
                    int up = 0;
                    int left = 0;
                    if(i > 0){
                        up = dp[i-1][j];
                    }
                    if(j > 0){
                        left = dp[i][j-1];
                    }


                    dp[i][j] =  left + up;
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
    }

}

// strivers solution is also failing in coding ninjas upon submission
//import java.util.*;
//public class Solution {
//    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
//        int[][] dp = new int[n][m];
//
//        for(int[] row: dp){
//            Arrays.fill(row, -1);
//        }
//
//
//        for(int i=0; i<n ;i++){
//            for(int j=0; j<m; j++){
//
//                //base conditions
//                if(i>=0 && j>=0 && mat.get(i).get(j)==-1){
//                    dp[i][j]=0;
//                    continue;
//                }
//                if(i==0 && j==0){
//                    dp[i][j]=1;
//                    continue;
//                }
//
//                int up=0;
//                int left = 0;
//
//                if(i>0)
//                    up = dp[i-1][j];
//                if(j>0)
//                    left = dp[i][j-1];
//
//                dp[i][j] = up+left;
//            }
//        }
//
//        return dp[n-1][m-1];
//
//
//    }
//}


// working solution fills up first row and column
//{
//
//
//        // dp table to store the already calculated values.
//        int[][] dp = new int[n][m];
//        // Base case for first cell.
//        dp[0][0] = 1;
//
//        // Fill the first column.
//        for (int i = 1; i < n; i++) {
//        if (mat.get(i).get(0) == 0) {
//        dp[i][0] = dp[i - 1][0];
//        }
//        }
//
//        // Fill the first row.
//        for (int i = 1; i < m; i++) {
//        if (mat.get(0).get(i) == 0) {
//        dp[0][i] = dp[0][i - 1];
//        }
//        }
//
//        int mod = 1000000007;
//        // Calculate for each cell dp[i][j].
//        for (int i = 1; i < n; i++) {
//        for (int j = 1; j < m; j++) {
//        if (mat.get(i).get(j) == 0) {
//        dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
//        }
//        }
//        }
//
//        // Return the number of ways to reach the bottom-right cell in the maze.
//        return dp[n - 1][m - 1];
//        }