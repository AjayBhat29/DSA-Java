/* Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:
1 <= nums.length <= 200
-109 <= nums[i] <= 10^9
-109 <= target <= 10^9 */

class Solution {
  public List < List < Integer >> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    int n = nums.length;
    
    List < List < Integer >> ans = new ArrayList < > ();
    
    for (int i = 0; i < n - 3; i++) {
      if (i != 0 && i < n - 3 && nums[i] == nums[i - 1])
        continue;
    
      for (int j = i + 1; j < n - 2; j++) {
        if (j != i + 1 && j < n - 2 && nums[j] == nums[j - 1])
          continue;

        int left = j + 1, right = n - 1;
        int need = target - (nums[i] + nums[j]);

        while (left < right) {
          int sum = nums[left] + nums[right];
      
          if (sum < need) left++;
          
          else if (sum > need) right--;
          
          else {
            List < Integer > inter = new ArrayList < > ();
            
            inter.add(nums[i]);
            inter.add(nums[j]);
            inter.add(nums[left]);
            inter.add(nums[right]);
            
            ans.add(inter);

            while (left < right && nums[left] == inter.get(2)) left++;
            while (left < right && nums[right] == inter.get(3)) right--;
          }
        }
      }
    }
    
    return ans;
  }
}
