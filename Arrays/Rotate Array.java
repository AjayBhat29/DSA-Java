/* Given an array, rotate the array to the right by k steps, where k is non-negative. 

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 
Constraints:
1 <= nums.length <= 2 * 10^4
-2^31 <= nums[i] <= 2^31 - 1
0 <= k <= 10^5   */

//----------------------------------------------------------------------
//O(n*d) time and O(1) space
class Solution {
    public void rotate(int[] nums, int d) {
        int n=nums.length;
        if(d==0 || d%n==0)
            return;
        if(d>n)
        {
            int temp=d/n;
            d-=temp*n;
        }
        
        for(int i=0;i<d;i++)
        {
            int temp=nums[n-1];
            for(int j=n-1;j>0;j--)
                nums[j]=nums[j-1];
            nums[0]=temp;
        }
    }
}
//----------------------------------------------------------------------
//O(n) time and O(d) space
class Solution {
    public void rotate(int[] nums, int d) {
        int n=nums.length;
        if(d==0 || d%n==0)
            return;
        if(d>n)
        {
            int temp=d/n;
            d-=temp*n;
        }
        int temp[]=new int[d];
        int j=0;
        for(int i=n-d;i<n;i++)
            temp[j++]=nums[i];
        for(int i=n-1;i>=0;i--)
        {
            if(i-d<0)
                break;
            nums[i]=nums[i-d];
        }
        for(int i=0;i<d;i++)
            nums[i]=temp[i];
    }
}
//----------------------------------------------------------------------
//O(n) time and O(1) space 
// REVERSAL ALGORITHM
class Solution {
    public void rotate(int[] nums, int d) {
        int n=nums.length;
        if(d==0 || d%n==0)
            return;
        if(d>n)
        {
            int temp=d/n;
            d-=temp*n;
        }
        
        reverse(0,n-d-1,nums);
        reverse(n-d,n-1,nums);
        reverse(0,n-1,nums);
    }
    void reverse(int start,int end,int nums[])
    {
        while(start<=end)
        {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}

