/* You are given an integer array nums of length n which represents a permutation of all the integers in the range [0, n - 1].

The number of global inversions is the number of the different pairs (i, j) where:

0 <= i < j < n
nums[i] > nums[j]
The number of local inversions is the number of indices i where:

0 <= i < n - 1
nums[i] > nums[i + 1]
Return true if the number of global inversions is equal to the number of local inversions.

 

Example 1:

Input: nums = [1,0,2]
Output: true
Explanation: There is 1 global inversion and 1 local inversion.
Example 2:

Input: nums = [1,2,0]
Output: false
Explanation: There are 2 global inversions and 1 local inversion.
 

Constraints:

n == nums.length
1 <= n <= 10^5
0 <= nums[i] < n
All the integers of nums are unique.
nums is a permutation of all the numbers in the range [0, n - 1]. */

class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int local_inversions=getLocal(nums);
        int global_inversions=mergeSort(nums,0,nums.length-1);
        return global_inversions==local_inversions;
    }
    int mergeSort(int arr[],int s,int e){
        if(s>=e)
            return 0;
        int mid=(s+e)/2;
        int c1=mergeSort(arr,s,mid);
        int c2=mergeSort(arr,mid+1,e);
        int ci=merge(arr,s,e);
        return c1+c2+ci;
    }
    int merge(int a[],int s,int e){
        int mid=(s+e)/2;
        int i=s,j=mid+1;
        List<Integer> temp=new ArrayList<>();
        int count=0;
        while(i<=mid && j<=e){
            if(a[i]<=a[j])
                temp.add(a[i++]);
            else{
                count+=(mid-i+1);
                temp.add(a[j++]);
            }
        }
        while(i<=mid)
            temp.add(a[i++]);
        while(j<=e)
            temp.add(a[j++]);
        int k=0;
        for(i=s;i<=e;i++)
            a[i]=temp.get(k++);
        return count;
    }
    int getLocal(int a[]){
        int c=0,n=a.length;
        for(int i=0;i<n-1;i++)
            if(a[i]>a[i+1])
                c++;
        return c;
    }
}
