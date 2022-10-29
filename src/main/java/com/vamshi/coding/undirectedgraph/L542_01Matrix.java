package com.vamshi.coding.undirectedgraph;

import java.util.LinkedList;
import java.util.Queue;

// If question asks nearest element, go for BFS
public class L542_01Matrix {

    public int[][] updateMatrix(int[][] mat) {

        Queue<Node01> q = new LinkedList<>();
        int[][] vis = new int[mat.length][mat[0].length];
        int[][] dis = new int[mat.length][mat[0].length];
        int[] row_delta = {-1,0,1,0};
        int[] col_delta = {0,1,0,-1};

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.add(new Node01(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }


        while(!q.isEmpty()){
            Node01 curr = q.poll();
            int curr_x = curr.x;
            int curr_y = curr.y;
            int curr_dist = curr.distance;
            dis[curr_x][curr_y] = curr_dist;


            for(int i=0; i<4; i++){
                int new_x = curr_x + row_delta[i];
                int new_y = curr_y + col_delta[i];
                int new_distance = curr_dist + 1;

                if(new_x >= 0 && new_x < mat.length &&
                        new_y >=0 && new_y < mat[0].length &&
                        vis[new_x][new_y] == 0 && mat[new_x][new_y] == 1){
                    q.add(new Node01(new_x, new_y, new_distance));
                    vis[new_x][new_y] = 1;
                }
            }

        }

    return dis;

    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,1,1,0},
                {1,1,0,0},
                {0,0,1,1}
        };

        L542_01Matrix l542_01Matrix = new L542_01Matrix();

        int[][] ans = l542_01Matrix.updateMatrix(grid);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Node01 {
    int x;
    int y;
    int distance;

    public Node01(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}