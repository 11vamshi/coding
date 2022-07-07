package com.vamshi.coding.dpseries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// tabulation starts from the top right, with base case and fill up the table,
// we are not crossing boundaries anywhere
// TC m*n, since we are pre-calculating and storing for future use
// SC m*n for dp, which can be further optimised
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
