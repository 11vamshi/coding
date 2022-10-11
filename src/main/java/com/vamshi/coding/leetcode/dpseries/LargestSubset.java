package com.vamshi.coding.leetcode.dpseries;

public class LargestSubset {

    public int findMaxForm(String[] strs, int m, int n) {
        int res =0;
        int[] placeHolder = new int[2];
        for(String str: strs){
            rec(str, placeHolder, str.length()-1);

            if(placeHolder[0] <= m && placeHolder[1] <= n){
                res+=1;
            }
        }
        return res;
    }

    public void rec(String str, int[] placeHolder, int index){
        if(index == -1){
            return ;
        }

        if(str.charAt(index) == 1){
            placeHolder[1] = placeHolder[1] +1;
        }
        if(str.charAt(index) == 0){
            placeHolder[0] = placeHolder[0] +1;
        }
        rec(str, placeHolder, index-1);
    }

}
