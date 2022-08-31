package com.vamshi.coding.linkedlists;

public class LoopStartPoint {

    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null){
            return null;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head;
        ListNode entry = head;

        while (fastPointer != null && fastPointer.next != null){

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if(slowPointer == fastPointer){
                while(entry != slowPointer){
                    slowPointer = slowPointer.next;
                    entry = entry.next;
                }
            return entry;
            }
        }
        return null;
    }



}
