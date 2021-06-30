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
        int ans=0,farthest=0;
        int left=0,right=0;
        while(right<nums.length-1){
            for(int i=left;i<=right;i++)
                farthest=Math.max(farthest,i+nums[i]);
            left=right+1;
            right=farthest;
            ans++;
        }
        return ans;
    }
}

//----------------------------------------------------------------------

class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int []dp=new int[n];
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            int min_jump=100001;
            for(int j=1;j<=nums[i];j++){
                int next_cell=i+j;
                if(next_cell>=n)break;
                min_jump=Math.min(min_jump,dp[next_cell]);
            }
            dp[i]=min_jump+1;
        }
        return dp[0];
    }
}

//--------------------------------------------------------------------------

class Solution {
    public int jump(int[] nums) {
        int []dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return topDown(nums,0,dp);
    }
    int topDown(int []nums,int index,int []dp){
        if(index==nums.length-1)
            return 0;
        if(index>=nums.length)
            return 1000001;
        if(dp[index]!=-1)
            return dp[index];
        
        int steps=1000001;
        int max_limit=nums[index];
        for(int jump=1;jump<=max_limit;jump++){
            int next_cell=jump+index;
            steps=Math.min(steps,topDown(nums,next_cell,dp));
        }
        dp[index]=steps+1;
        return dp[index];
    }
}

//-------------------------------------------------------------------------

class Solution {
    public int jump(int[] nums) {
        return recursive(nums,0);
    }
    int recursive(int []nums,int index){
        if(index==nums.length-1)
            return 0;
        if(index>=nums.length)
            return 1000001;
        int steps=100001;
        int max_limit=nums[index];
        for(int jump=1;jump<=max_limit;jump++){
            int next_cell=index+jump;
            steps=Math.min(steps,recursive(nums,next_cell));
        }
        return steps+1;
    }
}
