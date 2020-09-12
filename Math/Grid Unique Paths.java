/*
A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).

Path Sum: Example 1

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

How many possible unique paths are there?
*/

public class Solution {
    public int uniquePaths(int A, int B) {
        if(A==1 || B==1)
            return 1;
        return uniquePaths(A,B-1)+uniquePaths(A-1,B);
    }
}
