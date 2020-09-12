/*
Remove Nth end from end of Linked List 
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head;
        ListNode second=head;
        int count=0;
        while(count<n)
        {
            if(second.next==null)
            {
                if(count==n-1)
                    head=head.next;
                return head;
            }
            count++;
            second=second.next;
        }
        while(second.next!=null)
        {
            second=second.next;
            first=first.next;
        }
        first.next=first.next.next;
        return head;
    }
}