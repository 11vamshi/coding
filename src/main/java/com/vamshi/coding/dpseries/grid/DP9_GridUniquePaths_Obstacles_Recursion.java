package com.vamshi.coding.dpseries.grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// recursion starts from the bottom right, opposite to tabulation solution, we cross boundaries
// when going up j < 0 or going left i < 0, so we have 2 boundary conditions
// we need dp array in recursion as usual
//
// TC exponential without dp
// TC with dp Reason: At max, there will be N*M calls of recursion. because might be stored in dp
// SC stack(m+n) + m*n for dp..........stack(n) => at max stack will have n method calls
// Reason: We are using a recursion stack space:O((M-1)+(N-1)),
// here (M-1)+(N-1) is the path length and an external DP Array of size ‘N*M’.

public class DP9_GridUniquePaths_Obstacles_Recursion {

    public static void main(String[] args) {
        ArrayList<List<Integer>> maze = new ArrayList<>();

        maze.add(List.of(0,0,0));
        maze.add(List.of(0,-1,0));
        maze.add(List.of(0,0,0));


        int n = maze.size();
        int m = maze.get(0).size();

        int[][] dp = new int[n][m];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        System.out.println(countWays(n-1, m-1, maze, dp));
    }

    public static int countWays(int i, int j, ArrayList<List<Integer>> maze, int[][] dp){

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

        int mod = 1000000007;

    return dp[i][j] = (up+left) % mod;
    }
}