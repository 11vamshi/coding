package com.vamshi.coding.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L40_combination_sum_2 {

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        // sort is necessary
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        rec(0, candidates, target, result, new ArrayList<>());

        result.stream().forEach(list -> {
            for (Integer l:list) {
                System.out.print(l);
            }
            System.out.println(" ");
        });

    }

    public static void rec(int ind, int[] candidates, int target, List<List<Integer>> result, List<Integer> ds){

        if(target == 0){
            result.add(new ArrayList < > (ds));
            return;
        }


        for(int i = ind; i < candidates.length; i++){
            //ignoring the same element again, since it will produce same result, which should be ignored
            if(i > ind && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] > target) break;

            ds.add(candidates[i]);
            rec(i+1,candidates, target-candidates[i], result, ds);
            ds.remove(ds.size() - 1);
        }

    }
}
