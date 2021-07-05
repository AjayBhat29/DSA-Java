/* You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s. */

class Solution {
	int R, C;
	int area;

	public int largestIsland(int[][] grid) {
		R = grid.length;
		C = grid[0].length;
		List<Integer> area_of_each_color = new ArrayList<>();
		area_of_each_color.add(0);// dummy colored area to fill index 0
		area_of_each_color.add(0);// dummy colored area to fill index 1

		int color_count = 2;
		int largest_area = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == 1) {
					area = 0;
					floodFill(grid, i, j, color_count);
					area_of_each_color.add(area);
					color_count++;
					largest_area = Math.max(largest_area, area);
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == 0) {
					Set<Integer> visited = new HashSet<>();
					int surrounding_area = 0;

					if (isValid(i - 1, j)) {
						int up_color = grid[i - 1][j];
						if (!visited.contains(up_color))
							surrounding_area += area_of_each_color.get(up_color);
						visited.add(up_color);
					}
					if (isValid(i + 1, j)) {
						int down_color = grid[i + 1][j];
						if (!visited.contains(down_color))
							surrounding_area += area_of_each_color.get(down_color);
						visited.add(down_color);
					}
					if (isValid(i, j + 1)) {
						int right_color = grid[i][j + 1];
						if (!visited.contains(right_color))
							surrounding_area += area_of_each_color.get(right_color);
						visited.add(right_color);
					}
					if (isValid(i, j - 1)) {
						int left_color = grid[i][j - 1];
						if (!visited.contains(left_color))
							surrounding_area += area_of_each_color.get(left_color);
						visited.add(left_color);
					}

					surrounding_area++;// to include contribution by the zero

					largest_area = Math.max(largest_area, surrounding_area);
				}
			}
		}
		return largest_area;
	}

	boolean isValid(int i, int j) {
		return i >= 0 && i < R && j >= 0 && j < C;
	}

	void floodFill(int[][] grid, int i, int j, int color) {
		if (i < 0 || i >= R || j < 0 || j >= C)
			return;
		if (grid[i][j] != 1)
			return;

		grid[i][j] = color;
		area++;

		floodFill(grid, i, j + 1, color);
		floodFill(grid, i, j - 1, color);
		floodFill(grid, i + 1, j, color);
		floodFill(grid, i - 1, j, color);
	}
}
