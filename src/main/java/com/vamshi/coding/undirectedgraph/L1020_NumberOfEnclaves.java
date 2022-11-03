package com.vamshi.coding.undirectedgraph;


import java.util.LinkedList;
import java.util.Queue;

// similar to surrounded regions problem, except instead of converting them, we need to return count
// we used dfs there, will use bfs here
public class L1020_NumberOfEnclaves {

    private void bfs(int row, int col, int[][] grid, int[][] vis){
        int[] row_delta = {-1,0,1,0};
        int[] column_delta = {0,1,0,-1};

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(row, col));
        vis[row][col] = 1;


        while(!q.isEmpty()){
            Pair curr = q.poll();
            int curr_r = curr.x;
            int curr_c = curr.y;

            for(int i=0; i<4;i++){

                int new_r = curr_r + row_delta[i];
                int new_c = curr_c + column_delta[i];

                if(new_r >=0 && new_r < grid.length &&
                        new_c >=0 && new_c < grid[0].length &&
                        vis[new_r][new_c] == 0 && grid[new_r][new_c] == 1
                ){
                    q.add(new Pair(new_r, new_c));
                    vis[new_r][new_c] = 1;
                }

            }

        }

    }
    public int numberOfEnclaves(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] vis = new int[rows][cols];

        // first row
        for(int j=0; j < cols;j++){
            if(grid[0][j] == 1 && vis[0][j] == 0){
                bfs(0,j, grid, vis);
            }
        }

        // last row
        for(int j=0; j < cols;j++){
            if(grid[rows-1][j] == 1 && vis[rows-1][j] == 0){
                bfs(rows-1, j, grid, vis);
            }
        }

        // first column
        for(int i=0; i < rows;i++){
            if(grid[i][0] == 1 && vis[i][0] == 0){
                bfs(i, 0, grid, vis);
            }
        }

        // last column
        for(int i=0; i < rows;i++){
            if(grid[i][cols-1] == 1 && vis[i][cols-1] == 0){
                bfs(i, cols-1, grid, vis);
            }
        }
        int res = 0;
        for(int i=0; i < rows;i++){
            for(int j=0;j< cols;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int grid[][] = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};

        L1020_NumberOfEnclaves ob = new L1020_NumberOfEnclaves();
        int ans = ob.numberOfEnclaves(grid);
        System.out.println(ans);
    }

}
