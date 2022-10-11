package com.vamshi.coding.dpseries.lcs;


// Striver solution difficult to underdtand , so go with TechDose
public class L300_tabulation {
    public static int lengthOfLIS(int[] nums) {

        int[][] dp = new int[nums.length][nums.length];

        for(int index=nums.length-1; index >= 0; index--){

            for(int next_index=index+1 ; next_index < nums.length+1; next_index++){

                int notTaken = dp[index+1][next_index+1];

                int taken = Integer.MIN_VALUE;

                if(next_index == nums.length-1 || nums[index] < nums[next_index]){
                    taken = dp[index+1][index+1];
                }
                dp[index][next_index] = Math.max(notTaken, taken);

            }
        }

        System.out.println("dp[0][0] " + dp[0][0]);

        printDp(dp);
        return dp[0][0];
    }

    private static void printDp(int[][] dp) {
        for(int i=0; i < dp.length; i++){
            for(int j=0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        lengthOfLIS(nums);
    }
}
