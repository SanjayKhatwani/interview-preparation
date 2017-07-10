public static int addTwoIntegers(int a, int b){
    while (b != 0){
        int carry = (a & b); // Carry is AND of two bits
        a = a ^ b // sum of tw obits is A XOR B
        b = carry << 1 //shifts carry to 1 bit to calculate sum 
    }
}


/*
bit manipulation的解释

1. a & b能够得到现在的carry
   因为只有在同一位都是1的时候才会产生carry, 所以a & b能够得到每一位是否会产生carry.
   下面的 << 1 就是将carry左移一位放到下一次的计算中去
2. a ^ b 能够得到除了carry的sum


0 + 1 = 1
1 + 1 = 0 + carry
1 + 0 = 1
0 + 0 = 0
由上面的公式可以看出XOR可以得到当前位的sum的结果
*/