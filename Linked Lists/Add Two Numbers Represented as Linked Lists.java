/* You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself. */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int sum=0,carry=0;
        ListNode temp=null,prev=null,result=null;
        while(l1!=null || l2!=null)
        {
            sum=carry+(l1==null?0:l1.val)+(l2==null?0:l2.val);
            carry=sum>=10?1:0;
            sum=sum%10;
            temp=new ListNode(sum);
            if(result==null)
                result=temp;
            else
                prev.next=temp;
            prev=temp;
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
        }
        if(carry>0)
            temp.next=new ListNode(carry);
        return result;
    }   
}