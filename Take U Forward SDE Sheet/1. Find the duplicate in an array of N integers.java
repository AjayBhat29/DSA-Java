/* 1. Find the duplicate in an array of N integers. */

/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.



Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [1,1]
Output: 1
Example 4:

Input: nums = [1,1,2]
Output: 1


Constraints:

2 <= n <= 3 * 104
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.


Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem without modifying the array nums?
Can you solve the problem using only constant, O(1) extra space?
Can you solve the problem with runtime complexity less than O(n2)? */

//Sorting Method
class Solution {
	public int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		int dup = 0;
		for (int i = 0; i < nums.length - 1; i++)
			if (nums[i] == nums[i + 1]) {
				dup = nums[i];
				break;
			}
		return dup;
	}
}

//Frequency Table Method
class Solution {
	public int findDuplicate(int[] nums) {
		int freq[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (freq[nums[i]] == 1)
				return nums[i];
			else
				freq[nums[i]]++;
		}
		return -1;
	}
}

//Slow and Faster pointer, cycle detection method
class Solution {
	public int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);
		fast = nums[0];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}