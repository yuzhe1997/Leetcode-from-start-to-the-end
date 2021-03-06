/* 
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1

Example 2:

Input: [2,2,2,0,1]
Output: 0
Note:

This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?
 */

class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) return -1;
        else if (len == 1) return nums[0];
        if (nums[0] < nums[len-1]) return nums[0];
        for (int i=1; i < len; i++) {
            if (nums[i] < nums[i-1]) return nums[i];
        }
        return nums[0];
    }
}


class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;

        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high])
                high = pivot;
            else if (nums[pivot] > nums[high])
                low = pivot + 1;
            else
                high -= 1;
        }
        return nums[low];
    }
}



class Solution {
    public int findMin(int[] nums) {
        return biSearch(nums, 0, nums.length-1);
    }

    private int biSearch(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = (l + r) / 2;
        if (nums[mid] < nums[r]) {
            return biSearch(nums, l, mid);
        } else if (nums[mid] > nums[r]) {
            return biSearch(nums, mid + 1, r);
        } else {
            return biSearch(nums, l, r - 1);
        }
    }
}