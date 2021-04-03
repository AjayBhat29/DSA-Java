/* Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.

Example 2:
Input: matrix = []
Output: 0

Example 3:
Input: matrix = [["0"]]
Output: 0

Example 4:
Input: matrix = [["1"]]
Output: 1

Example 5:
Input: matrix = [["0","0"]]
Output: 0
 
Constraints:
rows == matrix.length
cols == matrix[i].length
0 <= row, cols <= 200
matrix[i][j] is '0' or '1'. */

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row=matrix.length;
        if(row==0)
            return 0;
        int col=matrix[0].length;
        int heights[]=new int[col];
        int ans=-1;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
               if((matrix[i][j]-48)==0)
                   heights[j]=0;
                else
                    heights[j]+=(matrix[i][j]-48);
            }
            ans=Math.max(ans,Maximum_Area_Histogram(heights,col));
        }
        return ans;
    }
    
    int Maximum_Area_Histogram(int heights[],int n)
    {
        int left[]=NSL(heights,n);
        int right[]=NSR(heights,n);
        
        int width[]=new int[n];
        for(int i=0;i<n;i++)
            width[i]=right[i]-left[i]-1;
        
        int max_area=-1;
        for(int i=0;i<n;i++)
            max_area=Math.max(max_area,width[i]*heights[i]);
        return max_area;
    }
    int[] NSL(int heights[],int n) //Nearest Shortest to Left
    {
        int a[]=new int[n];
        LinkedList<Pair> stack=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(stack.isEmpty())
                a[i]=-1;
            else if(!stack.isEmpty() && stack.getFirst().height<heights[i])
                a[i]=stack.getFirst().index;
            else if(!stack.isEmpty() && stack.getFirst().height>=heights[i])
            {
                while(!stack.isEmpty() && stack.getFirst().height>=heights[i])
                    stack.pop();
                if(stack.isEmpty())
                    a[i]=-1;
                else
                    a[i]=stack.getFirst().index;
            }
            stack.addFirst(new Pair(heights[i],i));
        }
        return a;
    }
    int[] NSR(int heights[],int n) //Nearest Shortest to right
    {
        int a[]=new int[n];
        LinkedList<Pair> stack=new LinkedList<>();
        for(int i=n-1;i>=0;i--)
        {
            if(stack.isEmpty())
                a[i]=n;
            else if(!stack.isEmpty() && stack.getFirst().height<heights[i])
                a[i]=stack.getFirst().index;
            else if(!stack.isEmpty() && stack.getFirst().height>=heights[i])
            {
                while(!stack.isEmpty() && stack.getFirst().height>=heights[i])
                    stack.pop();
                if(stack.isEmpty())
                    a[i]=n;
                else
                    a[i]=stack.getFirst().index;
            }
            stack.addFirst(new Pair(heights[i],i));
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
        this.height=height;
        this.index=index;
    }
}
