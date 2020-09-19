/* Write a program to find the node at which the intersection of two singly linked lists begins.
Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Each value on each linked list is in the range [1, 10^9].
Your code should preferably run in O(n) time and use only O(1) memory. */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1=headA;
        ListNode t2=headB;
        int len1=0,len2=0;
        while(t1!=null)
        {
            t1=t1.next;
            len1++;
        }
        while(t2!=null)
        {
            t2=t2.next;
            len2++;
        }
        int d=Math.abs(len1-len2);
        if(len1>len2)
        {
            for(int i=0;i<d;i++)
                headA=headA.next;
        }
        else
        {
            for(int i=0;i<d;i++)
                headB=headB.next;
        }
        while(headA!=null && headB!=null)
        {
            if(headA==headB)
                return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}