//package com.vamshi.coding.stacksAndQueues;
//
//public class BuildingCounter {
//
//    K = 3
//    X = 2                     7
//    A= [8,9,10,11,9]          8
//    B=[1,2,3,4,3]
//
//    flag = [1, 1, 1, 0, 1 ]
//    minBuildings = [8, 4, 3, 2, 3 ]
//
//
//            (11 + 2) - 12 = 1
//
//
//
//
//    K = 3
//    X = 2
//    A= [8,9,10,19,5]
//    B= [1,1,1,7,3]
//
//        0,0,0,5,2
//
//
//        8,9,10,2,1
//
//        8,9,10,3,1   || 8,9,10,2,2
//
//
//
//
//    /**
//     * N - number of raw materials
//     * X - monthly savings
//     * A - represents amount of Raw material given
//     * B - Raw materials required to construct the building
//     * Bi - represents the amount of ith raw material in Array A
//     * K - number of houses to construct
//     */
//    public static int[] buildCount(int N, int X, int[] A, int[] B, int K) {
//        int initialSavings = X;
//
//        int[] currentMinBuildings = new int[N];
//
//        int[] result = new int[2];
//
//        for(int i=0; i < N;i++){
//            int buildingsWithIthMaterial = A[i]/B[i];
//            A[i] = A[i] - buildingsWithIthMaterial*B[i];
//            currentMinBuildings[i] = buildingsWithIthMaterial;
//        }
//
//        for(int i=0; i<N; i++){
//
//            if(currentMinBuildings[i] >= K){
//                // do nothing
//            }else{
//                int minMaterialNeeded = K*B[i];
//                if(A[i] + X  >= minMaterialNeeded){
//                    // using savings
//                    X = (A[i] + X) - minMaterialNeeded;
//
//                    currentMinBuildings[i] = (A[i] + X) / B[i];
//                }else{
//                    // savings not enough
//                }
//            }
//        }
//
//        int minBuilings= 0;
//        for(int i=0; i<N; i++){
//            minBuilings= Math.min(minBuilings, currentMinBuildings[i]);
//        }
//        result[1] = minBuilings;
//        result[0] = initialSavings-X;
//
//        return result;
//    }
//}
