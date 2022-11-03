package com.vamshi.coding.challenges;

import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;


// see below for combining intiger and string comparator
public class WebsitePagination_Ford_Msxi {



    public static List<String> fetchItemsToDisplay(List<List<String>> items,
                                                   int sortParameter,
                                                   int sortOrder,
                                                   int itemsPerPage,
                                                   int pageNumber) {

        List<Item> objects =  new ArrayList<>();

        items.stream().forEach(itemlist -> {
            Item item = new Item(itemlist.get(0),itemlist.get(1),itemlist.get(2));
            objects.add(item);
        });

        if(sortParameter == 0 && sortOrder == 0){
            objects.sort(Comparator.comparing(Item::getName));
        }else if(sortParameter == 0 && sortOrder == 1){
            objects.sort(Comparator.comparing(Item::getName).reversed());
        }else if(sortParameter == 1 && sortOrder == 0){
            objects.sort(Comparator.comparing(Item::getRelevance));
        }else if(sortParameter == 1 && sortOrder == 1){
            objects.sort(Comparator.comparing(Item::getRelevance).reversed());
        }else if(sortParameter == 2 && sortOrder == 0){
            objects.sort(Comparator.comparing(Item::getPrice));
        }else if(sortParameter == 2 && sortOrder == 1){
            objects.sort(Comparator.comparing(Item::getPrice).reversed());
        }

        List<Item> objectsInPage = new ArrayList<>();

        // page 0 - 10      if start page number is 1 - 10
        // page 1 - 10      if start page number is 2 - 10
        // page 2 - 10      if start page number is 3 - 10
        int start_index = pageNumber*itemsPerPage;

//        List<String> names = objects.stream().skip(start_index).limit(itemsPerPage)
//                .map(Item::getName)
//                .collect(Collectors.toList());


        for(int i=start_index; i <Math.min(start_index+itemsPerPage,items.size()); i++){
            objectsInPage.add(objects.get(i));
        }



        List<String> names = objectsInPage.stream().map(Item::getName).collect(Collectors.toList());

        return names;


    }

    // why inner class are preferred as static read below
    //    https://stackoverflow.com/questions/70324/java-inner-class-and-static-nested-class
//    An instance of InnerClass can exist only within an instance of OuterClass and has direct access
//    to the methods and fields of its enclosing instance.

    static class NameComparator implements Comparator<Item>{


        @Override
        public int compare(Item o1, Item o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    // String comparison can still work on relevance, since its a intiger in a string
    static class RelevanceComparator implements Comparator<Item>{


        @Override
        public int compare(Item o1, Item o2) {
            return o1.getRelevance().compareTo(o2.getRelevance());
        }
    }
    static class PriceComparator implements Comparator<Item>{


        @Override
        public int compare(Item o1, Item o2) {
            return o1.getPrice().compareTo(o2.getPrice());
        }
    }

    // MultipleFieldsComparator can be done 2 ways, at last we will see java 8 then Comparing
    static class MultipleFieldsComparator implements Comparator<Item>{

        // 1 way
//        @Override
//        public int compare(Item o1, Item o2) {
//
//            if(o1.getName().compareTo(o2.getName()) == 0){
//
//                return o1.getPrice().compareTo(o2.getPrice());
//
//            }else {
//                return o1.getName().compareTo(o2.getName());
//            }
//
//
//        }
        // 2nd way
        @Override
        public int compare(Item o1, Item o2) {

          int NameCompare = o1.getName().compareTo(o2.getName());

          int RelevanceCompare = o1.getRelevance().compareTo(o2.getRelevance());

          int PriceCompare = o1.getPrice().compareTo(o2.getPrice());

          if(NameCompare == 0 ){
              if(PriceCompare == 0){
                  return RelevanceCompare;
              }else{
                  return PriceCompare;
              }
          }else{
              return NameCompare;
          }
        }
    }



    public static void main(String[] args) {

        List<List<String>> items = new ArrayList<>();
        // item, relevance, price
        String[] item1 = {"owjevtkuyv", "58584272", "62930912"};
        String[] item2 = {"rpaqgbjxik", "9425650", "96088250"};
        String[] item3 = {"dfbkasyqcn", "37469674", "46363902"};
        String[] item4 = {"vjrrisdfxe", "18666489", "88046739"};

        items.add(Arrays.asList(item1));
        items.add(Arrays.asList(item2));
        items.add(Arrays.asList(item3));
        items.add(Arrays.asList(item4));

        int sortParameter = 2;
        int sortOrder = 1;
        int itemsPerPage = 2;
        int pageNumber = 0;

        List<String> res = fetchItemsToDisplay(items, sortParameter,sortOrder,itemsPerPage,pageNumber);


//        Comparator<Item> MultipleFieldsComparator = Comparator.comparing(Item::getName)
//                .thenComparing(Item::getPrice)
//                .thenComparing(Item::getRelevance);


        res.stream().forEach(System.out::println);

    }
}

class Item{
    private String name;
    private String relevance;
    private String price;

    public Item(String name, String relevance, String price) {
        this.name = name;
        this.relevance = relevance;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getRelevance() {
        return relevance;
    }

    public String getPrice() {
        return price;
    }
}