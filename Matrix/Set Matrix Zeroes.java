/* Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution? */

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row_flag=false;
        boolean col_flag=false;
        int i,j;
        int n=matrix.length;
        int m=matrix[0].length;
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(i==0 && matrix[i][j]==0)
                    row_flag=true;
                if(j==0 && matrix[i][j]==0)
                    col_flag=true;
                if(matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(i=1;i<n;i++)
        {
            for(j=1;j<m;j++)
            {
                if(matrix[i][0]==0 || matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        if(row_flag)
        {
            for(i=0;i<m;i++)
                matrix[0][i]=0;
        }
        if(col_flag)
        {
            for(i=0;i<n;i++)
                matrix[i][0]=0;
        }
    }
}