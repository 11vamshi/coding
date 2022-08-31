package com.vamshi.coding.dpseries.grid;

import java.util.Arrays;

// base case is last row
// recursion starts from top row

public class DP12_MatrixMinPathSumAnyTopToAnyBottom_Recursion {

    public static void main(String[] args) {

        int[][] grid = new int[][]{{1, 2, 10, 4},{100, 3, 2, 1},{1, 1, 20, 2},{1, 2, 2, 1}};


        int n = grid.length;
        int m = grid[n-1].length;

            int[][] dp = new int[n][m];

            for(int[] row: dp){
                Arrays.fill(row, -1);
            }
            int max = (int)Math.pow(10,-9);
            for(int j=0; j < n; j++){
                max = Math.max(countWays(0, j, grid, dp), max);
            }
        System.out.println("result is "+ max);
    }

    public static int countWays(int i, int j, int[][] grid, int[][] dp){


        if(j < 0 || j > grid[0].length-1 ){
            return (int)Math.pow(10,-9);
        }

        if( i == grid.length-1){
            return dp[i][j] = grid[i][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int down = grid[i][j] + countWays(i+1, j,grid, dp);

        int down_right_diagonal = grid[i][j] + countWays(i+1, j+1, grid, dp);

        int down_left_diagonal = grid[i][j] + countWays(i+1, j-1, grid, dp);

        return dp[i][j] = Math.max(down,Math.max(down_left_diagonal, down_right_diagonal));
    }
}

