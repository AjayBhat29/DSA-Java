/* Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. 
If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 
Constraints:
1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        int i=0,j=0;
        int sum=0;
        
        while(j<n)
        {
            sum=sum+nums[j];
            if(sum<target)
                j++;
            else if(sum==target)
            {
                min=Math.min(min,j-i+1);
                j++;
            }
            else
            {
                min=Math.min(min,j-i+1);
                while(sum>=target)
                {
                    min=Math.min(min,j-i+1);
                    sum=sum-nums[i];
                    i++;
                }
                j++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
