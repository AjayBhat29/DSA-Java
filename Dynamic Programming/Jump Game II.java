/* Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
You can assume that you can always reach the last index.

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:
1 <= nums.length <= 10^4
0 <= nums[i] <= 1000 */

class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return topDown(nums, 0, dp);
    }

    int topDown(int[] nums, int i, int[] dp) {
        if (i == nums.length - 1)
            return 0;
        if (i >= nums.length)
            return 1000001;
        if (dp[i] != -1)
            return dp[i];
        int steps = 10000001;
        for (int jump = 1; jump <= nums[i]; jump++) {
            int next_cell = i + jump;
            steps = Math.min(steps, topDown(nums, next_cell, dp));
        }
        dp[i] = steps + 1;
        return dp[i];
    }
}
