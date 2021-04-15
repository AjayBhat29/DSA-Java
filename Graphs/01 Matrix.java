/* Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Example 1:
Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Example 2:
Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]
 
Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 
Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right. */

//Brute Force - BFS
class Solution {
    static int cur,R,C;
    public int[][] updateMatrix(int[][] matrix) {
        R=matrix.length;
        C=matrix[0].length;
        int [][]a=new int[R][C];
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(matrix[i][j]==0)
                    a[i][j]=0;
                else
                {
                    cur=BFS(matrix,i,j);
                    a[i][j]=cur;
                }
            }
        }
        return a;
    }
    int BFS(int matrix[][],int x,int y)
    {
        boolean [][]visited=new boolean[R][C];
        LinkedList<Node> queue=new LinkedList<>();
        
        queue.addLast(new Node(x,y,0));
        visited[x][y]=true;
        
        while(!queue.isEmpty())
        {
            Node node=queue.removeFirst();
            
            int X=node.x,Y=node.y;
            
            if(isValid(X+1,Y) && !visited[X+1][Y])
            {
                if(matrix[X+1][Y]==0)
                    return node.distance+1;
                else
                {
                    queue.addLast(new Node(X+1,Y,node.distance+1));
                    visited[X+1][Y]=true;
                }
            }
            
            if(isValid(X-1,Y) && !visited[X-1][Y])
            {
                if(matrix[X-1][Y]==0)
                    return node.distance+1;
                else
                {
                    queue.addLast(new Node(X-1,Y,node.distance+1));
                    visited[X-1][Y]=true;
                }
            }
            
            if(isValid(X,Y+1) && !visited[X][Y+1])
            {
                if(matrix[X][Y+1]==0)
                    return node.distance+1;
                else
                {
                    queue.addLast(new Node(X,Y+1,node.distance+1));
                    visited[X][Y+1]=true;
                }
            }
            
            if(isValid(X,Y-1) && !visited[X][Y-1])
            {
                if(matrix[X][Y-1]==0)
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
//------------------------------------------------------------------------------------------------------------
//Optimal - DP
class Solution {
    static int cur,R,C;
    public int[][] updateMatrix(int[][] matrix) {
        R=matrix.length;
        C=matrix[0].length;
        int ans[][]=new int[R][C];
        for(int i=0;i<R;i++) for(int j=0;j<C;j++) ans[i][j]=Integer.MAX_VALUE-100000;
        
        //top and left
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(matrix[i][j]==0)
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
        
        //down and right
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
        
        return ans;
    }
}
