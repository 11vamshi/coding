package com.vamshi.coding.challenges;

import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


//return o1.getName().compareTo(o2.getName()); to compare strings
//return o1.getName().compareTo(o2.getName()); to compare Characters
//return o1.getNumber()-o2.getNumber(); to compare integers

public class AllComparators {

    public static void main(String[] args) {
        char[] chars = {'a','z','x','c'};
        String s = "azxc";


        // this works only for ascending order
        Arrays.sort(chars);
//https://stackoverflow.com/questions/5584579/how-to-sort-an-array-in-reverse-order-using-java
        // for descending order do below
        Character[] charObjectArray =
        s.chars().mapToObj(c -> (char)c).toArray(Character[]::new);

        Arrays.stream(charObjectArray).sorted(new CharacterComparator().reversed());





    }

}


class CharacterComparator implements Comparator<Character>{

    @Override
    public int compare(Character o1, Character o2) {
        return o1.compareTo(o2);
    }
}

class IntegerComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}