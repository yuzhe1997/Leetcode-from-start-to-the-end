/* 
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.



Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].



The largest rectangle is shown in the shaded area, which has area = 10 unit.


Example:

Input: [2,1,5,6,2,3]
Output: 10
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        int N = heights.length;
        int[] L = new int[N], R = new int[N];
        // int p = L[i] - 1
        // heights[p] < heights[i]
        // heights[p + k] >= heights[i]
        // p 即 i 左侧首个小于 height[i] 的坐标
        for (int i = 0; i < N; i++) {
            int p = i - 1;
            while (p >= 0 && heights[i] <= heights[p]) p = L[p] - 1;
            L[i] = p + 1;
        }
        // System.out.println(Arrays.toString(L));
        for (int i = N - 1; i >= 0; i--) {
            int p = i + 1;
            while (p < N && heights[i] <= heights[p]) p = R[p] + 1;
            R[i] = p - 1;
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, (R[i] - L[i] + 1) * heights[i]);
        }
        return max;
    }
}

// 计算每个包含 heights[i] 的矩形边界
// 例, 左边界, 绝对递增,当前坐标; 反之, 向前查找首个满足 heights[pre] > heights[i] 的 pre
// left[i]: 前置首个小于(不含等于) heights[i] 的坐标 +1; # 定义中的 +1 在取值运算时需 -1
// 另, 栈