package com.vamshi.coding.directedgraph;

import java.util.ArrayList;

public class CycleDetection_DFS {


    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int[] path_vis, int i) {
       vis[i] = 1;
       path_vis[i] = 1;

       for(int neighbour: adj.get(i)){
           if(vis[neighbour] == 0 ){
               if(dfs(adj,vis, path_vis,neighbour)){
                   return true;
           }
           }else if(path_vis[neighbour] == 1){
               return true;
           }
       }
        path_vis[i] = 0;
        return false;
    }

    private boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[v];
        int[] path_vis = new int[v];

        for(int i=0; i < v; i++){
            if(vis[i] == 0){
                if(dfs(adj, vis, path_vis, i)){
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        CycleDetection_DFS obj = new CycleDetection_DFS();
        boolean ans = obj.isCyclic(V, adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");

    }

}
