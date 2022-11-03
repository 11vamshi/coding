package com.vamshi.coding.undirectedgraph;

import java.util.ArrayList;
import java.util.HashSet;

public class IslandCount_Extension {


    private void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList<String> vector,
                     int base_x, int base_y) {

        int[] row_delta = {-1,0,1,0};
        int[] col_delta = {0,1,0,-1};

        vis[row][col] = 1;
        vector.add(toString(row-base_x,col-base_y));

        for(int i=0; i<4;i++){
            int row_n = row + row_delta[i];
            int col_n = col + col_delta[i];

            if(row_n>=0 && row_n < grid.length &&
                    col_n >=0 && col_n < grid[0].length &&
                    vis[row_n][col_n] == 0 && grid[row_n][col_n] == 1){
                dfs(row_n,col_n,vis, grid, vector, base_x, base_y);
            }

        }

    }

    private String toString(int r, int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    int countDistinctIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] vis = new int[rows][cols];
        HashSet<ArrayList<String>> set = new HashSet<>();

        for(int i=0; i<rows;i++){
            for(int j=0; j<cols;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> vector = new ArrayList<>();
                    dfs(i,j,vis,grid,vector, i,j);
                    set.add(vector);

                }
            }
        }
    return set.size();
    }


}
