package com.vamshi.coding.undirectedgraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StriverBiPartite {


    private boolean check(int start, int V, ArrayList<ArrayList<Integer>> adjList, int[] color) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()){
            int node = q.poll();

            for(int neighbor: adjList.get(node)){

                if(color[neighbor] == -1 ){
                    color[neighbor] = 1-color[node];
                    q.add(neighbor);

                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
    return true;
    }


    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adjList)
    {

        int color[] = new int[V];
        Arrays.fill(color, -1);

        for(int i=0; i<V;i++){
            if(color[i] == -1){
                if(check(i, V, adjList, color) == false){
                    return false;
                }
            }
        }
        return true;
    }

}
