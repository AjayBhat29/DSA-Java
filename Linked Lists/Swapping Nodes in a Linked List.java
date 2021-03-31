/* You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

Example 2:
Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]

Example 3:
Input: head = [1], k = 1
Output: [1]

Example 4:
Input: head = [1,2], k = 1
Output: [2,1]

Example 5:
Input: head = [1,2,3], k = 2
Output: [1,2,3]

Constraints:
The number of nodes in the list is n.
1 <= k <= n <= 10^5
0 <= Node.val <= 100 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null || head.next==null)return head;
        
        ListNode a=head;
        ListNode tort1=head,tort2=head;
        int count=0;
        while(a!=null && tort2!=null){
            tort2=tort2.next;
            count++;
            if(count==k)
                break;
            a=a.next;
        }
        while(tort2!=null){
            tort1=tort1.next;
            tort2=tort2.next;
        }
        int t=tort1.val;
        tort1.val=a.val;
        a.val=t;
        return head;
    }
}
