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
        int n = heights.length;
        
        int []left = NSL(heights,n);//Nearest Smaller to Left
        int []right = NSR(heights,n);//Neartest Smaller to Right
        
        int width[] = new int[n];
        for(int i=0;i<n;i++)
            width[i] = right[i]-left[i]-1;
        
        int max_area=-1;
        for(int i=0;i<n;i++)
            max_area=Math.max(max_area,heights[i]*width[i]);
        
        return max_area;
    }
    
    int[] NSL(int heights[],int n) //Nearest Smallest to Left
    {
        int a[]=new int[n];
        Stack<Pair> stack=new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(stack.empty())
                a[i]=-1;
            else if(!stack.empty() && stack.peek().height<heights[i])
                a[i]=stack.peek().index;
            else if(!stack.empty() && stack.peek().height>=heights[i])
            {
                while(!stack.empty() && stack.peek().height>=heights[i])
                    stack.pop();
                if(stack.empty())
                    a[i]=-1;
                else
                    a[i]=stack.peek().index;
            }
            stack.push(new Pair(heights[i],i));
        }
        return a;
    }
    
    int[] NSR(int heights[],int n) // Nearest Smallest to Right
    {
        int a[]=new int[n];
        Stack<Pair> stack=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            if(stack.empty())
                a[i]=n;
            else if(!stack.empty() && stack.peek().height<heights[i])
                a[i]=stack.peek().index;
            else if(!stack.empty() && stack.peek().height>=heights[i])
            {
                while(!stack.empty() && stack.peek().height>=heights[i])
                    stack.pop();
                if(stack.empty())
                    a[i]=n;
                else
                    a[i]=stack.peek().index;
            }
            stack.push(new Pair(heights[i],i));
        }
        return a;
    }
}

class Pair
{
    int height;
    int index;
    
    public Pair(int height,int index)
    {
        this.height = height;
        this.index = index;
    }
}
