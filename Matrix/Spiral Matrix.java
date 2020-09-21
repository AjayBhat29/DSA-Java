/* Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5] */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        if(matrix.length==0 || matrix[0].length==0)
            return ans;
        int top=0;
        int left=0;
        int right=matrix[0].length-1;
        int bottom=matrix.length-1;
        int dir=1;
        int i;
        int count=(bottom+1)*(right+1);
        while(left<=right && top<=bottom)
        {
            if(count>0)
            {
                if(dir==1)
                {
                    for(i=left;i<=right;i++)
                    {
                        ans.add(matrix[top][i]);
                        count--;
                    }
                    dir=2;
                    top++;
                }
            }
            if(count>0)
            {
                if(dir==2)
                {
                    for(i=top;i<=bottom;i++)
                    {
                        ans.add(matrix[i][right]);
                        count--;
                    }
                    dir=3;
                    right--;
                }
            }
            if(count>0)
            {
                if(dir==3)
                {
                    for(i=right;i>=left;i--)
                    {
                        ans.add(matrix[bottom][i]);
                        count--;
                    }
                    dir=4;
                    bottom--;
                }
            }
            if(count>0)
            {
                if(dir==4)
                {
                    for(i=bottom;i>=top;i--)
                    {
                        ans.add(matrix[i][left]);
                        count--;
                    }
                    dir=1;
                    left++;
                }
            }
        }
        return ans;
        
    }
}