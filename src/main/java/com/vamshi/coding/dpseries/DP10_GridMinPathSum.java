package com.vamshi.coding.dpseries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.MAX_VALUE;

// recursion starts from the bottom right, opposite to tabulation solution, we cross boundaries
// when going up j < 0 or going left i < 0, so we have 2 boundary conditions
// we need dp array in recursion as usual
// TC exponential, since each place has 2 calculations to make pow(2, m*n)
// SC stack(n) + m*n for dp..........stack(n) => at max stack will have n method calls
public class DP10_GridMinPathSum {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{5, 9, 6},{11, 5, 2}};


        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(countWays(n-1, m-1, grid, dp));
    }

    public static int countWays(int i, int j, int[][] grid, int[][] dp){

        if( i == 0 && j == 0){
            return grid[i][j];
        }
        if( i < 0 || j < 0){
            return (int)Math.pow(10,9);
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up = grid[i][j] + countWays(i-1, j,grid, dp);
        int left = grid[i][j] + countWays(i, j-1, grid, dp);


    return dp[i][j] = Math.min(up, left);
    }
}