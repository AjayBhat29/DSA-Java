/* Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.

Example 1:
Input: N = 4, K = 2
Arr = [100, 200, 300, 400]
Output: 700
Explanation: Arr3  + Arr4 =700, which is maximum.

Example 2:
Input: N = 4, K = 4
Arr = [100, 200, 300, 400]
Output: 1000
Explanation:Arr1 + Arr2 + Arr3  + Arr4 =1000,which is maximum.

Your Task:
You don't need to read input or print anything. Your task is to complete the function maximumSumSubarray() which takes the integer k, vector Arr with size N, containing the elements of the array and returns the maximum sum of a subarray of size K.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1) */

//--------------------------------------------------------
//O(n^2) time
class Solution{
    static int maximumSumSubarray(int k, ArrayList<Integer> Arr,int n){
        // code here
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=n-k;i++)
        {
            int sum=0;
            for(int j=i;j<i+k;j++)
                sum+=Arr.get(j);
            max=Math.max(max,sum);
        }
        return max;
    }
}

//--------------------------------------------------------
//O(n) time => Sliding Window Technique
class Solution{
    static int maximumSumSubarray(int k, ArrayList<Integer> Arr,int n){
        // code here
        int sum=0;
        for(int i=0;i<k;i++)
            sum+=Arr.get(i);
        
        int max=sum;
        
        for(int i=k;i<n;i++)
        {
            sum=sum+Arr.get(i)-Arr.get(i-k);
            max=Math.max(sum,max);
        }
        return max;
    }
}
