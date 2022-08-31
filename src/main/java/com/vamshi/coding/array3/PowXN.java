package com.vamshi.coding.array3;

public class PowXN {


    public static void main(String[] args) {
        double ans = 1.0;
        double x = 2.00000;
        double n = -2147483648;
        double nn =n;

        if (nn < 0){
            nn = -1 * nn;
        }

        while(nn > 0){
            if(nn % 2 == 1){
                ans = x * ans;
                nn = nn-1;
            }else{
                x = x*x;
                nn = nn/2;
            }
        }

        if(n < 0) ans = (double)1.0/(double)ans;
        System.out.println("result is " + ans);
    }
}
