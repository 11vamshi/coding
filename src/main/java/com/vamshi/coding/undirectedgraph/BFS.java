package com.vamshi.coding.undirectedgraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


// time complexity at the end
public class BFS {

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList < Integer > res = new ArrayList < > ();
        boolean vis[] = new boolean[V];

        Queue<Integer> q = new LinkedList< >();

        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()) {
            Integer curr = q.poll();
            res.add(curr);
            for (int i = 0; i < adj.get(curr).size(); i++) {
                Integer neighbour = adj.get(curr).get(i);

                if (vis[neighbour] == false) {
                    vis[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        return res;
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

        ArrayList<Integer> ans = bfsOfGraph(5, adj);

        ans.forEach(System.out::println);

    }
}

//
//    If u r confused about time complexity part, then see the following dry run of the while loop of the qs.
//    he has solved..
//
//        This is how nodes are connected(assuming undirected graph) :
//        0 -> 1 ,2, 3
//        1 -> 0
//        2 -> 0,  4
//        3 -> 0
//        4 -> 2
//        So, total no. of edges = E
//
//        For first while loop ,
//        node = 0,   edges = 3
//        Now, before going to the for loop part, u see a constant time operation O(1)  --> q.pop( )
//        This step will be executed every time we enter into while loop.
//
//        So, for first while loop how many times for loop will execute ??
//        It will be equal to the no. of edges , here it will be 3.
//
//        Therefore, total =  ( 1 + 3 )
//
//        Similarly for all other nodes, this is how it will look :
//        ( 1 + 3 )  + ( 1 + 1 ) + ( 1 + 2 ) + ( 1 + 1 ) + ( 1 + 1 )
//        =   13
//        =   O ( V  +  2 * E )