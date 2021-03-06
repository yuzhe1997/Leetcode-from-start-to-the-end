/* 
Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.
 

Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
 

Constraints:

1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid.
 */

class CombinationIterator {

    public CombinationIterator(String characters, int combinationLength) {
        
    }
    
    public String next() {
        
    }
    
    public boolean hasNext() {
        
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */



class CombinationIterator {
    char[] cur, dic;
    boolean hasNext;
    int n;
    public CombinationIterator(String characters, int L) {
        cur = characters.substring(0, L).toCharArray();
        dic = characters.toCharArray();
        n = dic.length;
        hasNext = true;
    }
    
    public String next() {
        // if (! hasNext) return "";
        String res = new String(cur);
        int L = cur.length;
        int i = cur.length - 1, j = dic.length - 1;
        while (i >= 0 && cur[i] == dic[j]) {
            i--;
            j--;
        }
        if (i == -1) {
            hasNext = false;
        } else {
            int index = String.valueOf(dic).indexOf(cur[i]);
            for (int k = i; k < L; k++) {
                cur[k] = dic[++index];
            }
        }
        return res;
    }
    
    public boolean hasNext() {
        return hasNext;
    }
}

// ->

class CombinationIterator {
    char[] cur, dic;
    boolean hasNext;
    int M, L;
    String origin;

    public CombinationIterator(String characters, int L) {
        cur = characters.substring(0, L).toCharArray();
        dic = characters.toCharArray();
        origin = characters;
        this.M = dic.length;
        this.L = L;
        hasNext = true;
    }
    
    public String next() {
        // if (! hasNext) return "";
        String res = new String(cur);
        int i = L - 1, j = M - 1;
        while (i >= 0 && cur[i] == dic[j]) {
            i--;
            j--;
        }
        if (i == -1) {
            hasNext = false;
        } else {
            int k = origin.indexOf(cur[i]);
            while (i < L) cur[i++] = dic[++k];
        }
        return res;
    }
    
    public boolean hasNext() {
        return hasNext;
    }
}