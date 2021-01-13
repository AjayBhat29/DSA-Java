/* Given an array nums of integers, a move consists of choosing any element and decreasing it by 1.

An array A is a zigzag array if either:
Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...
Return the minimum number of moves to transform the given array nums into a zigzag array.

Example 1:
Input: nums = [1,2,3]
Output: 2
Explanation: We can decrease 2 to 0 or 3 to 1.

Example 2:
Input: nums = [9,6,1,6,2]
Output: 4

Constraints:
1 <= nums.length <= 1000
1 <= nums[i] <= 1000 */

class Solution {
    public int movesToMakeZigzag(int[] a) {
      int n=a.length;
      int evenReduce=0;
      int even[]=Arrays.copyOf(a,a.length);
      for(int i=1;i<n;i=i+2)
      {
        if(i!=0 && even[i]<=even[i-1])
        {
          evenReduce+=even[i-1]-even[i]+1;
          even[i-1]=even[i]-1;
        }
        if(i!=n-1 && even[i]<=even[i+1])
        {
          evenReduce+=even[i+1]-even[i]+1;
          even[i+1]=even[i]-1;
        }
      }
      int []odd=Arrays.copyOf(a,a.length);
      int oddReduce=0;
      for(int i=0;i<n;i=i+2)
      {
        if(i!=0 && odd[i]<=odd[i-1])
        {
          oddReduce+=odd[i-1]-odd[i]+1;
          odd[i-1]=odd[i]-1;
        }
        if(i!=n-1 && odd[i]<=odd[i+1])
        {
          oddReduce+=a[i+1]-a[i]+1;
          odd[i+1]=odd[i]-1;
        }
      }
      return Math.min(oddReduce,evenReduce);
    }
}
