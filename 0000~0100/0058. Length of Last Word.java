/* 
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:

Input: "Hello World"
Output: 5
 */

class Solution {
    public int lengthOfLastWord(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
}

// trim = s.trim()
// last_space = trim.lastIndexOf(" ")

class Solution {
    public int lengthOfLastWord(String s) {
        String[] aux = s.split(" ");
        for (int i = aux.length - 1; i >= 0; i--) {
            if (aux[i].length() > 0) return aux[i].length();
        }
        return 0;
    }
}