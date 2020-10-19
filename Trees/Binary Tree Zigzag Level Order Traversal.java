/*Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]*/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> al=new LinkedList<>();
        if(root==null)
            return al;
        LinkedList<TreeNode> q=new LinkedList<>();
        q.addLast(root);
        boolean flag=true;
        while(q.size()>0)
        {
            LinkedList<Integer> sub=new LinkedList<>();
            for(int i=0,size=q.size();i<size;i++)
            {
                TreeNode node=q.removeFirst();
                if(flag)
                    sub.addLast(node.val);
                else
                    sub.addFirst(node.val);
                if(node.left!=null)
                    q.addLast(node.left);
                if(node.right!=null)
                    q.addLast(node.right);
            }
            al.add(sub);
            flag=!flag;
        }
        return al;
    }
}
