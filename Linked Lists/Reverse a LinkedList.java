/*
 Reverse a Linked List
 */

 class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode next=null;
        ListNode prev=null;
        while(cur!=null)
        {
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
}