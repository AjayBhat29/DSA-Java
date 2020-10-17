/* Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1' */

class Solution {
    static int R;
    static int C;
    public int numIslands(char[][] grid) {
        R=grid.length;
        C=grid[0].length;
        
        int count=0;
        
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    floodFill(grid,i,j);
                }
            }
        }
        return count;
    }
    public void floodFill(char [][]grid,int i,int j)
    {
        if(i<0||i>=R||j<0||j>=C)
            return;
        if(grid[i][j]!='1')
            return;
        
        //work of recursion
        grid[i][j]='0';
        
        floodFill(grid,i-1,j);
        floodFill(grid,i,j-1);
        floodFill(grid,i+1,j);
        floodFill(grid,i,j+1);
    }
    
}