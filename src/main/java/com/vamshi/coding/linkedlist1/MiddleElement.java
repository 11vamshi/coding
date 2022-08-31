package com.vamshi.coding.linkedlist1;

public class MiddleElement {
    public ListNode middleNode(ListNode head) {

            ListNode slowPointer = head;
            ListNode fastPointer = head;

            while (fastPointer != null && fastPointer.next != null){

                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;

            }
            return slowPointer;
        }

    }
