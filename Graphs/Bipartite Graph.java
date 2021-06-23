/* Given an adjacency list of a graph adj  of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.
 
Example 1:
Input: 
Output: 1
Explanation: The given graph can be colored 
in two colors so, it is a bipartite graph.

Example 2:
Input:
Output: 0
Explanation: The given graph cannot be colored 
in two colors such that color of adjacent 
vertices differs. 
 
Your Task:
You don't need to read or print anything. 
Your task is to complete the function isBipartite() which takes V denoting no. of vertices and adj denoting adjacency list of graph and returns a boolean value true if graph
is bipartite otherwise returns false.

Expected Time Complexity: O(V)
Expected Space Complexity: O(V)

Constraints:
1 ≤ V, E ≤ 10^5 */

class Solution {
  public boolean isBipartite(int V, ArrayList < ArrayList < Integer >> adj) {
    // Code here
    int[] colours = new int[V];
    Arrays.fill(colours, -1);

    for (int i = 0; i < V; i++) {
      if (colours[i] == -1) {
        if (checkBFS(i, adj, colours) == false)
          return false;
      }
    }
    return true;
  }
  boolean checkBFS(int cur, ArrayList < ArrayList < Integer >> adj, int[] colours) {
    Queue < Integer > q = new LinkedList < > ();
    q.add(cur);
    colours[cur] = 0;

    while (!q.isEmpty()) {
      int node = q.poll();
      for (int nbr: adj.get(node)) {
        if (colours[nbr] == -1) {
          colours[nbr] = 1 - colours[node];
          q.add(nbr);
        } else if (colours[nbr] == colours[node])
          return false;
      }
    }
    return true;
  }
}
