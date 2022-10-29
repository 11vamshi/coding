package com.vamshi.coding.undirectedgraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



public class CycleDetectionBFS {

    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for(int i = 0; i < V;i++){
            if(vis[i] == false){
                if(cycleCheck(vis, adj, i)){
                    return true;
                }
            }

        }

        return false;
    }

    private static boolean cycleCheck(boolean[] vis, ArrayList<ArrayList<Integer>> adj, Integer s){
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(0,-1));
        vis[s] = true;

        while(!q.isEmpty()){
            Node curr = q.poll();
            Integer curr_val = curr.val;
            Integer curr_parent = curr.parent;

            for(Integer neighbor : adj.get(curr.val)){
                if(vis[neighbor] == false){
                    q.add(new Node(neighbor, curr_val));
                    vis[neighbor] = true;  // forgot this line earlier
                }else if(neighbor != curr_parent){  // means visited = true
                    return true;
                }

            }

        }
        return false;
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

        System.out.println("Is cycle " + isCycle(5, adj));
        }

}


class Node {
    Integer val;
    Integer parent;

    public Node(Integer val, Integer parent) {
        this.val = val;
        this.parent = parent;
    }
}