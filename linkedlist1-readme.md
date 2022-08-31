### Always check for base cases in LL problems

L141
If you use while (list1!= null && list1.val <= list2.val){ ,
 instead of while (list1!= null && list1.val < list2.val){, then list1 never makes to next, and we get TLE