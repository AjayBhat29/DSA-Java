/* Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.

Example 1:
Input:
nums = {2, 8, 5, 4}
Output:
1
Explaination:
swap 8 with 4.

Example 2:
Input:
nums = {10, 19, 6, 3, 5}
Output:
2
Explaination:
swap 10 with 3 and swap 19 with 5.

Your Task:
You do not need to read input or print anything. 
Your task is to complete the function minSwaps() which takes the nums as input parameter and returns an integer denoting the minimum number of swaps required to sort the array. 
If the array is already sorted, return 0. 

Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 10^5
1 ≤ numsi ≤ 10^6 */

class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int n=nums.length;
        Pair arr[]=new Pair[n];
        
        for(int i=0;i<n;i++)
            arr[i]=new Pair(nums[i],i);
        
        Arrays.sort(arr);
        
        int total_swaps=0;
        boolean []visited=new boolean[n];
        
        for(int i=0;i<n;i++){
            int old_position=arr[i].pos;
            if(visited[i]==true || old_position==i)
                continue;
            
            int node=i;
            int no_nodes=0;
            while(!visited[node]){
                visited[node]=true;
                node=arr[node].pos;
                no_nodes++;
            }
            
            total_swaps+=(no_nodes-1);
        }
        
        return total_swaps;
    }
}

class Pair implements Comparable<Pair>
{
    int value;
    int pos;
    
    Pair(int value,int pos){
        this.value=value;
        this.pos=pos;
    }
    
    public int compareTo(Pair other){
        return this.value-other.value;
    }
}
