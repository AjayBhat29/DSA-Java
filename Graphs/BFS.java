/* Given a directed graph. The task is to do Breadth First Search of this graph.

Input:
The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test case consists of two lines. Description of testcases is as follows: The First line of each test case contains two integers 'N' and 'E'  which denotes the no of vertices and no of edges respectively. The Second line of each test case contains 'E'  space separated pairs u and v denoting that there is a edge from u to v .

Output:
For each testcase, print the BFS of the graph starting from 0.

Note: The expected output button always produces BFS starting from node 0.

User Task:
You don't need to read input or print anything. Your task is to complete the function bfs() takes the Graph and the number of vertices as its input and returns a list containing the BFS traversal of the graph starting from the 0th vertex.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).

Constraints:
1 <= T <= 100
2 <= N <= 104
1 <= E <= (N*(N-1))/2
Graph doesn't contain multiple edges and self loops.

Example:
Input:
2
5 4
0 1 0 2 0 3 2 4
3 2
0 1 0 2

Output:
0 1 2 3 4    // BFS from node 0
0 1 2

Explanation:
Testcase 1: 
0 is connected to 1 , 2 , 3
2 is connected to 4
so starting from 0 , bfs will be 0 1 2 3 4. */

class Traversal {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        // add your code here
        ArrayList<Integer> al=new ArrayList<>();
        Set<Integer> visited=new HashSet<>();
        LinkedList<Integer> queue=new LinkedList<>();
        
        //source node is 0
        queue.addLast(0);
        visited.add(0);
        
        //while queue is not empty
        while(!queue.isEmpty())
        {
            int v=queue.removeFirst();
            al.add(v);
            //going to all neighbours of v
            for(int x: g.get(v))
            {
                if(!visited.contains(x))
                {
                    queue.addLast(x);
                    visited.add(x);
                }
            }
        }
        return al;
    }
}