package com.vamshi.coding.directedgraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// prereq - toposort bfs
public class CourseSchedule {


    private int[] isPossible(int V, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] inDegree = new int[V];
        for(int i=0; i < V;i++){
            for(int neighbour: adj.get(i)){
                inDegree[neighbour]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i < V; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        int[] res = new int[V];
        int result_index = 0;

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


        if(result_index == V){

            // if you dont want to reverse, then when creating adj list, change line 20
            for(int i=0; i < res.length/2; i++){
                int temp = res[i];
                res[i] = res[res.length-(i+1)];
                res[res.length-(i+1)] = temp;
            }
            return res;
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] prerequisites = new int[3][2];

        prerequisites[0][0] = 1;
        prerequisites[0][1] = 0;

        prerequisites[1][0] = 2;
        prerequisites[1][1] = 1;

        prerequisites[2][0] = 3;
        prerequisites[2][1] = 2;

        CourseSchedule obj = new CourseSchedule();
        int[] res = obj.isPossible(N, prerequisites);

        for(int i=0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }

}
