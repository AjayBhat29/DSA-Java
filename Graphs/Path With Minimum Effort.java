/* You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, 
where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). 
You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

Example 1:
Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

Example 2:
Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].

Example 3:
Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.
 
Constraints:
rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 10^6 */

//TIP: Modified Dijkstra

class Solution {

	boolean isValid(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}

	int R, C;

	public int minimumEffortPath(int[][] heights) {
		R = heights.length;
		C = heights[0].length;

		int[][] efforts = new int[R][C];
		for (int[] g : efforts)
			Arrays.fill(g, Integer.MAX_VALUE);

		efforts[0][0] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, 0));

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int x = node.x;
			int y = node.y;
			int effort = node.effort;

			if (x == R - 1 && y == C - 1)
				return effort;

			if (isValid(x, y + 1)) {
				int nextEffort = Math.max(effort, Math.abs(heights[x][y + 1] - heights[x][y]));
				if (nextEffort < efforts[x][y + 1]) {
					efforts[x][y + 1] = nextEffort;
					pq.add(new Node(x, y + 1, nextEffort));
				}
			}

			if (isValid(x, y - 1)) {
				int nextEffort = Math.max(effort, Math.abs(heights[x][y - 1] - heights[x][y]));
				if (nextEffort < efforts[x][y - 1]) {
					efforts[x][y - 1] = nextEffort;
					pq.add(new Node(x, y - 1, nextEffort));
				}
			}

			if (isValid(x + 1, y)) {
				int nextEffort = Math.max(effort, Math.abs(heights[x + 1][y] - heights[x][y]));
				if (nextEffort < efforts[x + 1][y]) {
					efforts[x + 1][y] = nextEffort;
					pq.add(new Node(x + 1, y, nextEffort));
				}
			}

			if (isValid(x - 1, y)) {
				int nextEffort = Math.max(effort, Math.abs(heights[x - 1][y] - heights[x][y]));
				if (nextEffort < efforts[x - 1][y]) {
					efforts[x - 1][y] = nextEffort;
					pq.add(new Node(x - 1, y, nextEffort));
				}
			}
		}
		return -1;
	}

	class Node implements Comparable<Node> {
		int x;
		int y;
		int effort;

		Node(int x, int y, int effort) {
			this.x = x;
			this.y = y;
			this.effort = effort;
		}

		public int compareTo(Node other) {
			return this.effort - other.effort;
		}
	}
}
