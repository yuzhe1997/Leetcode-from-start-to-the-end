/* 
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
 */

class Solution {
    public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int start = layer;
			int end = n - 1 - start;
			for (int i = start; i < end; i++) {
				int offset = i - start;
				int temp = matrix[start][i];
				// left to top;
				matrix[start][i] = matrix[end - offset][start];
				// bottom to left;
				matrix[end - offset][start] = matrix[end][end - offset];
				// right to bottm;
				matrix[end][end - offset] = matrix[i][end];
				// top to right;
				matrix[i][end] = temp;
			}
		}
	}
}

// 旋转,真无聊

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        if (n < 1) return;
        int k = n / 2 + 1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n + 1 - k; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = t;
            }
        }
    }
}