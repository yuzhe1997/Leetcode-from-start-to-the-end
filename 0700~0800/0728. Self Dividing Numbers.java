/* 
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
Note:

The boundaries of each input argument are 1 <= left <= right <= 10000.
 */

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        
    }
}



class Solution {
    List<Integer> ans = new ArrayList();
    public List<Integer> selfDividingNumbers(int left, int right) {
        for (int n = left; n <= right; ++n) {
            selfDividing(n);
        }
        return ans;
    }
   
    public void selfDividing(int n) {
        int x = n;
        while (x > 0) {
            int d = x % 10;
            x /= 10;
            if (d == 0 || (n % d) > 0) return;
        }
        ans.add(n);
    }
}