/*
Merge Two Sorted Linked Lists
*/

//Recursive Method
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        if(l1.val<=l2.val)
        {
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }
        else
        {
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }        
    }
}

//O(n1+n2) time and O(n1+n2) space
Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode temp=head;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                ListNode nn=new ListNode(l1.val);
                nn.next=null;
                temp.next=nn;
                temp=temp.next;
                l1=l1.next;
            }
            else{
                ListNode nn=new ListNode(l2.val);
                nn.next=null;
                temp.next=nn;
                temp=temp.next;
                l2=l2.next;
            }
        }
        while(l1!=null){
            ListNode nn=new ListNode(l1.val);
            nn.next=null;
            temp.next=nn;
            temp=temp.next;
            l1=l1.next;
        }
        while(l2!=null){
            ListNode nn=new ListNode(l2.val);
            nn.next=null;
            temp.next=nn;
            temp=temp.next;
            l2=l2.next;
        }
        return head.next;
    }
}

//O(n1+n2) time and O(1) space
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        
        if(l1.val>l2.val){
            ListNode t=l1;
            l1=l2;
            l2=t;
        }
        
        ListNode res=l1;
        ListNode temp=null;
        while(l1!=null && l2!=null){
            temp=null;//temp is to store the  previous node pointer
            while(l1!=null && l1.val<=l2.val){
                temp=l1;
                l1=l1.next;
            }
            //change the pointer to closest higher value node
            temp.next=l2;
            
            //swap
            ListNode t=l1;
            l1=l2;
            l2=t;
        }
        return res;
    }
}
