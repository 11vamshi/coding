package com.vamshi.coding.leetcode150;

public class L7_ReverseInteger {

    public int reverse(int x) {
        int res=0;


        while(x != 0){
            int temp =  x % 10;
            x = x/10;
            res = res*10 + temp;
        }

        return res;
    }

    public static void main(String[] args) {
        int x = -123;

        L7_ReverseInteger l7_reverseInteger = new L7_ReverseInteger();
        int res = l7_reverseInteger.reverse(x);

        System.out.println("result is " + res);
    }


}
