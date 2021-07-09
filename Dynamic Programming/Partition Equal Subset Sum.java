/* Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 
Constraints:
1 <= nums.length <= 200
1 <= nums[i] <= 100 */

class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int x:nums)
            sum+=x;
        if(sum%2!=0)
            return false;
        else
            return subSetSum(nums,sum/2,nums.length);
    }
    boolean subSetSum(int arr[],int sum,int n)
    {
        boolean dp[][]=new boolean[n+1][sum+1];//create dp array
        
        for(int i=0;i<sum+1;i++)//first row elemetns set to false
            dp[0][i]=false;
        for(int i=0;i<n+1;i++)//first column elements set to true
            dp[i][0]=true;
        
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(arr[i-1]<=j)
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        
        return dp[n][sum];
    }
}
