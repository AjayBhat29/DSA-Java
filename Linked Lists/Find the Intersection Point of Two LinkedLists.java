/* Write a program to find the node at which the intersection of two singly linked lists begins.
Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Each value on each linked list is in the range [1, 10^9].
Your code should preferably run in O(n) time and use only O(1) memory. */

//Brute
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)return null;
        ListNode temp1=headA;
        while(temp1!=null)
        {
            ListNode temp2=headB;
            while(temp2!=null)
            {
                if(temp2==temp1)
                    return temp2;
                temp2=temp2.next;
            }
            temp1=temp1.next;
        }
        return null;
    }
}

//Better
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)return null;
        Set<ListNode> hset=new HashSet<>();
        while(headA!=null){
            hset.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(hset.contains(headB))
                return headB;
            headB=headB.next;
        }
        return null;
    }
}

//Optimal 1
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)return null;
        
        int n1=0,n2=0;
        ListNode temp1=headA,temp2=headB;
        while(temp1!=null){
            n1++;
            temp1=temp1.next;
        }
        while(temp2!=null){
            n2++;
            temp2=temp2.next;
        }
        
        int dif=Math.abs(n1-n2);
        if(n1>n2)
            return findCommon(headA,headB,dif);
        else
            return findCommon(headB,headA,dif);
    }
    ListNode findCommon(ListNode big,ListNode small,int dif)
    {
        while(dif-->0)
            big=big.next;
        while(big!=small){
            big=big.next;
            small=small.next;
        }
        return big;
    }
}

//Optimal 2
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)return null;
        
        ListNode a=headA;
        ListNode b=headB;
        
        while(a!=b){
            a=a==null?headB:a.next;
            b=b==null?headA:b.next;
        }
        return a;
    }
}
