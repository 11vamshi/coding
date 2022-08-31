its all in the base conditions, revise base conditions before going to exam

DP22 base conditions and taken index changes are tricky in infinite supply questions 

for DP 14 t0 DP 19, first decide if you need boolean or int array

only 17 and 18 need int array, since you need count 




DP 19 recursion int result = recursion(num,n-1,x, dp); , since you start from top down in recursion


DP 19 tabulation int result = tabulation(num,n,x, dp); since it is bottom up and return dp[n-1][x];

DP25  things to remember, dp size should match the recursion call recursion(s,t,n-1,m-1,dp);
for tabulation we use a bigger dp for this sort of questions on strings, first column and row all 0's


DP32 recursion - 
1. order of if statements, 
2. dp size same as n*m 
3. do modulo prime on result

DP32 tabulation - 
1. first column all 1's,
2. first row all 0's but [0][0], elemnt is 1 , or it doesnt matter if you fill dp with 0's initially
2. for loop starts at 1 and s.charAt(i-1)
3. dp size n+1*m+1 same as for all string dp questions
4. do modulo prime on result

DP33 recursion -
1. this code converts 1st to 2nd string
2. dp size same as n*m
3. do Math.min not Math.max, my earlier mistake

DP33 tabulation -
1. this code converts 1st to 2nd string
2. for loop starts at 1 and s.charAt(i-1)
3. dp size n+1*m+1 same as for all string dp questions

DP34 recursion-
2. dp size same as n*m, boolean problems use int dp array for default -1, but return boolean from
recursion function 
3.  taken = recursion(s, t, n-1, m, dp);  // star used as empty character
   notTaken = recursion(s, t, n , m-1, dp); // * can be reused

DP34 tabulation-   

1. }else{ dp[i][j] = false;   dont forget default


DP36 recursion
1. this recursion starts at index 0, base case at n
2. start with buy = 1, since you cant sell without buying
3. giving error upon submission althogh tabulation is working fine

DP36 tabulation
1. this tabulation starts at index n-1 , since base case at n 
2. return dp[0][1], since you have to buy first
3. no need of base conditions for tabulation stock questions if dp is filled with 0's, DP27
  
DP37 recursion
1.same as 26 but you need another variable cap, since cap is 2 transactions, and each sell makes a 
transaction complete so, cap-1
2. giving error on submission, even for striver, but solution is correct

DP37 tabulation   
1. no need of base conditions for tabulation stock questions if dp is filled with 0's, DP27
2. third loop for cap starts at cap = 1, since cap 0 is base condition


DP39 recursion 
1. same as DP 35, except 2 changes, base condition, if(index >= n), since, in sell we may go out of bounds 
2. second change, in sell, we cant buy next day

DP39 tabulation
1, we need a dp of size n+2, since in sell we check last 2 days

DP41 
1. since we start with previous index -1, we need a dp of size of n*n+1
2. we shift index by 1 and store stuff in dp[index][previous_index+1]


DP42 alternate solution
1. needed if ypu want to trace back lis, i.e., printing lis, apply backtracking
2. use hash initialized with i, its index

DP 44
1.    same as DP42, 
2. except sort the array and 
3. instead of less than check arr[i] % arr[prev] == 0



DP 51 recursion 
1. add 1 before and after the array
2. intution is when the last ballon is burst, which at ind, it becomes a subproblem problem
3. but if you consider bursting from the beginning, then it cant be a subproblem problem, 
since ind-1, depends on ind+1 

DP 51 tabulation
1. conversion steps - write base cases
2. add nested loops for changing variables
3. copy the recurrence in recursion
4. since tabulation is bottom up, recursion(1,n,a2, dp) becomes outer loop starts from n and 
inner loop starts from 1


DP 52 -
1. you need a dp of length dp[n][n][2] not dp[n+1][n+1][2]


Dp 53 - 
front partition is simple
since we dont need partition count, we need to reduce 1, since we return 1 at the end

Dp 54 - 
front partition is simple

