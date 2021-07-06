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
    public int orangesRotting(int[][] grid) {
        R=grid.length;C=grid[0].length;
    
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++)
                if(grid[i][j]==2)
                    q.add(new Node(i,j,0));
        }
        
        int total_time=0;
        
        while(!q.isEmpty()){
            Node node=q.poll();
            int x=node.x;
            int y=node.y;
            int time=node.time;
            
            if(isValid(x,y+1) && grid[x][y+1]==1){
                grid[x][y+1]=2;
                q.add(new Node(x,y+1,time+1));
            }
            
            if(isValid(x,y-1) && grid[x][y-1]==1){
                grid[x][y-1]=2;
                q.add(new Node(x,y-1,time+1));
            }
            
            if(isValid(x+1,y) && grid[x+1][y]==1){
                grid[x+1][y]=2;
                q.add(new Node(x+1,y,time+1));
            }
            
            if(isValid(x-1,y) && grid[x-1][y]==1){
                grid[x-1][y]=2;
                q.add(new Node(x-1,y,time+1));
            }
            
            total_time=Math.max(total_time,time);
        }
        
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++)
                if(grid[i][j]==1)
                    return -1;
        }
        
        return total_time;
    }
    
    boolean isValid(int x,int y){
        return x>=0 && x<R && y>=0 && y<C;
    }
}

class Node{
    int x;
    int y;
    int time;
    public Node(int x,int y,int time){
        this.x=x;
        this.y=y;
        this.time=time;
    }
}
