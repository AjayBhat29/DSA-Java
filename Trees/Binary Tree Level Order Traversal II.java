/* Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> al=new LinkedList<>();
        if(root==null)
            return al;
        LinkedList<TreeNode> q=new LinkedList<>();
        q.addLast(root);
        while(q.size()>0)
        {
            List<Integer> sub=new LinkedList<>();
            for(int i=0,size=q.size();i<size;i++)
            {
                TreeNode node=q.removeFirst();
                sub.add(node.val);
                if(node.left!=null)
                    q.addLast(node.left);
                if(node.right!=null)
                    q.addLast(node.right);
            }
            al.add(0,sub);
        }
        return al;
    }
}