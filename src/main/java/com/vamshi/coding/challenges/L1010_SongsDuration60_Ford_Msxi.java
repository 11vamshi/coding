package com.vamshi.coding.challenges;

import java.util.HashMap;
import java.util.Map;

// [30,20,150,100,40]
// [30,20,30]

// big integer multipled by big integer can result in overflow below
// so converted to long until divided by 2
// res += ((long)size * (size - 1) / 2);
public class L1010_SongsDuration60_Ford_Msxi {

        public int numPairsDivisibleBy60(int[] time) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int cur : time){
                int remainder = cur % 60;
                map.put(remainder, map.getOrDefault(remainder, 0) + 1);
            }

            int res = 0;
            for(int remainder : map.keySet()){
                if(remainder > 30) continue;
                if(remainder == 0 || remainder == 30){
                    int size = map.get(remainder);
                    res += ((long)size * (size - 1) / 2);
                }else{
                    res += map.get(remainder) * map.getOrDefault(60 - remainder, 0);
                }
            }

            return res;
        }

    public static void main(String[] args) {
        int[] time = {30,20,150,100,40};

        L1010_SongsDuration60_Ford_Msxi l1010_songsDuration60FordMsxi = new L1010_SongsDuration60_Ford_Msxi();

        l1010_songsDuration60FordMsxi.numPairsDivisibleBy60(time);

    }
}
