/* 
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */

class Solution {
    int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length; n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                dfs(grid, i, j);
                res++;
            }
        }
        return res;
    }

    private void dfs(char[][] A, int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n || A[x][y] == '0') return;
        A[x][y] = '0';
        for (int[] dir: dirs) dfs(A, x + dir[0], y + dir[1]);
    }
}