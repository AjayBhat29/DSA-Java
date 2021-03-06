/* Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1
 
Constraints:
1 <= nums.length <= 2500
-10^4 <= nums[i] <= 10^4 */

// O(n^2) Approach
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = 1;

        int ans = 1;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}

//--------------------------------------------------------------------------------------------------------------------------------------------------
//O(nlog(n)) Approach
public static int longestIncreasingSubsequence(List < Integer > arr) {
  // Write your code here
  List < Integer > dp = new ArrayList < > ();
  dp.add(arr.get(0));
  int n = arr.size();
  for (int i = 1; i < n; i++) {
    if (dp.get(dp.size() - 1) < arr.get(i)) {
      dp.add(arr.get(i));
    } else if (dp.get(dp.size() - 1) > arr.get(i)) {
      int index = binarySearch(dp, 0, dp.size() - 1, arr.get(i));
      dp.set(index, arr.get(i));
    }
  }
  return dp.size();
}
static int binarySearch(List < Integer > dp, int lo, int hi, int target) {
  int ans = 0;
  while (lo <= hi) {
    int mid = (lo + hi) / 2;
    if (dp.get(mid) < target)
      lo = mid + 1;
    else {
      ans = mid;
      hi = mid - 1;
    }
  }
  return ans;
}

