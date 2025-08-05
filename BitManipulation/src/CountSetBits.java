/*
Write an efficient program to count the number of 1s in the binary representation of an integer.
Examples :

Input : n = 6
Output : 2
Binary representation of 6 is 110 and has 2 set bits

Input : n = 13
Output : 3
Binary representation of 13 is 1101 and has 3 set bits
 */

public class CountSetBits {

    // Function to count number of 1s (set bits) in binary representation
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n & (n - 1); // Drops the lowest set bit
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n1 = 6;   // Binary: 110
        int n2 = 13;  // Binary: 1101

        System.out.println("Number of set bits in " + n1 + ": " + countSetBits(n1)); // 2
        System.out.println("Number of set bits in " + n2 + ": " + countSetBits(n2)); // 3
    }
}
