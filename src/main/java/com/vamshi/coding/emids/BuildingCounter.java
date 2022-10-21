package com.vamshi.coding.emids;

public class BuildingCounter {
    static int[] building_count(int N, int X, int[] A, int[] B, int K){
        int saving = X;
        int buildingCounter = 0;
        int foundMaterialsCounter = 0;

        for(int k=0; k < K; k++){

            for(int i=0; i < N;i++){

                if(A[i] >= B[i]){
                    A[i] = A[i] - B[i];
                    ++foundMaterialsCounter;
                } else if (A[i] + saving >= B[i]) {
                    int materialsToBuy = B[i] - A[i];
                    saving = saving - materialsToBuy;
                    ++foundMaterialsCounter;
                }else {
                    break;
                }


                if(foundMaterialsCounter % N == 0){
                    ++buildingCounter;
                    foundMaterialsCounter = 0;
                }

            }
        }
        int usedSavings = X - saving;
        int[] result = {usedSavings,  buildingCounter};
        return result;
    }

}
