/* Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4
 
Constraints:
1 <= heights.length <= 10^5
0 <= heights[i] <= 10^4 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        /* The idea is to find the maximum width u can get for each building height.
            This can be obtained by finding the index of NSR and index of NSL.
            NSR = > Nearest Smaller to the Right
            NSL = > Nearest Smaller to the Left
            Then calculate the maximum width array using NSR[i]-NSL[i]
            The calculate area array as max_width[i]*height[i]
            Then the answer can be found as the maximum element present in area array */
        int n=heights.length;
        int []NSR=getNSR(heights,n);
        int []NSL=getNSL(heights,n);

        int []max_width=new int[n];
        for(int i=0;i<n;i++)
            max_width[i]=NSR[i]-NSL[i]-1;
        
        int []area=new int[n]; // for this question you don't need to store the area array. But it is useful if the interviewer asks maximum area contribution by each building
        int max_area=0;
        for(int i=0;i<n;i++){
            area[i]=max_width[i]*heights[i];
            max_area=Math.max(max_area,area[i]);
        }
        
        return max_area;
    }
    
    int[] getNSR(int []arr,int n){
        int []ans=new int[n];
        ans[n-1]=n;
        Stack<Integer> stack=new Stack<>();
        stack.push(n-1);
        
        for(int i=n-2;i>=0;i--){
            while(!stack.empty() && arr[i]<=arr[stack.peek()])
                stack.pop();
            if(stack.empty())
                ans[i]=n;
            else
                ans[i]=stack.peek();
            stack.push(i);
        }
        return ans;
    }
    
    int[] getNSL(int []arr,int n){
        int []ans=new int[n];
        ans[0]=-1;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        
        for(int i=1;i<n;i++){
            while(!stack.empty() && arr[i]<=arr[stack.peek()])
                stack.pop();
            if(stack.empty())
                ans[i]=-1;
            else
                ans[i]=stack.peek();
            stack.push(i);
        }
        return ans;
    }
}
