package com.vamshi.coding.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubSetSum {

    public static void main(String[] args) {


        SubSetSum s = new SubSetSum();

//        ArrayList<Integer> result = subsetSum(new int[]{1,2,3});
//        for (Integer i:
//             result) {
//            System.out.println(i);
//        }

    }

    public static ArrayList<Integer> subsetSum(int num[]) {

        ArrayList<Integer> res = new ArrayList<>();
        recursion(num, res, 0,0);
        Collections.sort(res);
        return res;

    }

    private static void recursion(int[] num, ArrayList<Integer> res, int currentSum, int n) {

        if(n == num.length){
            res.add(currentSum);
            return;
        }
        recursion(num, res, currentSum+num[n],n+1);
        recursion(num, res, currentSum,n+1);
    }

}
