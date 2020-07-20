/* 
Given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges. The root of the tree is the node 0, and each node of the tree has a label which is a lower-case character given in the string labels (i.e. The node with the number i has the label labels[i]).

The edges array is given on the form edges[i] = [ai, bi], which means there is an edge between nodes ai and bi in the tree.

Return an array of size n where ans[i] is the number of nodes in the subtree of the ith node which have the same label as node i.

A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.

 

Example 1:


Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd"
Output: [2,1,1,1,1,1,1]
Explanation: Node 0 has label 'a' and its sub-tree has node 2 with label 'a' as well, thus the answer is 2. Notice that any node is part of its sub-tree.
Node 1 has a label 'b'. The sub-tree of node 1 contains nodes 1,4 and 5, as nodes 4 and 5 have different labels than node 1, the answer is just 1 (the node itself).
Example 2:


Input: n = 4, edges = [[0,1],[1,2],[0,3]], labels = "bbbb"
Output: [4,2,1,1]
Explanation: The sub-tree of node 2 contains only node 2, so the answer is 1.
The sub-tree of node 3 contains only node 3, so the answer is 1.
The sub-tree of node 1 contains nodes 1 and 2, both have label 'b', thus the answer is 2.
The sub-tree of node 0 contains nodes 0, 1, 2 and 3, all with label 'b', thus the answer is 4.
Example 3:


Input: n = 5, edges = [[0,1],[0,2],[1,3],[0,4]], labels = "aabab"
Output: [3,2,1,1,1]
Example 4:

Input: n = 6, edges = [[0,1],[0,2],[1,3],[3,4],[4,5]], labels = "cbabaa"
Output: [1,2,1,1,2,1]
Example 5:

Input: n = 7, edges = [[0,1],[1,2],[2,3],[3,4],[4,5],[5,6]], labels = "aaabaaa"
Output: [6,5,4,1,3,2,1]
 

Constraints:

1 <= n <= 10^5
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
labels.length == n
labels is consisting of only of lower-case English letters.
 */

class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] depth = new int[n];
        depth[0] = 1;
        for (int[] line: edges) {
            if (depth[line[0]] == 0) {
                depth[line[0]] = depth[line[1]] + 1;
            } else {
                depth[line[1]] = depth[line[0]] + 1;
            }
        }
        
        char[] s = labels.toCharArray();
        StringBuilder[] sb = new StringBuilder[n+1];
        for (int i = edges.length - 1; i >= 0; i--) {
            int x = edges[i][0], y = edges[i][1];
            if (sb[x] == null) {
                sb[x] = new StringBuilder();
                sb[x].append(s[x]);
            }
            if (sb[y] == null) {
                sb[y] = new StringBuilder();
                sb[y].append(s[y]);
            }
            merge(sb, x, y, depth);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count(sb[i], s[i]);
        }
        return res;
    }
    
    private void merge(StringBuilder[] sb, int x, int y, int[] depth) {
        if (depth[x] < depth[y]) {
            sb[x].append(sb[y]);
        } else {
            sb[y].append(sb[x]);
        }
    }
    
    private int count(StringBuilder sb, char c) {
        int ans = 0;
        for (char a : sb.toString().toCharArray()) {
            if (a == c) {
                ans++;
            }
        }
        return ans;
    }
}



class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        int[] sum = new int[n];
        countSubTrees(0, new boolean[n], sum, graph, labels.toCharArray());
        return sum;
    }
    
    private int[] countSubTrees(int index, boolean[] visited, int[] sum, ArrayList<Integer>[] graph, char[] labels) {
        int[] count = new int[26];
        if (visited[index]) {
            return count;
        }
        visited[index] = true;
        int local = labels[index] - 'a';
        for (int i: graph[index]) {
            int[] nextCount = countSubTrees(i, visited, sum, graph, labels);
            for (int j = 0; j < 26; j++) {
                count[j] += nextCount[j];
            }
            sum[index] += nextCount[local];
        }
        sum[index]++;
        count[local]++;
        return count;
    }
}