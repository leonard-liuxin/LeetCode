package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	// 1. Two Sum
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				return new int[] { map.get(nums[i]) + 1, i + 1 };
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
		for (int i = 0, j = 0; j < s.length();) {
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
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			String s_1 = expandAroundCenter(s, i, i);
			String s_2 = expandAroundCenter(s, i, i + 1);
			result = s_1.length() > result.length() ? s_1 : result;
			result = s_2.length() > result.length() ? s_2 : result;
		}
		return result;
	}

	private String expandAroundCenter(String s, int l, int r) {
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return s.substring(l + 1, r);
	}

	// 6. ZigZag Conversion
	public String convert(String s, int numRows) {
		return null;
	}
	
	// 8. String to Integer (atoi)
	public int myAtoi(String str) {
		int result = 0, sign = 1;
		str = str.trim();
		if(str.charAt(0) == '-') {
			sign = -1;
			str = str.substring(1);
		} else if (str.charAt(0) == '+') {
			sign = 1;
			str = str.substring(1);
		}
		for (int i = 0; i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'; i++){
			if (result * 10 + str.charAt(i) - '0' > Integer.MAX_VALUE) return Integer.MAX_VALUE;
			else if (result * 10 + str.charAt(i) - '0' < Integer.MIN_VALUE) return Integer.MIN_VALUE;
			result = result * 10 + str.charAt(i) - '0';
		}
		result = result * sign;
		return result;
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