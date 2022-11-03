package com.vamshi.coding.challenges;


// find the missing number in array of size 99 holding sorted values 1 to 100,
public class FindMissingNumber_UBS {
    public int findMissing(int[] arr) {

        int res=0;

        // 97, 98, 99
        for(int i=0; i < arr.length-1; i++){

            int curr = arr[i];
            int next = arr[i+1];

            if(next-curr == 2){
                return curr+1;
            }
        }

        if(arr[98] == 100){
            return 99;
        }


    return -1;
    }
    }
