package com.vamshi.coding.llAndArrays;

import com.vamshi.coding.linkedlists.ListNode;

public class RotateLL {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode temp = head;
        int len = 1;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }

        temp.next = head;

        k = k % len;
        k = len - k;

        while (k > 0) {
            k--;
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;

        return head;
    }

}
