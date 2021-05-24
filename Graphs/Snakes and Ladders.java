// Interview Bit 

/* Problem Description
Rishabh takes out his Snakes and Ladders Game, stares the board and wonders: "If I can always roll the die to whatever number I want, 
what would be the least number of rolls to reach the destination?"

RULES:
The game is played with cubic dice of 6 faces numbered from 1 to A.
Starting from 1 , land on square 100 with the exact roll of the die. If moving the number rolled would place the player beyond square 100, no move is made.
If a player lands at the base of a ladder, the player must climb the ladder. Ladders go up only.
If a player lands at the mouth of a snake, the player must go down the snake and come out through the tail. Snakes go down only.

BOARD DESCRIPTION:
The board is always 10 x 10 with squares numbered from 1 to 100.
The board contains N ladders given in a form of 2D matrix A of size N * 2 where (A[i][0], A[i][1]) denotes a ladder that has its base on square A[i][0] and end at square A[i][1].
The board contains M snakes given in a form of 2D matrix B of size M * 2 where (B[i][0], B[i][1]) denotes a snake that has its mouth on square B[i][0] and tail at square B[i][1].

Problem Constraints
1 <= N, M <= 15
1 <= A[i][0], A[i][1], B[i][0], B[i][1] <= 100
A[i][0] < A[i][1] and B[i][0] > B[i][1]
Neither square 1 nor square 100 will be the starting point of a ladder or snake.
A square will have at most one endpoint from either a snake or a ladder.

Input Format
First argument is a 2D matrix A of size N * 2 where (A[i][0], A[i][1]) denotes a ladder that has its base on square A[i][0] and end at square A[i][1].
Second argument is a 2D matrix B of size M * 2 where (B[i][0], B[i][1]) denotes a snake that has its mouth on square B[i][0] and tail at square B[i][1].

Output Format
Return the least number of rolls to move from start to finish on a separate line. If there is no solution, return -1.

Example Input
Input 1:
 A = [  [32, 62]
        [42, 68]
        [12, 98]
     ]
 B = [  [95, 13]
        [97, 25]
        [93, 37]
        [79, 27]
        [75, 19]
        [49, 47]
        [67, 17]

Input 2:
 A = [  [8, 52]
        [6, 80]
        [26, 42]
        [2, 72]
     ]
 B = [  [51, 19]
        [39, 11]
        [37, 29]
        [81, 3]
        [59, 5]
        [79, 23]
        [53, 7]
        [43, 33]
        [77, 21] 


Example Output
Output 1:
 3
Output 2:
 5

Example Explanation
Explanation 1:
 The player can roll a 5 and a 6 to land at square 12. There is a ladder to square 98. A roll of 2 ends the traverse in 3 rolls.

Explanation 2:
 The player first rolls 5 and climbs the ladder to square 80. Three rolls of 6 get to square 98.
 A final roll of 2 lands on the target square in 5 total rolls. */

public class Solution {
    public int snakeLadder(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
    
        int board[][]=new int[10][10];
        for(ArrayList<Integer> ladder:A){
            int []co_ord=getCoordinates(board,ladder.get(0));
            board[co_ord[0]][co_ord[1]]=ladder.get(1);
        }
        for(ArrayList<Integer> snake:B){
            int []co_ord=getCoordinates(board,snake.get(0));
            board[co_ord[0]][co_ord[1]]=snake.get(1);
        }
        
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(board[i][j]==0)
                    board[i][j]=-1;
            }
        }
        
        Queue<Integer> queue=new LinkedList<>();
        int goal=100;
        boolean []visited=new boolean[101];
        
        int steps=0;
        
        queue.add(1);
        visited[1]=true;
        
        while(!queue.isEmpty())
        {
            for(int size=queue.size();size>0;size--)
            {
                int cur=queue.poll();
                if(cur==goal)return steps;
                for(int i=1;i<7 && cur+i<=goal;i++){
                    int next=cur+i;
                    int []values=getCoordinates(board,next);
                    int value=board[values[0]][values[1]];
                    next=(value==-1)?next:value;
                    if(!visited[next]){
                        queue.add(next);
                        visited[next]=true;
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
    int []getCoordinates(int board[][],int n){
        int rows=board.length,cols=board[0].length;
        int r = rows - 1 - (n - 1) / cols;
        int c = (n - 1) % cols;
        if (r % 2 == rows % 2) {
            return new int[]{r, cols - 1 - c};
        } else {
            return new int[]{r, c};
        }
    }
}


//------------------------------------------------------------------------------------------------------------------------------------------------------------------//
// LeetCode 
/* On an N x N board, the numbers from 1 to N*N are written boustrophedonically starting from the bottom left of the board, and alternating direction each row.  
For example, for a 6 x 6 board, the numbers are written as follows:

You start on square 1 of the board (which is always in the last row and first column).  Each move, starting from square x, consists of the following:

You choose a destination square S with number x+1, x+2, x+3, x+4, x+5, or x+6, provided this number is <= N*N.
(This choice simulates the result of a standard 6-sided die roll: ie., there are always at most 6 destinations, regardless of the size of the board.)
If S has a snake or ladder, you move to the destination of that snake or ladder.  Otherwise, you move to S.
A board square on row r and column c has a "snake or ladder" if board[r][c] != -1.  The destination of that snake or ladder is board[r][c].

Note that you only take a snake or ladder at most once per move: if the destination to a snake or ladder is the start of another snake or ladder, you do not continue moving.  (For example, if the board is `[[4,-1],[-1,3]]`, and on the first move your destination square is `2`, then you finish your first move at `3`, because you do not continue moving to `4`.)

Return the least number of moves required to reach square N*N.  If it is not possible, return -1.

Example 1:
Input: [
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,-1,-1,-1,-1,-1],
[-1,35,-1,-1,13,-1],
[-1,-1,-1,-1,-1,-1],
[-1,15,-1,-1,-1,-1]]
Output: 4

Explanation: 
At the beginning, you start at square 1 [at row 5, column 0].
You decide to move to square 2, and must take the ladder to square 15.
You then decide to move to square 17 (row 3, column 5), and must take the snake to square 13.
You then decide to move to square 14, and must take the ladder to square 35.
You then decide to move to square 36, ending the game.
It can be shown that you need at least 4 moves to reach the N*N-th square, so the answer is 4.
Note:

2 <= board.length = board[0].length <= 20
board[i][j] is between 1 and N*N or is equal to -1.
The board square with number 1 has no snake or ladder.
The board square with number N*N has no snake or ladder. */

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        if(board == null || n == 0)
            return -1;
        int goal=n*n;
        int steps=0;
        
        Queue<Integer> queue=new LinkedList<>();
        boolean []visited=new boolean[n*n+1];
        
        queue.add(1);
        visited[1]=true;
        
        while(!queue.isEmpty())
        {
            
            for(int size=queue.size();size>0;size--)
            {
                int cur=queue.poll();  
                if(cur==goal)return steps;
                for(int i=1;i<7 && i+cur<=goal;i++)
                {
                    int next=cur+i;
                    int value = getValueInBoard(board,next);
                    next = (value==-1) ? next : value;
                    if(!visited[next])
                    {
                        queue.add(next);
                        visited[next]=true;
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
    int getValueInBoard(int [][]board,int num)
    {
        int n = board.length;
        int r = (num - 1) / n;
        int x = n - 1 - r;
        int y = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
        return board[x][y];
    }
    boolean isValid(int next,int goal)
    {
        return next<=goal;
    }
}
