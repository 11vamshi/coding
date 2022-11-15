package com.vamshi.coding.directedgraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort_BFS {


    private static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {

        int[] inDegree = new int[v];

        for(int i=0; i < v;i++){
           for(int neighbour:adj.get(i)){
               inDegree[neighbour]++;
           }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i < v;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        int[] res = new int[v];
        int result_index=0;

        while (!q.isEmpty()){
            int curr = q.poll();
            res[result_index++] = curr;

            for(int neighbour: adj.get(curr)){
               inDegree[neighbour]--;

               if(inDegree[neighbour] == 0){
                   q.add(neighbour);
               }
            }
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

        int[] ans = TopologicalSort_BFS.topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }

}
