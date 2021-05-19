/* Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, 
then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 Example 1:
Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Example 2:
Input: nums = [1,2,3,4]
Output: 0

Example 3:
Input: nums = [1]
Output: 0
 
Constraints:
1 <= nums.length <= 10^4
-105 <= nums[i] <= 10^5 */

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length==1)return 0;
        
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(outOfOrder(nums,i)){
                max=Math.max(max,nums[i]);
                min=Math.min(min,nums[i]);
            }
        }
        if(min==Integer.MAX_VALUE)
            return 0;
        
        int l=0,r=nums.length-1;
        while(min>=nums[l])
            l++;
        while(max<=nums[r])
            r--;
        
        return r-l+1;
    }
    
    boolean outOfOrder(int a[],int i){
        if(i==0)
            return a[i]>a[i+1];
        if(i==a.length-1)
            return a[i-1]>a[i];
        return a[i]>a[i+1]||a[i]<a[i-1];
    }
}
