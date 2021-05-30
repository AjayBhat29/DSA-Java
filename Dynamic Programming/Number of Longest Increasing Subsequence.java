/* Given an integer array nums, return the number of longest increasing subsequences.
Notice that the sequence has to be strictly increasing.

Example 1:
Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].

Example 2:
Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.

Constraints:
1 <= nums.length <= 2000
-10^6 <= nums[i] <= 10^6 */

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] len = new int[n];
        int[] cnt = new int[n];
        len[0] = 1;
        cnt[0] = 1;

        int lis = 1;

        for (int i = 1; i < n; i++) {
            len[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (len[i] == len[j] + 1)
                        cnt[i] += cnt[j];
                }
            }
            lis = Math.max(lis, len[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++)
            if (lis == len[i])
                ans += cnt[i];
        return ans;
    }
}
