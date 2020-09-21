/* Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
] */

class Solution {
    public int[][] generateMatrix(int n) {
        int value=1;
        int a[][]=new int[n][n];
        int top=0;
        int left=0;
        int right=a[0].length-1;
        int bottom=a.length-1;
        int dir=1;
        int i;
        int size=n*n;
        while(left<=right && top<=bottom)
        {
            if(size>0)
            {
                if(dir==1)
                {
                    for(i=left;i<=right;i++)
                    {
                        a[top][i]=value;
                        value++;
                        size--;
                    }
                    dir=2;
                    top++;
                }
            }
            if(size>0)
            {
                if(dir==2)
                {
                    for(i=top;i<=bottom;i++)
                    {
                        a[i][right]=value;
                        value++;
                        size--;
                    }
                    dir=3;
                    right--;
                }
            }
            if(size>0)
            {
                if(dir==3)
                {
                    for(i=right;i>=left;i--)
                    {
                        a[bottom][i]=value;
                        value++;
                        size--;
                    }
                    dir=4;
                    bottom--;
                }
            }
            if(size>0)
            {
                if(dir==4)
                {
                    for(i=bottom;i>=top;i--)
                    {
                        a[i][left]=value;
                        value++;
                        size--;
                    }
                    dir=1;
                    left++;
                }
            }
        }
        return a;
    }
}