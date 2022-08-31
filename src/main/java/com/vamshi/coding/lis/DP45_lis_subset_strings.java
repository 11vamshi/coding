package com.vamshi.coding.lis;

import org.apache.logging.log4j.util.PropertySource;

import java.util.Arrays;
import java.util.Comparator;

public class DP45_lis_subset_strings {

    public static void main(String[] args) {

//        String[] arr = new String[]{"bc", "ad", "adc", "bcd"};
        String[] arr = new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};

        Arrays.sort(arr,new MyComparator());

        int n = arr.length;

        // since every element can act as lis individually
        int[] dp = new int[n];
            Arrays.fill(dp, 1);

        int[] hash = new int[n];


            int maxi = 1;
            int lastIndex = 0;
            for(int i=0; i < n; i++){
                hash[i] = i;
                for(int prev=0; prev < i; prev++){

                    if(compare(arr[prev], arr[i]) && dp[i] < (1 + dp[prev])  ){
                        dp[i] = 1 + dp[prev];
                        hash[i] = prev;
                    }
                }
            if(maxi < dp[i]){
                maxi = dp[i];
                lastIndex = i;
            }

            }

        System.out.println(" result is " + maxi);




    }

    private static class MyComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    private static boolean compare(String prev, String current) {
        if(prev.length() + 1 != current.length() ) return false;
        int current_pointer = 0;
        int prev_pointer = 0;
        // since current string is bigger, we need to loop through it all
        while (current_pointer < current.length() ){
            // this prevents oobounds exception
            if(prev_pointer < prev.length() &&
                    current.charAt(current_pointer) == prev.charAt(prev_pointer)){
                current_pointer++;
                prev_pointer++;
            }else{
                current_pointer++;
            }
        }
        if(current_pointer == current.length() && prev_pointer == prev.length()){
            return true;
        }
        return false;


    }

}
