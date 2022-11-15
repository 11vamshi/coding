package com.vamshi.coding.directedgraph;

import java.util.*;

public class L269_Alien_Dictionary {

    private int[] topoSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];

        for(int i=0; i < V; i++){
            for(int neighbour:adj.get(i)){
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

        while(!q.isEmpty()){

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
            return res;
        }
        return new int[]{};
    }

    public String alienOrder(String[] words){
        int characterSetSize = findUniqueAlphabetCount(words);

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i < characterSetSize; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < words.length-1; i++) {
            String first = words[i];
            String second = words[i + 1];

            //edge case covered
            int len = Math.min(first.length(), second.length());

            for (int k = 0; k < len; k++) {
                if (first.charAt(k) != second.charAt(k)) {
                    adj.get(first.charAt(k) - 'a').add(second.charAt(k) - 'a');
                    break;
                }
            }
        }
            int[] res = topoSort(characterSetSize, adj);

            if(res.length != 0){
                String resString = "";
                for(int z=0; z < res.length; z++){
                        resString = resString + (char)(res[z] + (int)('a'));
                }

                return resString;
            }


        return "";
    }



    private int findUniqueAlphabetCount(String[] words) {
        Set<Character> characterSet = new HashSet<>();
        for(int i=0; i < words.length; i++){

            for(int j=0; j< words[i].length(); j++){
                characterSet.add(words[i].charAt(j));
            }

        }
        return characterSet.size();
    }


    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};

        L269_Alien_Dictionary obj = new L269_Alien_Dictionary();
        String ans = obj.alienOrder(dict);

        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println("");
    }


}
