package com.vamshi.coding.Practise;

import com.vamshi.coding.linkedlists.ListNode;

// since in linked lists, no indices involved, we used while(m >= 0 || n >= 0 ){ and not && like in merge arrays
public class L21_Merge_Lists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        ListNode res = new ListNode(0); // value doesn't matter just a place holder
        ListNode head = res;

        while(list1 != null || list2 != null){

            if(list2 == null || ( list1!= null && list1.val < list2.val)){
                res.next = list1;
                list1 = list1.next;

            }else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;

        }


        return head.next;

    }
}
