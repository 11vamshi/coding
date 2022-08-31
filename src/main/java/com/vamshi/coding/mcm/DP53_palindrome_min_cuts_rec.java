package com.vamshi.coding.mcm;

public class DP53_palindrome_min_cuts_rec {
    public static void main(String[] args) {

        String s = "BABABCBADCEDE";
        char[] str = s.toCharArray();

        int n = str.length;

        int result = recursion(0,n,str)-1;
        System.out.println("result is  " + result);

    }

    private static int recursion(int i, int n, char[] str){

        if(i==n){return 0;}
        String temp = "";
        int mini = (int)Math.pow(10,7);

        for(int j=i; j<n ;j++){

            temp = temp+str[j];

            if(isPalindrome(temp)){
                int cost = 1+ recursion(j+1,n,str);
                mini = Math.min(mini,cost);
            }

        }
        return mini;
    }

    private static boolean isPalindrome(String temp) {
        for(int i=0; i < (temp.length()/2)+1;i++){
            if(temp.charAt(i) != temp.charAt(temp.length() -(i+1))){
                return false;
            }
        }
        return true;
    }

}
