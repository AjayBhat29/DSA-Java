/* Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
] */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        LinkedList<List<Integer>> al=new LinkedList<>();// List of lists to be returned
        
        if(root==null)
            return al;
        
        LinkedList<TreeNode> q=new LinkedList<>();// Queue using Linked List
        q.addLast(root);

        while(!q.isEmpty())
        {
            LinkedList<Integer> sub=new LinkedList<>();// Subsidary LinkedList which will be added to al
            for(int i=0,size=q.size();i<size;i++)
            {
                TreeNode node=q.removeFirst();
                sub.add(node.val);
                if(node.left!=null)
                    q.addLast(node.left);
                if(node.right!=null)
                    q.addLast(node.right);
            }
            al.add(sub);
        }
        return al;
    }
}