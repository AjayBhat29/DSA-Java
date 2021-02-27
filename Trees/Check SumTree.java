
/* A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in the left subtree and right subtree. You are given a binary tree and the task is to return true (1 in case of C language) if given binary tree is SumTree else return false(0 in case of C language). 

Note :-
You have to complete checkSumTree() function, no need to implement the tree.
Consider empty tree as sumTree with sum=0.
Consider leaf nodes as sumTree.

Input format
Root of the tree is passed to the checkSumTree().
And the tree is constructed in level order format.

Output format
Return true(1 in case of C language) if given binary tree is SumTree else return false(0 in case of C language). */



boolean checkSumTree(Node node) {
    //write your code here
    if(node == null || (node.left == null && node.right == null))
      return true;
    long leftSum=findSum(node.left);
    long rightSum=findSum(node.right);
    return node.value==leftSum+rightSum && checkSumTree(node.left) && checkSumTree(node.right);
}
long findSum(Node node)
{
  if(node==null)
    return 0;
  return findSum(node.left)+findSum(node.right)+node.value;
}






