package com.vamshi.coding.dpseries.stocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DP35_buy_sell_stock {

    public static void main(String[] args) {

        List<Integer> prices = List.of(1, 2, 3);

        int mini = prices.get(0);
        int profit = 0;
        int currentProfit =0;
        for(Integer price: prices){
            currentProfit = price-mini;
            mini = Math.min(mini,  price);
            profit = Math.max(profit, currentProfit);
        }

        System.out.println(" result is " + profit);
    }

}
