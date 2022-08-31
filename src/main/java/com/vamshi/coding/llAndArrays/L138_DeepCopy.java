package com.vamshi.coding.llAndArrays;

public class L138_DeepCopy {

    public Node copyRandomList(Node head) {

        Node temp = head;
        while(temp != null){
            Node deepCopy = new Node(temp.val);
            Node next = temp.next;
            temp.next = deepCopy;
            deepCopy.next = next;

        }

        temp = head;

        while(temp != null){
            temp.next.random = temp.random.next;
            temp = temp.next.next;
        }







        temp = head;
        Node res = null;

        if(head != null){
            res = head.next;
        }

        Node prev = temp;

        while (temp != null){
            Node next = temp.next.next;
            temp.next.next = next.next;

            prev = temp;
            temp = temp.next.next;
            prev.next = null;
        }

        return res;

    }

}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

