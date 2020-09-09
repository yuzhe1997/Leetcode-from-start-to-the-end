/* 
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

 

Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"
 */

class Solution {
    public String toLowerCase(String str) {
        return new String(trans(str.toCharArray()));
    }
    
    private char[] trans(char[] str) {
        for (int i = 0; i < str.length; i++) if ('A' <= str[i] && str[i] <= 'Z') str[i] += 32;
        return str;
    }
}