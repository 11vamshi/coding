package com.vamshi.coding.dpseries.grid;

import java.util.Arrays;

// base case is last row
// recursion starts from (0,0)

public class DP11_Triangle_TopToAnyBottomRow_Recursion_Solution2 {

    public static void main(String[] args) {

        int[][] grid = new int[][]{{1},{2,3},{3,6,7},{8,9,6,10}};


        int n = grid.length;
            int m = grid[n-1].length;

            int[][] dp = new int[n][m];

            for(int[] row: dp){
                Arrays.fill(row, -1);
            }

        System.out.println("result is "+ countWays(0, 0, grid, dp));
    }

    public static int countWays(int i, int j, int[][] grid, int[][] dp){


        if( i == grid.length-1){
            return grid[i][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int down = grid[i][j] + countWays(i+1, j,grid, dp);

        int down_right_diagonal = grid[i][j] + countWays(i+1, j+1, grid, dp);

        return dp[i][j] = Math.min(down, down_right_diagonal);
    }
}