package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	// 1. Two Sum
    public int[] twoSum(int[] nums, int target) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i = 0; i < nums.length; i++) {
    		if (map.containsKey(nums[i])) {
    			return new int[]{map.get(nums[i]) + 1, i + 1};
    		}
    		map.put(target - nums[i], i);
    	}
        return null;
    }

	// 2. Add Two Numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if (l1 == null) {
    		return l2;
    	} else if (l2 == null) {
    		return l1;
    	} else {
    		l1.val += l2.val;
    		if (l1.val >= 10) {
    		    l1.val -= 10;
    		    l1.next = addTwoNumbers(l1.next, new ListNode(1));
    		}
    		l1.next = addTwoNumbers(l1.next, l2.next);
    		return l1;
    	}
    }
    
    // 3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
    	boolean[] exist = new boolean[256];
    	int maxLen = 0; 
    	for(int i = 0, j = 0; j < s.length(); ) {
    		// tail is repeating 
    		while (exist[s.charAt(j)]) {
    			// increase head until the repeating letter
    		    exist[s.charAt(i)] = false;
    			i++;
    		}
    		exist[s.charAt(j)] = true;
    		maxLen = Math.max(maxLen, ++j - i);
    	}
    	return maxLen;
    }
    
    // 4. Median of Two Sorted Arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }
    
    // 5. Longest Palindromic Substring
    public String longestPalindrome(String s) {
        return null;
    }
    
	// main
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.lengthOfLongestSubstring("abcabcdeb"));
	}

}

// ListNode
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}