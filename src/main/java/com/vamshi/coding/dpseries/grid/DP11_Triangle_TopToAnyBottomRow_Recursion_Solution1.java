package com.vamshi.coding.dpseries.grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// base case is (0,0)
// recursion starts from each cell of bottom row
// TC exponential without dp
// TC with dp Reason: At max, there will be N*M calls of recursion. because might be stored in dp
public class DP11_Triangle_TopToAnyBottomRow_Recursion_Solution1 {

    public static void main(String[] args) {

        int[][] grid = new int[][]{{1},{2,3},{3,6,7},{8,9,6,10}};


        int n = grid.length;
        int m = grid[n-1].length;

        int[][] dp = new int[n][m];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        int min = (int)Math.pow(10,9);
        for(int i=0; i < m; i++){
            min = Math.min(min, countWays(n-1, i, grid, dp));
        }

        System.out.println("result is "+ min);
    }

    public static int countWays(int i, int j, int[][] grid, int[][] dp){

        if( j < 0 || j >i ){
            return (int)Math.pow(10,9);
        }

        if( i == 0 && j == 0){
            return grid[i][j];
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int up = grid[i][j] + countWays(i-1, j,grid, dp);

        int top_left_diagonal = grid[i][j] + countWays(i-1, j-1, grid, dp);

        return dp[i][j] = Math.min(up, top_left_diagonal);
    }
}