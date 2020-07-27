/* 
Given an array of integers arr. Return the number of sub-arrays with odd sum.

As the answer may grow large, the answer must be computed modulo 10^9 + 7.

 

Example 1:

Input: arr = [1,3,5]
Output: 4
Explanation: All sub-arrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
All sub-arrays sum are [1,4,9,3,8,5].
Odd sums are [1,9,3,5] so the answer is 4.
Example 2:

Input: arr = [2,4,6]
Output: 0
Explanation: All sub-arrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
All sub-arrays sum are [2,6,12,4,10,6].
All sub-arrays have even sum and the answer is 0.
Example 3:

Input: arr = [1,2,3,4,5,6,7]
Output: 16
Example 4:

Input: arr = [100,100,99,99]
Output: 4
Example 5:

Input: arr = [7]
Output: 1
 

Constraints:

1 <= arr.length <= 10^5
1 <= arr[i] <= 100
 */

class Solution {
    private int MOD = 1000000007;
    
    public int numOfSubarrays(int[] arr) {
        int odd = 0, even = 1, sum = 0;
        long res = 0;
        for (int num: arr) {
            sum += num;
            res += (sum % 2 == 0 ? odd : even);
            if (sum % 2 == 0) even++;
            else odd++;
        }
        return (int) (res % MOD);
    }
}



class Solution {
    private int MOD = 1000000007;
    
    public int numOfSubarrays(int[] arr) {
        int sum = 0;
        int[] s = new int[] { 1, 0 };
        long res = 0;
        for (int num: arr) {
            sum += num;
            res += s[1 - sum % 2];
            s[sum % 2]++;
        }
        return (int) (res % MOD);
    }
}



class Solution {
    private int MOD = 1000000007;
    
    public int numOfSubarrays(int[] arr) {
        int sum = 0;
        long[] s = new long[] { 0, 0 };
        for (int num: arr) {
            sum = (sum + num) % 2;
            s[sum]++;
        }
        long res = s[0] * s[1] + s[1];
        return (int) (res % MOD);
    }
}



class Solution {
    public int numOfSubarrays(int[] arr) {
        int sum = 0;
        long[] s = new long[2];
        for (int num: arr) s[(sum += num) % 2]++;
        return (int) ((s[0] * s[1] + s[1]) % 1000000007);
    }
}