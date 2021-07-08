/* In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with n nodes (with distinct values from 1 to n), with one additional directed edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [ui, vi] that represents a directed edge connecting nodes ui and vi, where ui is a parent of child vi.

Return an edge that can be removed so that the resulting graph is a rooted tree of n nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

Example 1:
Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]

Example 2:
Input: edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
Output: [4,1]
 
Constraints:
n == edges.length
3 <= n <= 1000
edges[i].length == 2
1 <= ui, vi <= n
ui != vi */

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
//          1) Check whether there is a node having two parents. 
//              If so, store them as candidates A and B, and set the second edge invalid. 
//          2) Perform normal union find. 
//              If the tree is now valid  simply return candidate B
//              else if candidates not existing we find a circle, return current edge; 
//              else remove candidate A instead of B.
        
        //Step 1
        //Check for node having 2 parents
        int []candA=new int[]{-1,-1};
        int []candB=new int[]{-1,-1};
        
        int V=edges.length;
        int []parent=new int[V+1];
        for(int []edge:edges){
            if(parent[edge[1]]==0)
                parent[edge[1]]=edge[0];
            else{
                candA[0]=parent[edge[1]];
                candA[1]=edge[1];
                
                candB[0]=edge[0];
                candB[1]=edge[1];
                
                edge[1]=0;
            }
        }
        
        //Step 2
        makeSet(parent,V);
        for(int []edge:edges){
            if(edge[1]==0)continue;
            int u=edge[0],v=edge[1];
            if(findParent(u,parent)==findParent(v,parent)){
                if(candA[0]==-1)
                    return edge;
                else
                    return candA;
            }
            parent[v]=u;
        }
        return candB;
    }
    
    int findParent(int node,int []parent){
        if(node==parent[node])
            return node;
        parent[node]=findParent(parent[node],parent);
        return parent[node];
    }
    
    void makeSet(int []parent,int V){
        for(int i=0;i<=V;i++)
            parent[i]=i;
    }
}
