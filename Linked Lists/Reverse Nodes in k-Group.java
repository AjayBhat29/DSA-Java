/* Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed. */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead=new ListNode(-1);
        ListNode prv=newHead;
        
        while(head!=null)
        {
            ListNode ptr=head;
            int count=0;
            
            while(count<k && ptr!=null)
            {
                ptr=ptr.next;
                count++;
            }
            
            if(count==k)
            {
                ListNode reversedHead=reverse(head,k);
                prv.next=reversedHead;
                prv=head;
            }
            else
            {
                prv.next=head;
            }
            
            head=ptr;
        }
        return newHead.next;
    }
    
    public ListNode reverse(ListNode head,int k)
    {
        ListNode cur=head;
        ListNode prev=null;
        ListNode next=null;
        while(k-->0 && cur!=null)
        {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}