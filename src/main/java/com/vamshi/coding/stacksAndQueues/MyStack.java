package com.vamshi.coding.stacksAndQueues;

public class MyStack {


    int[] arr;

    int size;

    int top = -1;

    public MyStack(int size) {
        this.size = size;
        this.arr = new int[size];
    }

    public void push(int i){
        if(top == size-1){
            System.out.println("stack full!");
        }
        this.arr[++top] = i;
    }

    public int pop(){

        if(top == -1){
            System.out.println("stack empty!");
            return -1;
        }
        return arr[top--];

    }

}
