package com.vamshi.coding.undirectedgraph;

import java.util.*;

public class Bipartite {

    private boolean check(int start, List<ArrayList<Integer>> adjList, int[] color) {

    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    color[start] = 0;

    while(!q.isEmpty()){
        int curr = q.poll();

        for(int neighbour: adjList.get(start)){
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

        List<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0; i < graph.length;i++){
            ArrayList<Integer> list = new ArrayList<>();

            for(int j=0;j< graph[0].length; j++){
                    list.add(graph[i][j]);
            }
            adjList.add(list);
        }


        int[] color = new int[adjList.size()];
        Arrays.fill(color, -1);

        for(int i=0; i < adjList.size();i++){
            if(color[i] == -1){
                if(check(i, adjList, color) == false){
                    return false;
                }
            }
        }

        return true;
    }

}
