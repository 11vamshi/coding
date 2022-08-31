package com.vamshi.coding.dpseries.grid;

import java.util.Arrays;

// tabulation starts from the top right, with base case and fill up the table,
// we are not crossing boundaries anywhere
// TC m*n, since we are pre-calculating and storing for future use; Reason: There are two nested loops
// SC m*n for dp, which can be further optimised - Reason: We are using an external array of size ‘N*M’’.


public class DP10_GridMinPathSum_Tabulation_Solution2 {

    public static void main(String[] args) {

        int[][] grid = new int[][]{{5, 9, 6},{11, 5, 2}};

        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        for(int i=0; i < n ; i++){

            for(int j =0; j < m ; j++){

                if(i==0 && j==0){
                   dp[i][j] = grid[i][j];
                }
                else{
                    int up = (int)Math.pow(10, 9);
                    int left = (int)Math.pow(10, 9);
                    if(i > 0){
                        up = grid[i][j] + dp[i-1][j];
                    }
                    if(j > 0){
                        left = grid[i][j] + dp[i][j-1];
                    }

                    dp[i][j] = Math.min(up, left);
                }

            }
        }
        System.out.println(dp[n-1][m-1]);
    }

}