/* Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:
n == nums.length
1 <= n <= 5 * 104
-231 <= nums[i] <= 231 - 1 */

//-----------------------------------------------------------
//O(n) time and O(n) space
class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length/2;
        Map<Integer,Integer> hmap=new HashMap<>();
        for(int x:nums)
            hmap.put(x,hmap.getOrDefault(x,0)+1);
        for(int x: hmap.keySet())
            if(hmap.get(x)>n)
                return x;
        return -1;
    }
}
//------------------------------------------------------------
//O(n) time and O(1) space
//Moore's Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int majorIndex=0;
        int count=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[majorIndex]==nums[i])
                count++;
            else
                count--;
            
            if(count==0)
            {
                majorIndex=i;
                count=1;
            }
        }
        int freq=0;
        for(int i=0;i<nums.length;i++)
            if(nums[i]==nums[majorIndex])
                freq++;
        if(freq>nums.length/2)
            return nums[majorIndex];
        return -1;
    }
}
