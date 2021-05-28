/* Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 
Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique. */

class Solution {
    List<List<Integer>> ans;
    int n,k;
    public List<List<Integer>> subsets(int[] nums) {
        ans=new ArrayList<>();
        n=nums.length;
        for(k=0;k<n+1;k++){
            getSS(nums,0,new ArrayList<Integer>());
        }
        return ans;
    }
    void getSS(int []nums,int i,ArrayList<Integer> l){
        if(l.size()==k){
            ans.add(new ArrayList(l));
            return;
        }
        for(int j=i;j<n;j++){
            l.add(nums[j]);
            getSS(nums,j+1,l);
            l.remove(l.size()-1);
        }
    }
}
