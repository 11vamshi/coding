package com.vamshi.coding.undirectedgraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


// int node = curr.val;  // changing int to Integer is giving error in gfg
// check 32 if you get an error
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

        q.add(new Node(s,-1));
        vis[s] = true;

        while(!q.isEmpty()){
            Node curr = q.poll();
            int node = curr.val;  // changing int to Integer is giving error in gfg
            int curr_parent = curr.parent;

            for(int neighbor : adj.get(node)){
                if(vis[neighbor] == false){
                    q.add(new Node(neighbor, node));
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
    int val;
    int parent;

    public Node(int val, int parent) {
        this.val = val;
        this.parent = parent;
    }
}