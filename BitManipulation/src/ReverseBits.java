/*
Given a non-negative integer n, the task is to reverse the bits in its binary representation and return the resulting decimal number. The reversal should consider only the actual binary digits without any leading zeros.

Examples :

    Input : 11
    Output : 13
    Explanation: (11)10 = (1011)2.
    After reversing the bits we get: (1101)2 = (13)10.

    Input : 10
    Output : 5
    Explanation : (10)10 = (1010)2.
    After reversing the bits we get: (0101)2 = (101)2 = (5)10.
*/

public class ReverseBits {
    public static int reverseBits(int n) {
        int reversed = 0; // will store the final reversed number

        while (n > 0) {
            int bit = n & 1; // get the last bit of n
            reversed = (reversed << 1) | bit; // append bit to reversed
            n >>= 1; // shift n right to process next bit
        }

        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(11)); // Expected 13
        System.out.println(reverseBits(10)); // Expected 5
    }
}