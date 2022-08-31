package com.vamshi.coding.array3;

public class PowXN_rec {


    public static void main(String[] args) {
        double ans = 1.0;
        double x = 2;
        double n = 10;
        double nn =n;

        ans = rec(x,n);

        if(n < 0) ans = (double)1.0/(double)ans;
        System.out.println("result is " + ans);
    }
    static double rec(double x, double n){
        if(n == 0 ){
            return 1;
        }
        if(n % 2 == 0){
            return rec(x*x, n/2);
        }else{
            return x*rec(x, n-1);
        }
    }
}
