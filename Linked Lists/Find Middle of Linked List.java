/*
Find Middle Node of Linked List
*/

//Method 1
class Solution {
    public ListNode middleNode(ListNode head) {
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int mid=count/2+1;
        temp=head;
        while(temp!=null && mid-->1)
            temp=temp.next;
        return temp;
    }
}

//Method 2
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
        
    }
}
