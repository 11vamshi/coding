package com.vamshi.coding.directedgraph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort_DFS {


    private static void dfs(int node, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for(int neighbour: adj.get(node)){
            if(vis[neighbour] == 0){
                dfs(neighbour, vis, st, adj);
            }
        }

        st.push(node);
    }

    private static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] res= new int[v];
        int vis[] = new int[v];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i <v; i++ ){
            if(vis[i] == 0){
                dfs(i, vis, st, adj);
            }
        }

        int i = 0;
        while(!st.isEmpty()){
            res[i++] = st.pop();
        }
    return res;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = TopologicalSort_DFS.topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }

}
