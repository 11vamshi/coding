package com.vamshi.coding.linkedlists;

import static com.vamshi.coding.linkedlists.L141_DetectLoop.insertNode;

public class Palindrome {

    public static void main(String[] args) {


            ListNode head = null;
            head = insertNode(head, 1);
            head = insertNode(head, 2);

            System.out.println("result is " + isPalindrome(head));
        }



    public static boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;


        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }


        slow = reverse(slow.next);

        printLL(slow);
        printLL(head);
        while (slow != null){
            if(slow.val != head.val){
                return false;

            }
            slow = slow.next;
            head = head.next;

        }

        return true;

    }

    private static void printLL(ListNode node) {
        System.out.println("LL is");
        while (node != null){

            System.out.println(node.val);
            node = node.next;

        }
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head!= null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
