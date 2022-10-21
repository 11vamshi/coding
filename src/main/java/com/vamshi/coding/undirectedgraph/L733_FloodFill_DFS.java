package com.vamshi.coding.undirectedgraph;

// BFS giving TLE, trying DFS
// Also never tamper input, always work on a copy

// Use copy which will also act as visited array
public class L733_FloodFill_DFS {


    private int[][] floodFill(int[][] image, int sr, int sc,int color, int[][] ans) {

        int oldColor = image[sr][sc];
        dfs(image, sr, sc, color, oldColor, ans);

        return ans;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor, int[][] ans) {
        int[] row_delta = {-1,0,+1,0};
        int[] col_delta = {0,+1,0,-1};
        ans[sr][sc] = newColor;

        for(int i=0; i<4; i++) {
            int nrow = sr + row_delta[i];
            int ncol = sc + col_delta[i];

            if (nrow >= 0 && nrow < image.length &&
                    ncol >= 0 && ncol < image[0].length &&
                    image[nrow][ncol] == oldColor && ans[nrow][ncol] != newColor) {

                System.out.println("image[nrow][ncol] " + image[nrow][ncol]);
                System.out.println("ans[nrow][ncol] " + (ans[nrow][ncol]));

                dfs(image, nrow, ncol ,newColor, oldColor, ans);
            }
        }
    }


    public static void main(String[] args) {
        int[][] image =  {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        int[][] copy = image;

        L733_FloodFill_DFS l733_floodFill = new L733_FloodFill_DFS();
        int[][] result = l733_floodFill.floodFill(copy, 1,1 ,2, copy);

        for(int i=0; i < image.length; i++){
            for(int j=0; j < image[0].length; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }


}
