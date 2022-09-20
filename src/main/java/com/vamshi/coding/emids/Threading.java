package com.vamshi.coding.emids;

public class Threading {

    public static void main(String[] args) {

    Thread h = new Thread(() -> {System.out.println("hi");});

    h.start();

    while (h.isAlive()){

        try{

//            h.sleep(10);

        }
        catch (Exception e ){
            System.out.println("hello");
        }
        System.out.println("hackerearth");
    }

    }


}
