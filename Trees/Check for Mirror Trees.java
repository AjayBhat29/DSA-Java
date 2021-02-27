/* Given the roots of 2 binary trees, check whether the trees are mirror of each other. 

Input format
The root of both the trees is passed to the checkMirrorTree().

Output format
Return true if the tree is the mirror image of another tree, else return false.


Example
Input
5 4 1 3 2 6 7 -1 -1 -1 -1 -1 -1 -1 -1
5 1 4 7 6 2 3 -1 -1 -1 -1 -1 -1 -1 -1

Note - Level order traversal of input trees, where −1 represents null nodes.

Output
true

*/


boolean checkMirrorTree(Node node1, Node node2) {
    //write your code here
    node1=invertBinaryTree(node1);
    return checkEqual(node1,node2);
}

Node invertBinaryTree(Node node){
  if(node==null)
    return null;
  Node r=invertBinaryTree(node.right);
  Node l=invertBinaryTree(node.left);
  node.left=r;
  node.right=l;
  return node;
}

boolean checkEqual(Node node1,Node node2){
  if(node1==null && node2==null)
    return true;
  if(node1==null && node2!=null)
    return false;
  if(node1!=null && node2==null)
    return false;
  if(node1.value!=node2.value)
    return false;
  return checkEqual(node1.left,node2.left) && checkEqual(node1.right,node2.right);
}
