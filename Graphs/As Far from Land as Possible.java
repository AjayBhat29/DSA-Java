/* Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

 Example 1:
Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.

Example 2:
Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.
 
Constraints:
n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1 */

//Brute  -   BFS

class Solution {
    static int R,C;
    public int maxDistance(int[][] grid) {
        R=grid.length;
        C=grid[0].length;
        
        int a[][]=new int[R][C];
        
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(grid[i][j]==1)
                    a[i][j]=0;
                else
                    a[i][j]=BFS(grid,i,j);
            }
        }
        
        int max=-1;
        for(int[] o:a) 
            for(int x:o)
                max=Math.max(max,x);
        
        return max==0?-1:max;
    }
    
    int BFS(int grid[][],int x,int y)
    {
        boolean visited[][]=new boolean[R][C];
        LinkedList<Node> queue=new LinkedList<>();
        
        queue.addLast(new Node(x,y,0));
        visited[x][y]=true;
        
        while(!queue.isEmpty())
        {
            Node node=queue.removeFirst();
            int X=node.x,Y=node.y;
            
            if(isValid(X+1,Y) && !visited[X+1][Y])
            {
                if(grid[X+1][Y]==1)
                    return node.distance+1;
                else
                {
                    queue.addLast(new Node(X+1,Y,node.distance+1));
                    visited[X+1][Y]=true;
                }
            }
            
            if(isValid(X-1,Y) && !visited[X-1][Y])
            {
                if(grid[X-1][Y]==1)
                    return node.distance+1;
                else
                {
                    queue.addLast(new Node(X-1,Y,node.distance+1));
                    visited[X-1][Y]=true;
                }
            }
            
            if(isValid(X,Y+1) && !visited[X][Y+1])
            {
                if(grid[X][Y+1]==1)
                    return node.distance+1;
                else
                {
                    queue.addLast(new Node(X,Y+1,node.distance+1));
                    visited[X][Y+1]=true;
                }
            }
            
            if(isValid(X,Y-1) && !visited[X][Y-1])
            {
                if(grid[X][Y-1]==1)
                    return node.distance+1;
                else
                {
                    queue.addLast(new Node(X,Y-1,node.distance+1));
                    visited[X][Y-1]=true;
                }
            }
        }
        return -1;
    }
    boolean isValid(int x,int y)
    {
        if(x<0||x>=R||y<0||y>=C)
            return false;
        return true;
    }
}

class Node
{
    int x;
    int y;
    int distance;
    
    public Node(int x,int y,int distance)
    {
        this.x=x;
        this.y=y;
        this.distance=distance;
    }
}
//-----------------------------------------------------------------------------------------------------------------------------------------

// Optimal  -  DP

class Solution {
    public int maxDistance(int[][] grid) {
        int R=grid.length,C=grid[0].length;
        int ans[][]=new int[R][C];
        
        for(int i=0;i<R;i++)for(int j=0;j<C;j++)ans[i][j]=Integer.MAX_VALUE-100000;
        
        int max=-1;
        
        //top and left
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(grid[i][j]==1)
                    ans[i][j]=0;
                else
                {
                    if(i>0)
                        ans[i][j]=Math.min(ans[i][j],ans[i-1][j]+1);
                    if(j>0)
                        ans[i][j]=Math.min(ans[i][j],ans[i][j-1]+1);
                }
            }
        }
        
        //bottom and right
        for(int i=R-1;i>=0;i--)
        {
            for(int j=C-1;j>=0;j--)
            {
                if(i<R-1)
                    ans[i][j]=Math.min(ans[i][j],ans[i+1][j]+1);
                if(j<C-1)
                    ans[i][j]=Math.min(ans[i][j],ans[i][j+1]+1);
            }
        }
        
        for(int[] o:ans)
            for(int x:o)
                max=Math.max(max,x);
        if(max==Integer.MAX_VALUE-100000 || max==0)
            return -1;
        return max;
    }
}

