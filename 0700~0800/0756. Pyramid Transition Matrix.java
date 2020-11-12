/* 
We are stacking blocks to form a pyramid. Each block has a color which is a one letter string.

We are allowed to place any color block C on top of two adjacent blocks of colors A and B, if and only if ABC is an allowed triple.

We start with a bottom row of bottom, represented as a single string. We also start with a list of allowed triples allowed. Each allowed triple is represented as a string of length 3.

Return true if we can build the pyramid all the way to the top, otherwise false.

Example 1:

Input: bottom = "BCD", allowed = ["BCG", "CDE", "GEA", "FFF"]
Output: true
Explanation:
We can stack the pyramid like this:
    A
   / \
  G   E
 / \ / \
B   C   D

We are allowed to place G on top of B and C because BCG is an allowed triple.  Similarly, we can place E on top of C and D, then A on top of G and E.
 

Example 2:

Input: bottom = "AABA", allowed = ["AAA", "AAB", "ABA", "ABB", "BAC"]
Output: false
Explanation:
We can't stack the pyramid to the top.
Note that there could be allowed triples (A, B, C) and (A, B, D) with C != D.
 

Constraints:

bottom will be a string with length in range [2, 8].
allowed will have length in range [0, 200].
Letters in all strings will be chosen from the set {'A', 'B', 'C', 'D', 'E', 'F', 'G'}.
 */

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<Integer, List<Character>> map = new HashMap<>();
        for (String brick: allowed) {
            char[] chs = brick.toCharArray();
            map.computeIfAbsent(getKey(chs, 0), z -> new ArrayList<>()).add(chs[2]);
        }
        return dfs(bottom.toCharArray(), 0, map, new char[bottom.length() - 1]);
    }

    private boolean dfs(char[] line, int idx, Map<Integer, List<Character>> map, char[] target) {
        if (idx == target.length) {
            if (idx == 1) return true;
            return dfs(target, 0, map, new char[idx - 1]);
        }
        int key = getKey(line, idx);
        if (! map.containsKey(key)) return false;
        for (char next: map.get(key)) {
            target[idx] = next;
            if (dfs(line, idx + 1, map, target)) return true;
        }
        return false;
    }

    private int getKey(char[] chs, int idx) {
        return (chs[idx] - 'A' << 3) + chs[idx + 1] - 'A';
    }
}