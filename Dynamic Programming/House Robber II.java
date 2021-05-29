/* You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.

Example 2:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 3:
Input: nums = [0]
Output: 0
 
Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 1000 */

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int[] inc = new int[n - 1];
        int[] exl = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            inc[i] = nums[i];
            exl[i] = nums[i + 1];
        }
        return Math.max(helpRob(inc), helpRob(exl));
    }

    int helpRob(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];

        if (n == 1)
            return Math.max(0, nums[0]);
        if (n == 2)
            return Math.max(0, Math.max(nums[0], nums[1]));

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int include = dp[i - 2] + nums[i];
            int exclude = dp[i - 1];
            dp[i] = Math.max(include, exclude);
        }
        return dp[n - 1];
    }
}
