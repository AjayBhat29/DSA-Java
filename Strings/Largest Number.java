/* Given a list of non-negative integers nums, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer. 
Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
Example 3:

Input: nums = [1]
Output: "1"
Example 4:

Input: nums = [10]
Output: "10"
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 10^9 */


class Solution {
    public String largestNumber(int[] nums) {
        int n=nums.length;
        String []a=new String[n];
        for(int i=0;i<n;i++)
            a[i]=String.valueOf(nums[i]);
        
        Arrays.sort(a,new StringNumberCompare());
        
        if(a[0].equals("0"))
            return "0";
        StringBuilder result=new StringBuilder();
        for(String x: a)
            result.append(x);
        return result.toString();
    }
    private class StringNumberCompare implements Comparator<String>
    {
        public int compare(String one,String two)
        {
            String a=one.concat(two);
            String b=two.concat(one);
            return b.compareTo(a);
        }
    }
}
