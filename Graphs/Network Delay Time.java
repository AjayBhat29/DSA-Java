/* You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), 
where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. 
If it is impossible for all the n nodes to receive the signal, return -1.

Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2

Example 2:
Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

Example 3:
Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 
Constraints:
1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.) */

//TIP: Straight forward implementation of Dijkstra's Algorithm
class Solution {
	public int networkDelayTime(int[][] times, int n, int k) {
		List<List<Node>> adj = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());

		for (int[] time : times) {
			int src = time[0];
			int dst = time[1];
			int wt = time[2];
			adj.get(src).add(new Node(dst, wt));
		}

		int[] cost = new int[n + 1];
		Arrays.fill(cost, 10000001);

		PriorityQueue<Node> pq = new PriorityQueue<>();
		cost[k] = 0;
		pq.add(new Node(k, cost[k]));

		while (!pq.isEmpty()) {
			Node node = pq.poll();

			for (Node nbr : adj.get(node.vertex)) {
				if (cost[node.vertex] + nbr.weight < cost[nbr.vertex]) {
					cost[nbr.vertex] = cost[node.vertex] + nbr.weight;
					pq.add(new Node(nbr.vertex, cost[nbr.vertex]));
				}
			}
		}

		int max = -1;
		for (int i = 1; i <= n; i++)
			max = Math.max(max, cost[i]);
		return max == 10000001 ? -1 : max;
	}
}

class Node implements Comparable<Node> {
	int vertex;
	int weight;

	public Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	public int compareTo(Node other) {
		return this.weight - other.weight;
	}
}
