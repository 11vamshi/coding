package com.vamshi.coding.dpseries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// recursion starts from the bottom right, opposite to tabulation solution, we cross boundaries
// when going up j < 0 or going left i < 0, so we have 2 boundary conditions
// we need dp array in recursion as usual
// TC exponential, since each place has 2 calculations to make pow(2, m*n)
// SC stack(n) + m*n for dp..........stack(n) => at max stack will have n method calls
public class DP9_GridUniquePaths_Obstacles {

    public static void main(String[] args) {
        ArrayList<List<Integer>> maze = new ArrayList<>();

        maze.add(List.of(0,0,0));
        maze.add(List.of(0,-1,0));
        maze.add(List.of(0,0,0));

//        maze.add(List.of(0, -1, 0, 0, -1, 0, 0, 0, 0 ));
//        maze.add(List.of(-1, 0, 0, 0, 0, -1, -1, 0, 0 ));
//        maze.add(List.of(0, 0, 0, -1, -1, 0, 0, 0, 0 ));
//        maze.add(List.of(-1, 0, -1, 0, 0, 0, 0, 0, -1 ));
//        maze.add(List.of(-1, 0, 0, 0, 0, 0, -1, -1, 0 ));

        int m = maze.size();
        int n = maze.get(0).size();

        int[][] dp = new int[m][n];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(countWays(m-1, n-1, maze, dp));
    }

    static int countWays(int i, int j, ArrayList<List<Integer>> maze, int[][] dp){

        if( i == 0 && j == 0){
            return 1;
        }
        if( i < 0 || j < 0){
            return 0;
        }
        if( maze.get(i).get(j) == -1){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up = countWays(i-1, j,maze, dp);
        int left = countWays(i, j-1, maze, dp);

    return dp[i][j] = up+left;
    }
}