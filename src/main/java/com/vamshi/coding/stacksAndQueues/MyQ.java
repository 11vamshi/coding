package com.vamshi.coding.stacksAndQueues;

public class MyQ {

    int[] arr;

    int size;
    int currSize;

    int front = 0;
    int rear = -1;

    public MyQ(int size) {

        this.size = size;
        this.arr = new int[size];
    }

    public void insert(int i){

        if(currSize == size){
            System.out.println("Queue Full!");
        }

        if(rear == size-1){
            rear = -1;
        }

        rear++;
        currSize++;
        arr[rear] = i;

    }

    public int remove(){
        if(currSize == 0){
            System.out.println("Queue empty!");
            return -1;
        }
        int temp = arr[front++];
        if(front == size){
            front = 0;
        }
        currSize--;
        return temp;
    }
}
