/*Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one duplicate number in nums, return this duplicate number.*/

// 0(n) time and O(n) space using HashSet
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> hset=new HashSet<>();
        for(int x: nums)
        {
            if(!hset.contains(x))
                hset.add(x);
            else
                return x;
        }
        return -1;
    }
}
 