/* In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
C_1 is at location (0, 0) (ie. has value grid[0][0])
C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1. */

class Solution {
    static int R;
    static int C;
    public int shortestPathBinaryMatrix(int[][] grid) {
        R=grid.length;
        C=grid[0].length;
        
        //if source or destination are blocked
        if(grid[0][0]==1||grid[R-1][C-1]==1)
            return -1;
        
        LinkedList<Node> queue=new LinkedList<>();
        boolean visited[][]=new boolean[R][C];
        
        
        //BFS
        Node start=new Node(0,0,1);
        queue.addLast(start);
        visited[0][0]=true;
        
        while(!queue.isEmpty())
        {   
            Node node=queue.removeFirst();
            
            if(node.x==R-1 && node.y==C-1)
                return node.distance;
            
            int x=node.x;
            int y=node.y;
            
            //one cell left
            if(isValid(x-1,y) && !visited[x-1][y] && grid[x-1][y]==0)
            {
                queue.addLast(new Node(x-1,y,node.distance+1));
                visited[x-1][y]=true;
            }
            
            //one cell right
            if(isValid(x+1,y) && !visited[x+1][y] && grid[x+1][y]==0)
            {
                queue.addLast(new Node(x+1,y,node.distance+1));
                visited[x+1][y]=true;
            }
            
            //one cell above
            if(isValid(x,y-1) && !visited[x][y-1] && grid[x][y-1]==0)
            {
                queue.addLast(new Node(x,y-1,node.distance+1));
                visited[x][y-1]=true;
            }
            
            //one cell below
            if(isValid(x,y+1) && !visited[x][y+1] && grid[x][y+1]==0)
            {
                queue.addLast(new Node(x,y+1,node.distance+1));
                visited[x][y+1]=true;
            }
            
            //top left
            if(isValid(x-1,y-1) && !visited[x-1][y-1] && grid[x-1][y-1]==0)
            {
                queue.addLast(new Node(x-1,y-1,node.distance+1));
                visited[x-1][y-1]=true;
            }
            
            //down right
            if(isValid(x+1,y+1) && !visited[x+1][y+1] && grid[x+1][y+1]==0)
            {
                queue.addLast(new Node(x+1,y+1,node.distance+1));
                visited[x+1][y+1]=true;
            }
            
            //below left
            if(isValid(x-1,y+1) && !visited[x-1][y+1] && grid[x-1][y+1]==0)
            {
                queue.addLast(new Node(x-1,y+1,node.distance+1));
                visited[x-1][y+1]=true;
            }
            
            //top right
            if(isValid(x+1,y-1) && !visited[x+1][y-1] && grid[x+1][y-1]==0)
            {
                queue.addLast(new Node(x+1,y-1,node.distance+1));
                visited[x+1][y-1]=true;
            }
        }
        return -1;
    }
    boolean isValid(int x,int y)
    {
        return x>=0 && x<R && y>=0 && y<C;
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
