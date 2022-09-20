package com.vamshi.coding.leetcode;

import java.util.Stack;

public class nse {

    public static int[] prevSmaller(int[] A) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[A.length];
        for(int i=0; i <A.length;i++){
            int curr = A[i];
            while(!st.isEmpty() && st.peek() >= curr){
                st.pop();
            }

            if(!st.isEmpty()){
                res[i] = st.peek();
            }else{
                res[i] = -1;
            }

            st.push(curr);
        }
        return res;
    }

    public static void main(String[] args) {

        prevSmaller(new int[]{4, 5, 2, 10, 8});
    }

}
