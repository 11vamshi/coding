package com.vamshi.coding.undirectedgraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Practise {

        private static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
            int[] vis = new int[adj.size()];
            Arrays.fill(vis, -1);
            Queue<Pair> q = new LinkedList<>();
            vis[0] = 1;
            q.add(new Pair(0,-1));


            while(!q.isEmpty()){
                Pair curr = q.poll();
                int curr_val = curr.x;
                int curr_par = curr.y;

                for(Integer neighbour: adj.get(curr.x)){
                    if(vis[neighbour] == -1){
                        vis[neighbour] = 1;
                        q.add(new Pair(neighbour, curr_val));
                    }else if(vis[neighbour] == 1 && curr_par != neighbour){
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
