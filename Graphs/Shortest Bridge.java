/* In a given 2D binary array grid, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)

Example 1:
Input: grid = [[0,1],[1,0]]
Output: 1

Example 2:
Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2

Example 3:
Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1
 
Constraints:
2 <= grid.length == grid[0].length <= 100
grid[i][j] == 0 or grid[i][j] == 1 */

/* We first paint one of the islands using DFS with color 2, so we can easily identify island #1 and island #2. 
Then we start expanding island #2 by paining connected empty area. Each round, we increase the color (3, 4, and so on) so we can keep track of the newly painted area. This ends when we "bump" into the first island. */
class Solution {
	int R, C;

	public int shortestBridge(int[][] grid) {
		R = grid.length;
		C = grid[0].length;

		// color one of the island with 2
		boolean f = false;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == 1) {
					floodFill(grid, i, j, 2);
					f = true;
					break;
				}
			}
			if (f)
				break;
		}

		// store the island 2 as a starting nodes for BFS traversal
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == 2)
					q.add(new Node(i, j, 0, 2));
			}
		}

		// do BFS traversal to find the next island (next island is marked as 1)
		while (!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x;
			int y = node.y;
			int dist = node.dist;
			int color = node.color;

			if (isValid(x, y + 1)) {
				if (grid[x][y + 1] == 0) {
					grid[x][y + 1] = color + 1;
					q.add(new Node(x, y + 1, dist + 1, color + 1));
				} else if (grid[x][y + 1] == 1)
					return dist;
			}

			if (isValid(x, y - 1)) {
				if (grid[x][y - 1] == 0) {
					grid[x][y - 1] = color + 1;
					q.add(new Node(x, y - 1, dist + 1, color + 1));
				} else if (grid[x][y - 1] == 1)
					return dist;
			}

			if (isValid(x + 1, y)) {
				if (grid[x + 1][y] == 0) {
					grid[x + 1][y] = color + 1;
					q.add(new Node(x + 1, y, dist + 1, color + 1));
				} else if (grid[x + 1][y] == 1)
					return dist;
			}

			if (isValid(x - 1, y)) {
				if (grid[x - 1][y] == 0) {
					grid[x - 1][y] = color + 1;
					q.add(new Node(x - 1, y, dist + 1, color + 1));
				} else if (grid[x - 1][y] == 1)
					return dist;
			}
		}
		return 1;
	}

	void floodFill(int[][] grid, int i, int j, int newColor) {
		if (i < 0 || i >= R || j < 0 || j >= C)
			return;
		if (grid[i][j] != 1)
			return;

		grid[i][j] = newColor;

		floodFill(grid, i, j + 1, newColor);
		floodFill(grid, i, j - 1, newColor);
		floodFill(grid, i + 1, j, newColor);
		floodFill(grid, i - 1, j, newColor);
	}

	boolean isValid(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}
}

class Node {
	int x;
	int y;
	int dist;
	int color;

	public Node(int x, int y, int dist, int color) {
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.color = color;
	}
}

