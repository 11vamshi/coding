package com.vamshi.coding.leetcode;

import java.util.*;


public class L146_LRU_Cache {


    int capacity;
    Map<Integer, Node> map = new HashMap<>();

    Node head = new Node(0,0);
    Node tail = new Node(0,0);


    public L146_LRU_Cache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(map.get(key));
            insertAtHead(map.get(n));
            return n.val;
        }
        else return -1;
    }

    // if you put a key which is already present, then it becomes Most recently used, so delete and reenter
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(capacity == map.size()){
            remove(tail.prev);
        }
        insertAtHead(new Node(key, value));
    }

    public void insertAtHead(Node n){
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
        n.prev = head;
        map.put(n.key,n);
    }

    // make sure to remove from map as well
    public void remove(Node n){
        map.remove(n.key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    class Node{
        int key,val;
        Node next, prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }

    }

}
