package com.vamshi.coding.stacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    int top = -1;
    Queue<Integer> q1 = new LinkedList<>();

    void push(int x){
        q1.add(x);
        for(int i=0; i < q1.size();i++){
            q1.add(q1.remove());
        }

    }

    int pop(){
        return q1.remove();
    }



}
