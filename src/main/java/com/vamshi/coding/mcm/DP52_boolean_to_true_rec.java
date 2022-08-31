package com.vamshi.coding.mcm;

public class DP52_boolean_to_true_rec {

    static long prime = (int)Math.pow(10,9)+7;
    public static void main(String[] args) {
        String exp2 = "T^T^F";
        char[] exp = exp2.toCharArray();

        System.out.println("result is " + recursion(0, exp.length-1, 1, exp));

    }

    private static long recursion(int i, int j, int isTrue, char[] exp){

        if(i > j){return 0;}

        if(i==j){
            if(isTrue == 1){
                return exp[i] == 'T'?1:0;
            }else{
                return exp[i] == 'F'?1:0;
            }
        }
        long ways=0;
        for(int index=i+1;index <= j-1; index+=2 ){
            long lt = recursion(i,index-1, 1, exp);
            long lf = recursion(i,index-1, 0, exp);

            long rt = recursion(index+1, j, 1, exp);
            long rf = recursion(index+1, j, 0, exp);

            if(exp[index] == '&'){
                if(isTrue ==1){
                    ways = (ways+ (rt*lt) % prime ) % prime;
                }else {
                    ways = (ways+ (rt*lf) % prime + (rf*lt) % prime + (rf*lf) % prime ) % prime;
                }
            }else if(exp[index] == '|'){
                if(isTrue ==1){
                    ways = (ways+ (lt*rt) % prime + (lt*rf) % prime + (lf*rt) % prime) % prime;
                }else {
                    ways = (ways+ (rf*lf) % prime ) % prime;
                }
            }else{
                if(isTrue ==1){
                    ways = (ways+ (lt*rf) % prime + (lf*rt) % prime) % prime;
                }else {
                    ways = (ways+ (lt*rt) % prime + (rf*lf) % prime ) % prime;
                }
            }
        }
        return ways;
    }
}
