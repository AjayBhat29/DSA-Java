/* Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---  */

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> al=new LinkedList<>();
        if(root==null)
            return al;
            
        LinkedList<TreeNode> q=new LinkedList<>();
        q.addLast(root);
        int right=0;
        while(q.size()>0)
        {
            for(int i=0,size=q.size();i<size;i++)
            {
                TreeNode node=q.removeFirst();
                right=node.val;
                if(node.left!=null)
                    q.addLast(node.left);
                if(node.right!=null)
                   q.addLast(node.right);
            }
            al.add(right);
        }
        return al;
    }
}