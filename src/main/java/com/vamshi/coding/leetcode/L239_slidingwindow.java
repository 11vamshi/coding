package com.vamshi.coding.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class L239_slidingwindow {

    public static void main(String[] args) {
        int[] num = new int[]{4, 0, -1, 3, 5, 3, 6, 8};
        int n = num.length;
        int k = 3;

        int[] ans = maxSlidingWindow(n, k, num);
        System.out.println("Maximum element in every " + k + " window ");
        for (int i = 0; i < ans.length; i++)
            System.out.print(ans[i] + "  ");

    }

    public static int[] maxSlidingWindow(int n, int k, int[] num) {
        int[] ans = new int[n - k + 1];
        int ans_index = 0;
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
            while (!q.isEmpty() && num[i] > num[q.peekLast()]) {
                q.pollLast();
            }
            q.offer(i);

            if (i >= k - 1) {
                ans[ans_index++] = num[q.peek()];
            }
        }

        return ans;
    }
}
