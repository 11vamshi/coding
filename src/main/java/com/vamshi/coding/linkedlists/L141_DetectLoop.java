package com.vamshi.coding.linkedlists;



public class L141_DetectLoop {

    public static void main(String[] args) {

        ListNode head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 4);
        createCycle(head,1,3);
        System.out.println("result is " + detectCycle(head));
    }

    private static void createCycle(ListNode head, int i, int j) {
    int counta=0; int countb=0;

    ListNode p1 = head;
    ListNode p2 = head;


    while(counta != i || countb != j){
        if(counta != i){
            p1 = p1.next;
            counta++;
        }
        if(countb != j){
            p2 = p2.next;
            countb++;
        }
    }
        p2.next = p1;
    }

    static boolean detectCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null){

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer){
                return true;
            }
        }
        return false;
    }

    static ListNode insertNode(ListNode head, int i) {
        ListNode newNode = new ListNode(i);

        if(head == null){
            head = newNode;
            return head;
        }
        ListNode temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }


}

