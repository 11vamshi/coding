package com.vamshi.coding.directedgraph;

import java.util.ArrayList;
import java.util.List;

public class L802_EventualSafeState_DFS {

    private boolean dfs(int[][] graph, int[] vis, int[] path_vis, int[] result_store, int curr_node) {
        vis[curr_node] = 1;
        path_vis[curr_node] = 1;

        for(int neighbour:graph[curr_node]){
            if(vis[neighbour] == 0){
                if(dfs(graph, vis, path_vis, result_store, neighbour)){
                    return true;
                }

            }else if(path_vis[neighbour] == 1){
                return true;
            }

        }
        result_store[curr_node] = 1;
        path_vis[curr_node] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<Integer> res = new ArrayList<>();
        int[] vis = new int[graph.length];
        int[] path_vis = new int[graph.length];
        int[] result_store = new int[graph.length];


        for(int i=0; i < graph.length;i++){
            if(vis[i] == 0){
                dfs(graph, vis, path_vis, result_store, i);
            }
        }

        for(int i=0; i < graph.length;i++){
            if(result_store[i] == 1){
                res.add(i);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        L802_EventualSafeState_DFS l802_eventualSafeStateDFS = new L802_EventualSafeState_DFS();
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};

        List<Integer> res = l802_eventualSafeStateDFS.eventualSafeNodes(graph);
        res.forEach(System.out::println);

    }


}
