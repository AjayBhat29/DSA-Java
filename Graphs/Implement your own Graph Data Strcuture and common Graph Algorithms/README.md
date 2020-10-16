1)This code has been implemented by using a HashMap to store all the vertices as keys and their corresponding neighbours(as values) in another class called Vertex.
2)The vertex class consists of another HashMap, where the keys are vertices(neighbours) and their values are Integers denotig the costs.

The following graph based algorithms have been implemented in the Graph.java file:
1) Kruskal's Algorithm
2) Prim's Algorithm
3) Dijkstra's Algorithm
4) Bellman Ford's Algorithm

and other common implentations such as:
1) hasPath(String v1,String v2, HashSet<String> visited) :-Check whether two vertices have a path between them
2) bfs(String source,String destination) :-BFS - Breadth First Search
3) dfs(String sorrce,String destination) :-DFS -  Depth First Search
4) bft() :-BFT - Breadth First Traversal
5) dft() :-DFT - Depth First traversal
6) isCyclic() :-Check if the graph is Cyclic
7) isConnected() :-Check if the graph is Connected
8) isTree() :-Check if the graph is a tree
