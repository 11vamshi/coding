Sort012
1. replace for(int i=0; i < a.length;i++){ with while(mid<=high), since once we reach mid, if we still 
keep swaping, we will swap 2's at end with 1's in middle

2. no need of mid++; in case arr[mid] == 2, since if we swap a 0 from end to 2 in middle, we still need to 
swap that 0 with 1 in middle. 
 
