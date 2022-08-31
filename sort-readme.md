merge sort
1. mid = (left+right)/2
2.         mergeSort(left, mid, arr);
           mergeSort(mid+1, right, arr);
   
           c. merge(left, mid+1, right, arr);
           
3. int [] temp = new int[right+1]; // make sure temp is right+1; since we are doing temp_index++ blindly later
4.         while(i < j && j <= right){ since j is mid+1 when called from step 2.c

5. for(i = left ; i <= right ; i++)
           arr[i] = temp[i];


