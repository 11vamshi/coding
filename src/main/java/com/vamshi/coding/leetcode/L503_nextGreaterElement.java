package com.vamshi.coding.leetcode;

import java.util.Stack;

// stack might not be empty at the end of the function
public class L503_nextGreaterElement {

    public static void main(String[] args) {

        int[] nums = new int[]{5, 7, 1, 2, 6, 0};
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = (2*n) - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }

            if (i < n) {
                if (!st.isEmpty()) {
                    nge[i] = st.peek();
                }
                else nge[i] = -1;
            }

            st.push(nums[i % n]);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(nge[i] + " ");
        }
    }

}
