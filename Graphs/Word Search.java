/* Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 
Constraints:
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 
Follow up: Could you use search pruning to make your solution faster with a larger board? */

class Solution {
	int R, C;
	int index;

	public boolean exist(char[][] board, String word) {
		R = board.length;
		C = board[0].length;
		boolean[][] visited = new boolean[R][C];
		index = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (word.charAt(0) == board[i][j] && search(board, i, j, word, 0, visited))
					return true;
			}
		}
		return false;
	}

	boolean search(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
		if (index == word.length())
			return true;
		if (i < 0 || i >= R || j < 0 || j >= C)
			return false;
		if (word.charAt(index) != board[i][j])
			return false;
		if (visited[i][j])
			return false;

		visited[i][j] = true;

		boolean res = search(board, i, j + 1, word, index + 1, visited)
				|| search(board, i, j - 1, word, index + 1, visited)
				|| search(board, i + 1, j, word, index + 1, visited)
				|| search(board, i - 1, j, word, index + 1, visited);
		if (res == true)
			return true;

		visited[i][j] = false;
		return false;
	}
}
