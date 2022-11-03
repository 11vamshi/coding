package com.vamshi.coding.javaInterview;


//https://www.youtube.com/watch?v=vKVzRbsMnTQ

import java.util.Optional;

// Main purpose is to explicitly tell the user of a method, that the value they are looking for
// might not exist, they have to account for that possibility

// optionals are only intended as a return type, not else where in code, dont over do them
// it is just an elegant way of null check and specifying the intent
public class OptionalDemo {


    public static void main(String[] args) {
        Cat myCat = oldWayToFindCatByName("fred");

        // we have to always check nullpointer in real life like this a lot of places
        if(myCat != null){
            System.out.println(myCat.getAge());
        }else {
            System.out.println("age not present");
        }

        // people do below code now a days
        // will give NoSuchElementException which is as bad as Null Pointer

        // This looks a little sus, since it looks exactly like previous code
        // however the intent is to tell the user that it can return empty
      Optional<Cat> optionalCat = newWayToFindCatByName("fred");
        if(optionalCat.isPresent()) {
            System.out.println(optionalCat.get());
        }else{
            System.out.println("age not present");
        }


        // other convenience methods are provided which work when optional is empty
        Cat otherCat = optionalCat.orElse(new Cat("UNKNOWN", 0));
    //  we can pass a default supplier lambda
        Cat otherCat2 = optionalCat.orElseGet(()->{return new Cat("UNKNOWN",0);});

        // finally to get age

        optionalCat.map(Cat::getAge).orElse(0);

    }

    private static Cat oldWayToFindCatByName(String name){
        Cat cat = new Cat(name, 3);
        return cat;
    }

    private static Optional<Cat> newWayToFindCatByName(String name){
        Cat cat = new Cat(name, 3);
        return Optional.ofNullable(cat);
    }



}


class Cat{
    String name;
    int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}