package com.vamshi.coding.stacksAndQueues;

import java.util.Stack;

public class QueueUsingStacks {


    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();


    public void push(int x){
        input.push(x);

    }

    public int remove(){
        if(output.isEmpty()){
            while (!input.isEmpty()){
                output.push(input.pop());
            }
        }
        // stack throws an exception on pop of an empty stack
        return output.pop();
    }
}
