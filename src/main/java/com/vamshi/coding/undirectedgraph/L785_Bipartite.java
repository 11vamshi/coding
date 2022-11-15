package com.vamshi.coding.undirectedgraph;

import java.util.*;

public class L785_Bipartite {

    private boolean check(int start, int[][] graph, int[] color) {

    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    color[start] = 0;

    while(!q.isEmpty()){
        int curr = q.poll();

        for(int neighbour: graph[curr]){
            if(color[neighbour] == -1){
                color[neighbour] = 1-color[curr];
                q.add(neighbour);
            }else if(color[neighbour] == color[curr]){
                return false;
            }

        }
    }
    return true;
    }
    public boolean isBipartite(int[][] graph) {

        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for(int i=0; i < graph.length;i++){
            if(color[i] == -1){
                if(check(i, graph, color) == false){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        L785_Bipartite l785Bipartite = new L785_Bipartite();

        int[][] graph = {{1,3}, {0,2}};
        System.out.println("Is bipartite " + l785Bipartite.isBipartite(graph));
    }

}
