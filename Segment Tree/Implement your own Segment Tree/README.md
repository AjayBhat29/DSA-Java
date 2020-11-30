Representation of Segment trees
1. Leaf Nodes are the elements of the input array.
2. Each internal node represents some merging of the leaf nodes. The merging may be different for different problems. For this problem, merging is sum of leaves under a node.

How does above segment tree look in memory?
Like Heap, the segment tree is also represented as an array. 
The difference here is, it is not a complete binary tree. It is rather a full binary tree (every node has 0 or 2 children) and all levels are filled except possibly the last level. 
Unlike Heap, the last level may have gaps between nodes. 

Query for Sum of given range:
Once the tree is constructed, how to get the sum using the constructed segment tree. 
The following is the algorithm to get the sum of elements.

int getSum(node, l, r) 

{

   if the range of the node is within l and r
        return value in the node
        
   else if the range of the node is completely outside l and r
        return 0
   
   else
    return getSum(node's left child, l, r) + 
           getSum(node's right child, l, r)

}

Update a value:
Like tree construction and query operations, the update can also be done recursively. 
We are given an index which needs to be updated. Let diff be the value to be added. 
We start from the root of the segment tree and add diff to all nodes which have given index in their range. 
If a node doesn’t have a given index in its range, we don’t make any changes to that node.

Time Complexity:
Time Complexity for tree construction is O(n). There are total 2n-1 nodes, and value of every node is calculated only once in tree construction.

Time complexity to query is O(Logn). To query a sum, we process at most four nodes at every level and number of levels is O(Logn).

The time complexity of update is also O(Logn). To update a leaf value, we process one node at every level and number of levels is O(Logn).
