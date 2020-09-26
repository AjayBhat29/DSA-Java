/* Given a singly linked list, determine if it is a palindrome. */


class Solution {
    public boolean isPalindrome(ListNode head) 
    {
        ListNode slow=head;
        ListNode fast=head;
        ListNode first=head;// pointer to check from beginning
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode last=reverse(slow);//pointer to check from end
        while(first!=null && last!=null)
        {
            if(first.val!=last.val)
                return false;
            first=first.next;
            last=last.next;
        }
        return true;
    }
    static ListNode reverse(ListNode head)
    {
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