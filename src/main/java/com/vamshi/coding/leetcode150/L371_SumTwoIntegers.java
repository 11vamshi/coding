package com.vamshi.coding.leetcode150;


// 4 cases when we add 2 binary numbers
// 0 + 0 = 0 , exclusive OR works
// 0 + 1 = 1 , exclusive OR works
// 1 + 0 = 1 , exclusive OR works
// 1 + 1 = 10 , AND with left shirt works, to carry over carry
public class L371_SumTwoIntegers {

    public int getSum(int a, int b) {


        int res = a^b;
        int carry = a&b; // carry
        carry = carry << 1;

        while (carry != 0 ){
            int temp = res;
            res = res ^ carry;
            carry = temp & carry;
            carry = carry << 1;
        }


        return res;
    }

    public static void main(String[] args) {
        L371_SumTwoIntegers l371_sumTwoIntegers = new L371_SumTwoIntegers();
        l371_sumTwoIntegers.getSum(11,9);

    }
}
