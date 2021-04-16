/* Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

Example 1:
Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).

Example 2:
Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1

Example 3:
Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2
 
Constraints:
1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1 */

class Solution {
    static int R,C;
    static boolean flag;
    public int closedIsland(int[][] grid) {
        R=grid.length;
        C=grid[0].length;
        
        //applying floodFill
        int number_islands=0;
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(grid[i][j]==0)
                {
                    number_islands++;
                    flag=false;
                    floodFill(grid,i,j);
                    if(flag==true)
                        number_islands--;
                }
            }
        }
        return number_islands;
    }
    void floodFill(int grid[][],int i,int j)
    {
        if(i<0||i>=R||j<0||j>=C)
            return;
        if(grid[i][j]==1)
            return;
        if(i==R-1||j==C-1||i==0||j==0)
            flag=true;
        
        grid[i][j]=1;
        
        floodFill(grid,i+1,j);
        floodFill(grid,i-1,j);
        floodFill(grid,i,j+1);
        floodFill(grid,i,j-1);
    }
}
