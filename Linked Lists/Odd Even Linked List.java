/* Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
 

Constraints:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
The length of the linked list is between [0, 10^4]. */


class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
            return null;
        ListNode oddHead=head;
        ListNode evenHead=head.next;
        ListNode temp1=oddHead;
        ListNode temp2=evenHead;
        while(temp2!=null && temp2.next!=null)
        {
            temp1.next=temp2.next;
            temp1=temp1.next;
            temp2.next=temp1.next;
            temp2=temp2.next;
        }
        temp1.next=evenHead;
        return oddHead;
    }
}