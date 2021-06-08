/* The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
Input: n = 1
Output: [["Q"]]

Constraints:
1 <= n <= 9 */

class Solution {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean []vertical=new boolean[n];
        boolean []left=new boolean[2*n-1];
        boolean []right=new boolean[2*n-1];
        
        List<String> inter=new ArrayList<>(n);
        for(int i=0;i<n;i++)
            inter.add("");
        
        helper(0,vertical,left,right,n,inter);
        return res;
    }
    
    void helper(int row,boolean []vertical,boolean []left,boolean []right,int n,List<String> inter){
        if(row==n){
            List<String> br=new ArrayList<>(inter);
            res.add(br);
            return;
        }
        for(int col=0;col<n;col++){
            int diagL=row-col+n-1;
            int diagR=row+col;
            if(vertical[col]||left[diagL]||right[diagR])
                continue;
            
            vertical[col]=left[diagL]=right[diagR]=true;
            
            char []rowInter=new char[n];
            Arrays.fill(rowInter,'.');
            rowInter[col]='Q';
            String rowInterStr=new String(rowInter);
            inter.set(row,rowInterStr);
            
            helper(row+1,vertical,left,right,n,inter);
            
            vertical[col]=left[diagL]=right[diagR]=false;
        }
    }
}


//------------------------------------------------------------------------------------------------------------------------------------------------------------
//GFG Code
/* The n-queens puzzle is the problem of placing n queens on a (n×n) chessboard such that no two queens can attack each other.
Given an integer n, find all distinct solutions to the n-queens puzzle. Each solution contains distinct board configurations of the n-queens’ placement, 
where the solutions are a permutation of [1,2,3..n] in increasing order, here the number in the ith place denotes that the ith-column queen is placed in the row with that number. 
For eg below figure represents a chessboard [3 1 4 2].

Example 1:
Input:
1
Output:
[1]
Explaination:
Only one queen can be placed 
in the single cell available.

Example 2:
Input:
4
Output:
[2 4 1 3 ] [3 1 4 2 ]
Explaination:
These are the 2 possible solutions.
 
Your Task:
You do not need to read input or print anything. Your task is to complete the function nQueen() which takes n as input parameter and returns a list containing all the possible chessboard configurations. Return an empty list if no solution exists.

Expected Time Complexity: O(n!)
Expected Auxiliary Space: O(n2) 
  
Constraints:
1 ≤ n ≤ 10  */

class Solution{
    static ArrayList<ArrayList<Integer>> res;
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        res=new ArrayList<>();
        boolean []v=new boolean[n];
        boolean []l=new boolean[2*n-1];
        boolean []r=new boolean[2*n-1];
        
        ArrayList<Integer> inter=new ArrayList<>();
        for(int i=0;i<n;i++)
            inter.add(0);
            
        helper(0,v,l,r,inter,n);
        
        return res;
    }
    static void helper(int row,boolean []v,boolean []l,boolean []r,ArrayList<Integer> inter,int n){
        if(row==n){
            ArrayList<Integer> br=new ArrayList<>(inter);
            res.add(br);
            return;
        }
        for(int col=0;col<n;col++){
            int dL=row-col+n-1;
            int dR=row+col;
            
            if(v[col]||l[dL]||r[dR])
                continue;
            
            v[col]=l[dL]=r[dR]=true;
            
            inter.set(row,col+1);
            helper(row+1,v,l,r,inter,n);
            
            v[col]=l[dL]=r[dR]=false;
        }
    }
}
