/* 
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        int[] dp = new int[numRows];
        dp[0] = 1;
        for (int i=0; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = i; j > 0; j--) {
                dp[j] += dp[j-1];
                tmp.add(dp[j]);
            }
            tmp.add(dp[0]);
            // Collections.reverse(tmp);
            res.add(tmp);
        }
        return res;
    }
}