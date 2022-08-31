package com.vamshi.coding.dpseries.grid;

import java.util.Arrays;

// base case is (0,0)
// tabulation starts from top

public class DP11_Triangle_TopToAnyBottomRow_Tabulation {

    public static void main(String[] args) {

//        int[][] grid = new int[][]{{1},{2,3},{3,6,7},{8,9,6,10}};

        int[][] grid = new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}};

        int n = grid.length;
        int m = grid[n-1].length;

        int[][] dp = new int[n][m];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){

                if(i==0 && j==0){
                    dp[i][j] = grid[i][j];
                } else if(j==0){
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                } else if(i==j) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j - 1];
                } else{
                    dp[i][j] = Math.min(grid[i][j] + dp[i-1][j], grid[i][j] + dp[i-1][j-1]);
                }

            }
        }
        int min = (int)Math.pow(10,9);

        for(int i = 0; i < n; i++){
            min = Math.min(min, dp[n-1][i]);
        }

        System.out.println("result is "+ min);
    }

}

