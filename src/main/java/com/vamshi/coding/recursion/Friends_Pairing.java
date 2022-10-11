package com.vamshi.coding.recursion;

// pre-req handshake

//https://www.youtube.com/watch?v=SHDu0Ufjyk8
//8:40 into the video
public class Friends_Pairing {

    public static void main(String[] args) {
        int n = 9;
        System.out.println("result is " + rec(n));
    }

    private static int rec(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }

        return rec(n-1) + (n-1)*rec(n-2);

    }

    private static int tabulation(int n){
        int dp[] = new int[n+1];
//        dp[0]  not needed, since if there is no person, then result means nothing
        dp[1] = 1;
        dp[2] = 2;


    for(int i=3; i <=n;i++){
        dp[i] = dp[i-1] + (n-1)*dp[i-2];
    }

    return dp[n];
    }
}
