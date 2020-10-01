/* Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3. */

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode loop=head;
        ListNode prev=head;
        while(loop!=null && loop.next!=null)
        {
            ListNode temp=loop.next;
            loop.next=temp.next;
            temp.next=loop;
            if(prev!=head)
                prev.next=temp;
            if(loop==head)
                head=temp;
            prev=loop;
            loop=loop.next;
        }
        return head;
    }
}
