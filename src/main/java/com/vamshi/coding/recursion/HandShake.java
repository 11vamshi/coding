package com.vamshi.coding.recursion;

public class HandShake {

    public static void main(String[] args) {
        int n = 9;
        System.out.println("result is " + rec(n));
    }

    private static int rec(int n){
        if(n == 0){
            return 0;
        }

        return n-1 + rec(n-1);
    }
}
