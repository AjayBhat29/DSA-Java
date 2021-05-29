/* Given an array nums of integers, you can perform operations on the array.
In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
You start with 0 points. Return the maximum number of points you can earn by applying such operations.

Example 1:
Input: nums = [3,4,2]
Output: 6
Explanation: Delete 4 to earn 4 points, consequently 3 is also deleted.
Then, delete 2 to earn 2 points.
6 total points are earned.

Example 2:
Input: nums = [2,2,3,3,3,4]
Output: 9
Explanation: Delete 3 to earn 3 points, deleting both 2's and the 4.
Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
9 total points are earned.
 

Constraints:
1 <= nums.length <= 2 * 10^4
1 <= nums[i] <= 10^4 */

class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] freq = new int[10001];
        int upper = -1;
        for (int x : nums) {
            freq[x]++;
            upper = Math.max(upper, x);
        }
        int[] dp = new int[upper + 1];
        dp[0] = 0;
        dp[1] = freq[1];

        for (int i = 2; i <= upper; i++) {
            int exl = dp[i - 1];
            int inc = dp[i - 2] + freq[i] * i;
            dp[i] = Math.max(inc, exl);
        }
        return dp[upper];
    }
}
