/*
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
*/

class Solution {
    public void deleteNode(ListNode node) {
            int x=node.next.val;
            node.val=x;
            node.next=node.next.next;
    }
}