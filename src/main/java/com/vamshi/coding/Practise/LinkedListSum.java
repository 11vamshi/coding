package com.vamshi.coding.Practise;

import com.vamshi.coding.linkedlists.ListNode;

public class LinkedListSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);

        ListNode head = res;

        int carry = 0;

        while(l1 != null && l2 != null){

            int sum = l1.val + l2.val;
            int num = (sum + carry)%10;
            carry = (sum + carry)/10;

            ListNode newNode = new ListNode(num);

            res.next = newNode;
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;

        }

        while (l1 != null){
            int sum = l1.val;
            int num = (sum + carry)%10;
            carry = (sum + carry)/10;

            ListNode newNode = new ListNode(num);

            res.next = newNode;
            res = res.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int sum = l2.val;
            int num = (sum + carry)%10;
            carry = (sum + carry)/10;

            ListNode newNode = new ListNode(num);

            res.next = newNode;
            res = res.next;
            l2 = l2.next;
        }

        if(carry != 0){
            ListNode newNode = new ListNode(carry);
            res.next = newNode;
        }

        return head.next;
    }
}
