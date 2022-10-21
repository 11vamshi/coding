package com.vamshi.coding.undirectedgraph;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DFS {


    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();


        dfs(0, adj, vis, res);
        return res;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                                   boolean[] vis, ArrayList<Integer> ls) {
        vis[node] = true;
        ls.add(node);

        for(Integer neighbour: adj.get(node)) {
            if(vis[neighbour] == false) {
                dfs(neighbour, adj, vis, ls);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i < 5; i ++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);

        ArrayList<Integer> ans = dfsOfGraph(5, adj);

        ans.forEach(System.out::println);

    }
}

