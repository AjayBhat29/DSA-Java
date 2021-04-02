/* Design a queue that supports push and pop operations in the front, middle, and back.

Implement the FrontMiddleBack class:

FrontMiddleBack() Initializes the queue.
void pushFront(int val) Adds val to the front of the queue.
void pushMiddle(int val) Adds val to the middle of the queue.
void pushBack(int val) Adds val to the back of the queue.
int popFront() Removes the front element of the queue and returns it. If the queue is empty, return -1.
int popMiddle() Removes the middle element of the queue and returns it. If the queue is empty, return -1.
int popBack() Removes the back element of the queue and returns it. If the queue is empty, return -1.
Notice that when there are two middle position choices, the operation is performed on the frontmost middle position choice. For example:
Pushing 6 into the middle of [1, 2, 3, 4, 5] results in [1, 2, 6, 3, 4, 5].
Popping the middle from [1, 2, 3, 4, 5, 6] returns 3 and results in [1, 2, 4, 5, 6].

Example 1:
Input:
["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
[[], [1], [2], [3], [4], [], [], [], [], []]
Output:
[null, null, null, null, null, 1, 3, 4, 2, -1]

Explanation:
FrontMiddleBackQueue q = new FrontMiddleBackQueue();
q.pushFront(1);   // [1]
q.pushBack(2);    // [1, 2]
q.pushMiddle(3);  // [1, 3, 2]
q.pushMiddle(4);  // [1, 4, 3, 2]
q.popFront();     // return 1 -> [4, 3, 2]
q.popMiddle();    // return 3 -> [4, 2]
q.popMiddle();    // return 4 -> [2]
q.popBack();      // return 2 -> []
q.popFront();     // return -1 -> [] (The queue is empty)
 
Constraints:
1 <= val <= 10^9
At most 1000 calls will be made to pushFront, pushMiddle, pushBack, popFront, popMiddle, and popBack. */

class FrontMiddleBackQueue {
    private class Node{
        Node next;
        int val;
        Node(int val)
        {
            this.val=val;
            this.next=null;
        }
    }
    Node head;
    Node tail;
    int size;
    public FrontMiddleBackQueue() {
        size=0;head=null;tail=null;
    }
    
    public void pushFront(int val) {
        Node nn=new Node(val);
        size++;
        if(head==null){
            head=nn;tail=nn;
            return;
        }
        nn.next=head;
        head=nn;
    }
    
    public void pushMiddle(int val) {
        if(size<=1)
        {
           pushFront(val);
           return;
        }
        Node temp=head;
        for(int i=1;i<size/2;i++)
            temp=temp.next;
        Node nn=new Node(val);
        nn.next=temp.next;
        temp.next=nn;
        size++;
    }
    
    public void pushBack(int val) {
        Node nn=new Node(val);
        size++;
        if(tail==null){
            head=nn;
            tail=nn;
            return;
        }
        tail.next=nn;
        tail=tail.next;
    }
    
    public int popFront() {
        if(size<=0)
            return -1;
        int val=head.val;
        head=head.next;
        size--;
        if(size==0)
            head=tail=null;
        return val;
    }
    
    public int popMiddle() {
        if(size<=0)
            return -1;
        if(size<=2)
            return popFront();
        Node temp=head;
        Node prev=null;
        for(int i=1;i<size/2;i++)
        {
            prev=temp;
            temp=temp.next;
        }
        if(size%2!=0)
        {
            int val=temp.next.val;
            temp.next=temp.next.next;
            size--;
            if(size==0)
                head=tail=null;
            return val;
        }
        else
        {
            int val=prev.next.val;
            prev.next=prev.next.next;
            size--;
            if(size==0)
                head=tail=null;            
            return val;
        }
    }
    
    public int popBack() {
        if(size<=0)
            return -1;
        int val=tail.val;
        Node temp=head;
        for(int i=1;i<size-1;i++)
            temp=temp.next;
        temp.next=null;
        tail=temp;
        size--;
        if(size==0)
            head=tail=null;
        return val;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
