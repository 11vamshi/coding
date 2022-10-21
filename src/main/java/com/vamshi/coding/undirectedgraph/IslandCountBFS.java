package com.vamshi.coding.undirectedgraph;

import java.util.LinkedList;
import java.util.Queue;
// make sure grid[i][j] = '1' and not 1, since '1' and 1 are different characters

// leetcode question gives TLE since, only vertical and horizontal connections are islands, not diagonal

//        int delta_row[] = {-1, 0, 1, 0};
//        int delta_col[] = {0, 1, 0, -1};
//            for (int i = 0; i < 4; i++)
//        {
//        int neighbour_row = r + delta_row[i];
//        int neighbour_col = c + delta_col[i];
// in which case 2 for loops are not needed, just 1 is enough

public class IslandCountBFS {

    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int result=0;
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] vis = new int[rows][columns];

        for(int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if(grid[row][col] == '1' && vis[row][col] == 0){
                    extracted(grid, row, col, vis);
                    result++;
                }
            }
        }
        return result;
    }
    private void extracted(char[][] grid, int row, int col, int[][] vis) {

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = 1;

        while (!q.isEmpty()){
            Pair curr = q.poll();
            int curRow = curr.x;
            int curCol = curr.y;

            for(int delRow=-1; delRow <=1; delRow++){
                for(int delCol=-1; delCol <=1; delCol++){
                    int nrow = curRow + delRow;
                    int ncol = curCol + delCol;

                    if(nrow >=0 && nrow < grid.length && ncol >=0 && ncol < grid[0].length &&
                            vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x =x;
            this.y=y;
        }
    }

    public static void main(String[] args) {

        char grid[][] = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};

        IslandCountBFS bfsPrac = new IslandCountBFS();

        bfsPrac.numIslands(grid);


    }
}
