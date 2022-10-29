package com.vamshi.coding.undirectedgraph;

import java.util.LinkedList;
import java.util.Queue;

public class L994_Rotten_Oranges {
    public int orangesRotting(int[][] grid) {

        Queue<Pair> q = new LinkedList<>();
        int[] row_delta = {-1,0,1,0};
        int[] col_delta = {0,1,0,-1};
        int timeTaken = 0;
        int count_fresh = 0;

        for(int i=0; i < grid.length;i++){
            for(int j=0; j < grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                }else if(grid[i][j] == 1){
                    count_fresh++;  // forgot to take count of fresh oranges
                }
            }
        }

        while(!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) { // forgot this for loop earlier

                Pair curr = q.poll();
                int curr_x = curr.x;
                int curr_y = curr.y;


                for (int z = 0; z < 4; z++) {
                    int new_x = curr_x + row_delta[z];
                    int new_y = curr_y + col_delta[z];

                    if (new_x >= 0 && new_x < grid.length &&
                            new_y >= 0 && new_y < grid[0].length &&
                            grid[new_x][new_y] == 1) {
                        grid[new_x][new_y] = 2;
                        q.add(new Pair(new_x, new_y));
                        count_fresh--;
                    }
                }

            }
            timeTaken++;
        }
        return count_fresh==0?timeTaken-1:-1;
    }

    public static void main(String[] args) {
//        int[][] grid = {{2,1,1},
//                        {1,1,0},
//                        {0,1,1}};

        int[][] grid = {{0}};

        L994_Rotten_Oranges l994_rotten_oranges = new L994_Rotten_Oranges();
        System.out.println("Time taken = " + l994_rotten_oranges.orangesRotting(grid));
    }


}


