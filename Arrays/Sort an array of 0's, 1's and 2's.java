/* Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem. */

class Solution {
    public void sortColors(int[] nums) {
        int c0=0,c1=0,c2=0;
        for(int x:nums)
        {
            if(x==1)
                c1++;
            else if(x==2)
                c2++;
            else
                c0++;
        }
        int i=0;
		while(c0-->0)
		   nums[i++]=0;
		while(c1-->0)
		   nums[i++]=1;
		while(c2-->0)
		   nums[i++]=2;
    }
}