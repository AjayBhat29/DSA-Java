// DFS Method

class Solution {
  //Function to return list containing vertices in Topological order. 
  static int[] topoSort(int V, ArrayList < ArrayList < Integer >> adj) {
    // add your code here
    Stack < Integer > stack = new Stack < > ();
    boolean visited[] = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (!visited[i])
        dfsTop(i, adj, stack, visited);
    }

    int[] ans = new int[V];
    int ind = 0;
    while (!stack.empty()) {
      ans[ind++] = stack.pop();
    }
    return ans;
  }
  static void dfsTop(int cur, ArrayList < ArrayList < Integer >> adj, Stack < Integer > stack, boolean[] visited) {
    visited[cur] = true;
    for (int nbr: adj.get(cur)) {
      if (!visited[nbr])
        dfsTop(nbr, adj, stack, visited);
    }
    stack.add(cur);
  }
}

//----------------------------------------------------------------------------------------------------------------------

//BFS Method
class Solution {
  //Function to return list containing vertices in Topological order. 
  static int[] topoSort(int V, ArrayList < ArrayList < Integer >> adj) {
    // add your code here
    int[] ans = new int[V];
    int[] indegree = new int[V];

    for (int i = 0; i < V; i++) {
      for (int nbr: adj.get(i))
        indegree[nbr]++;
    }

    Queue < Integer > q = new LinkedList < > ();
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0)
        q.add(i);
    }

    int index = 0;
    while (!q.isEmpty()) {
      int node = q.poll();
      ans[index++] = node;
      
      for (int nbr: adj.get(node)) {
        indegree[nbr]--;
        
        if (indegree[nbr] == 0)
          q.add(nbr);
      }
    }

    return ans;
  }
}



