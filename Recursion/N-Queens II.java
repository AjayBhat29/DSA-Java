/* The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example 1:
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

Example 2:
Input: n = 1
Output: 1
 
Constraints:
1 <= n <= 9 */

class Solution {
    int res=0;
    public int totalNQueens(int n) {
        boolean []vertical=new boolean[n];
        boolean []left=new boolean[2*n-1];
        boolean []right=new boolean[2*n-1];
        helper(0,vertical,left,right,n);
        return res;
    }
    
    void helper(int row,boolean []vertical,boolean []left,boolean []right,int n){
        if(row==n){
            res++;
            return;
        }
        
        for(int col=0;col<n;col++){
            int digl=row-col+n-1;
            int digr=row+col;
            
            if(vertical[col]||left[digl]||right[digr])
                continue;
            
            vertical[col]=true;
            left[digl]=true;
            right[digr]=true;
            
            helper(row+1,vertical,left,right,n);
            
            vertical[col]=false;
            left[digl]=false;
            right[digr]=false;
        }        
    }
}
