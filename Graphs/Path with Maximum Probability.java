/* You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] = [a, b] is an undirected edge 
connecting the nodes a and b with a probability of success of traversing that edge succProb[i].

Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.

If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.

Example 1:
Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
Output: 0.25000
Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.

Example 2:
Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
Output: 0.30000

Example 3:
Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
Output: 0.00000
Explanation: There is no path between 0 and 2.
 
Constraints:
2 <= n <= 10^4
0 <= start, end < n
start != end
0 <= a, b < n
a != b
0 <= succProb.length == edges.length <= 2*10^4
0 <= succProb[i] <= 1
There is at most one edge between every two nodes. */

//TIP: Straight forward Dijkstra's

class Solution {
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		List<List<Node>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<>());
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			double wt = succProb[i];
			adj.get(u).add(new Node(v, wt));
			adj.get(v).add(new Node(u, wt));
		}

		double[] cost = new double[n];

		PriorityQueue<Node> pq = new PriorityQueue<>();
		cost[start] = 1;
		pq.add(new Node(start, cost[start]));

		while (!pq.isEmpty()) {
			Node node = pq.poll();

			for (Node nbr : adj.get(node.vertex)) {
				if (cost[node.vertex] * nbr.weight > cost[nbr.vertex]) {
					cost[nbr.vertex] = cost[node.vertex] * nbr.weight;
					pq.add(new Node(nbr.vertex, cost[nbr.vertex]));
				}
			}
		}

		return cost[end];
	}
}

class Node implements Comparable<Node> {
	int vertex;
	double weight;

	public Node(int v, double w) {
		this.vertex = v;
		this.weight = w;
	}

	public int compareTo(Node other) {
		if (other.weight > this.weight)
			return 1;
		else
			return -1;
	}
}
