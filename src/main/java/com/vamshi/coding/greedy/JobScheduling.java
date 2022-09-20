package com.vamshi.coding.greedy;

import java.util.Arrays;

public class JobScheduling {

    int[] JobScheduling(Job jobs[], int n) {

        Arrays.sort(jobs, (job1, job2)-> (job2.profit-job1.profit));

        int maxDeadline = 0;

        for(int i=0; i <jobs.length;i++){
            if(jobs[i].deadline > maxDeadline){
                maxDeadline = jobs[i].deadline;
            }
        }
        int[] result = new int[maxDeadline+1]; // since arrays are 0 based indexed and deadlines are 1 based
        Arrays.fill(result, -1);

        int jobsCount =0;
        int maxProfit=0;
        for(int i=0; i < jobs.length;i++){

            for(int j=jobs[i].deadline; j >0;j--){

                if(result[j] == -1){
                    result[j] = i; // you forgot
                    jobsCount++;
                    maxProfit = maxProfit+jobs[i].profit;
                    break; // you forgot
                }
            }

        }

        int[] ans = new int[2];
        ans[0] = jobsCount;
        ans[1] = maxProfit;
        return  ans;


    }
}
