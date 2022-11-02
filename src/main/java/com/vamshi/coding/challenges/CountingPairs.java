package com.vamshi.coding.challenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


// [1,2,3,4,5,6]
// k = 2
//1 -> 1
//2 -> 2
public class CountingPairs {

    public static int countPairs(List<Integer> numbers, int k) {
        int resCount = 0;

        HashMap<Integer, Integer> counter = new HashMap<>();

        for(Integer num:numbers){
            if(counter.containsKey(num + k)){
                resCount = resCount + counter.get(num + k);
            }

            if(counter.containsKey(num - k)){
                resCount = resCount + counter.get(num - k);

            }

            counter.put(num, counter.getOrDefault(num, 0)+1);
        }


        return resCount;
    }
    public static void main(String[] args) {
        int n = 4;
        int[] numbers = {1, 1, 1, 2};
        int k = 1;

        List<Integer> numbers1  = Arrays.stream(numbers).boxed().collect(Collectors.toList());
    }
}
