/* Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it can trap after raining. 
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:
n == height.length
0 <= n <= 3 * 10^4
0 <= height[i] <= 10^5 */

//O(n^2) time and O(1) space
class Solution {
    public int trap(int[] height) {
        int water=0;
        int n=height.length;
        if(n==0)
            return 0;
        for(int i=1;i<n-1;i++)
        {
             int lmax=height[0];
             int rmax=height[n-1];
             for(int j=i;j>=0;j--)
                 lmax=Math.max(lmax,height[j]);
             for(int j=i;j<n;j++)
                 rmax=Math.max(rmax,height[j]);
             water+=Math.min(lmax,rmax)-height[i];
         }
        return water;
    }
 }
 //---------------------------------------------------------------------------------------------------------------------------      
 // O(n) time and O(n) space
 class Solution {
    public int trap(int[] height) {
        int water=0;
        int n=height.length;
        if(n==0)
            return 0;
            
        int lmax[]=new int[n];
        lmax[0]=height[0];
        for(int i=1;i<n-1;i++)
            lmax[i]=Math.max(lmax[i-1],height[i]);
            
        int rmax[]=new int[n];
        rmax[n-1]=height[n-1];
        for(int i=n-2;i>0;i--)
            rmax[i]=Math.max(rmax[i+1],height[i]);
            
        for(int i=1;i<n-1;i++)
            water+=Math.min(lmax[i],rmax[i])-height[i];
        return water;
    }
}


