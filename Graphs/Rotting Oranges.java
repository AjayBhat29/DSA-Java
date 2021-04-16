/* You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2. */

class Solution {
    int R,C;
    int MAX=Integer.MAX_VALUE-100000;
    public int orangesRotting(int[][] grid) {
        R=grid.length;
        C=grid[0].length;
        
        int distance[][]=new int[R][C];
        for(int i=0;i<R;i++)for(int j=0;j<C;j++)distance[i][j]=grid[i][j]==2?0:MAX;
           
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(grid[i][j]==2)
                    BFS(grid,i,j,distance);
            }
        }
        
        int max=0;
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(distance[i][j]==MAX)
                {
                    if(grid[i][j]==1)
                        return -1;
                }
                else
                    max=Math.max(max,distance[i][j]);
            }
        }
        
        return max;
    }
    
    void BFS(int[][] grid,int X,int Y,int[][] distance)
    {
        LinkedList<Node> queue=new LinkedList<>();
        boolean visited[][]=new boolean[R][C];
        
        queue.addLast(new Node(X,Y,0));
        visited[X][Y]=true;
        
        while(!queue.isEmpty())
        {
            Node node=queue.removeFirst();
            int x=node.x,y=node.y;
            
            if(isValid(x+1,y) && !visited[x+1][y] && grid[x+1][y]==1)
            {
                queue.addLast(new Node(x+1,y,node.distance+1));
                visited[x+1][y]=true;
                distance[x+1][y]=Math.min(distance[x+1][y],node.distance+1);
            }
            
            if(isValid(x-1,y) && !visited[x-1][y] && grid[x-1][y]==1)
            {
                queue.addLast(new Node(x-1,y,node.distance+1));
                visited[x-1][y]=true;
                distance[x-1][y]=Math.min(distance[x-1][y],node.distance+1);
            }
            
            if(isValid(x,y+1) && !visited[x][y+1] && grid[x][y+1]==1)
            {
                queue.addLast(new Node(x,y+1,node.distance+1));
                visited[x][y+1]=true;
                distance[x][y+1]=Math.min(distance[x][y+1],node.distance+1);
            }
            
            if(isValid(x,y-1) && !visited[x][y-1] && grid[x][y-1]==1)
            {
                queue.addLast(new Node(x,y-1,node.distance+1));
                visited[x][y-1]=true;
                distance[x][y-1]=Math.min(distance[x][y-1],node.distance+1);
            }
        }
    }
    
    boolean isValid(int x,int y)
    {
        return x>=0&&x<R&&y>=0&&y<C;
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
