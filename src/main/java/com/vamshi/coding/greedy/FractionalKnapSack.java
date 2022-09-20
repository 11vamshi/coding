package com.vamshi.coding.greedy;

import java.util.Arrays;
// working code commented out, you made mistakes in intizer division
public class FractionalKnapSack {

    public static double maximumValue(Pair[] items, int n, int w) {

        Arrays.sort(items, (a,b)-> {
            double r1 = a.value/a.weight;
            double r2 = b.value/b.weight;

            if(r1 < r2){
                return 1;
            }else if(r1 > r2){
                return -1;
            }else{
                return 0;
            }
        });

        int res=0;
        for(int i=0; i < items.length; i++){

            if(w >= items[i].weight){
                w = w-items[i].weight;
                res = res+items[i].value;
            }else{
               int valueAfterBreakingItem = w * (items[i].value/items[i].weight);
               res = res + valueAfterBreakingItem;
               w=0;
               break;
            }

        }

        return res;
    }


    class Pair
    {
        int weight;
        int value;
        Pair(int weight, int value)
        {
            this.weight = weight;
            this.value = value;
        }

    }

//    //Function to get the maximum total value in the knapsack.
//    double fractionalKnapsack(int w, Item items[], int n)
//    {
//
//        Arrays.sort(items, (a,b)-> {
//            double r1 = (double)a.value/(double)a.weight;
//            double r2 = (double)b.value/(double)b.weight;
//
//            if(r1 < r2){
//                return 1;
//            }else if(r1 > r2){
//                return -1;
//            }else{
//                return 0;
//            }
//        });
//
//        double res=0;
//        for(int i=0; i < items.length; i++){
//
//            if(w >= items[i].weight){
//                w = w-items[i].weight;
//                res = res+items[i].value;
//            }else{
//                double valueAfterBreakingItem = w * ((double)items[i].value/(double)items[i].weight);
//                res = res + valueAfterBreakingItem;
//                w=0;
//                break;
//            }
//
//        }
//
//        return res;
//    }
}
