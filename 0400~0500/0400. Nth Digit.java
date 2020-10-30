/* 
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */

class Solution {
    public int findNthDigit(int n) {
        if (n-- <= 9) return n + 1;
        long base = 1;
        int digit = 1;
        while (n > 9 * base * digit) {
            n -= 9 * base * digit;
            base *= 10;
            digit++;
        }
        return helper(base, digit, n);
    }

    private int helper (long B, int D, int N) {
        return String.valueOf(B + N / D).charAt(N % D) - '0';
    }
}