package com.vamshi.coding.undirectedgraph;

import java.util.LinkedList;
import java.util.Queue;

// BFS giving TLE, trying DFS
// Also never tamper input, always work on a copy, however striver created a shallow copy

// Use below condition to overcome TLE
// && image[nrow][ncol] != newColor
public class L733_FloodFill_BFS {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int[] row_delta = {-1,0,1,0};
        int[] col_delta = {0,1,0,-1};
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(sr,sc));
        int oldColor = image[sr][sc];

        image[sr][sc] = color;


        while(!q.isEmpty()){
            Pair curr = q.poll();
            int curRow = curr.x;
            int curCol = curr.y;

            for(int i=0; i <4;i++){
                int nrow = curRow + row_delta[i];
                int ncol = curCol + col_delta[i];

                if( nrow >=0 && nrow < image.length &&
                        ncol >=0 && ncol < image[0].length &&
                        image[nrow][ncol] == oldColor && image[nrow][ncol] != color){
                    image[nrow][ncol] = color;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image =  {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        L733_FloodFill_BFS l733_floodFill = new L733_FloodFill_BFS();
        int[][] result = l733_floodFill.floodFill(image, 1,1 ,2);

        for(int i=0; i < image.length; i++){
            for(int j=0; j < image[0].length; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
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