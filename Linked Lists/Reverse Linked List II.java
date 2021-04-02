/* Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:
The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n */

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null)return head;
        ListNode prev=null,cur=head;
        while(m>1){
            prev=cur;
            cur=cur.next;
            m--;n--;
        }
        
        ListNode connection=prev,tail=cur;
        
        ListNode next=null;
        while(n>0){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
            n--;
        }
        
        if(connection==null)
            head=prev;
        else
            connection.next=prev;
        tail.next=cur;
        return head;
    }
}
