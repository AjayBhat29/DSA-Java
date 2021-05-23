/* Given the head of a linked list, return the list after sorting it in ascending order.

Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?

Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

Example 3:
Input: head = []
Output: []
 

Constraints:
The number of nodes in the list is in the range [0, 5 * 10^4].
-10^5 <= Node.val <= 10^5 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode mid=getMiddleNode(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return mergeLists(left,right);
    }
    ListNode getMiddleNode(ListNode head){
        ListNode prev_to_mid=null;
        while(head!=null && head.next!=null){
            prev_to_mid=(prev_to_mid==null)?head:prev_to_mid.next;
            head=head.next.next;
        }
        ListNode middle_node=prev_to_mid.next;
        prev_to_mid.next=null;
        return middle_node;
    }
    ListNode mergeLists(ListNode left,ListNode right){
        ListNode newHead=new ListNode();
        ListNode temp=newHead;
        while(left!=null && right!=null){
            if(left.val<right.val){
                temp.next=left;
                left=left.next;
                temp=temp.next;
            }
            else{
                temp.next=right;
                right=right.next;
                temp=temp.next;
            }
        }
        temp.next=(left==null)?right:left;
        return newHead.next;
    }
}
