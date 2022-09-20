package com.vamshi.coding.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L496_nge1 {

    public static void main(String[] args) {

        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};

        int[] res = nextGreaterElement(nums1, nums2);


        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int res[] = new int[nums1.length];

        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();


        for (int i = nums2.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                map.put(nums2[i],st.peek());
            }
            else map.put(nums2[i],-1);

            st.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;


    }

}
