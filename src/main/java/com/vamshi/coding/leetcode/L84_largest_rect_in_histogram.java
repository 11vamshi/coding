package com.vamshi.coding.leetcode;

import java.util.Stack;

// formula at each index = (nextsmallest-previoussmallest)+1/2
public class L84_largest_rect_in_histogram {

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3, 1};
        int n = heights.length;

        Stack<Integer> st = new Stack<>();

        int[] nextSmallestIndexMinusOne = new int[n];
        int[] previousSmallestIndexPlusOne = new int[n];

        for(int i=0; i< n; i++){

            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                st.pop();
            }

            if(!st.isEmpty()){

                previousSmallestIndexPlusOne[i] = st.peek() + 1;
            }else{
                previousSmallestIndexPlusOne[i] = 0;
            }
            st.push(i);
        }

        while(!st.isEmpty()) st.pop();

        for(int i=n-1; i>= 0; i--){


            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                nextSmallestIndexMinusOne[i] = st.peek() -1;
            }else{
                nextSmallestIndexMinusOne[i] = n-1;
            }
            st.push(i);
        }
    }

}
