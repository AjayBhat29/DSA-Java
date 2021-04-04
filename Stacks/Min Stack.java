/* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

Methods pop, top and getMin operations will always be called on non-empty stacks. */

//-----------------------------------------------------------------------------------
// Method 1 - Using O(n) extra space (Using Supporting Stack)

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> main_stack;
    Stack<Integer> supporting_stack;
    public MinStack() {
        main_stack = new Stack<>();
        supporting_stack = new Stack<>();
    }
    
    public void push(int val) {
        main_stack.push(val);
        if(supporting_stack.empty() || val<=supporting_stack.peek())
            supporting_stack.push(val);
            
    }
    
    public void pop() {
        if(main_stack.size()==0)
            return;
        int ans=main_stack.pop();
        if(ans==supporting_stack.peek())
            supporting_stack.pop();
    }
    
    public int top() {
        if(main_stack.size()==0)
            return -1;//stack empty
        return main_stack.peek();
    }
    
    public int getMin() {
        if(supporting_stack.size()==0)
            return -1;//supporting stack empty
        return supporting_stack.peek();
    }
}
//-----------------------------------------------------------------------
//Method 2 - Using single stack of data type Pair

class MinStack {

    /** initialize your data structure here. */
    Stack<Pair> stack;
    public MinStack() {
        stack=new Stack<>();
    }
    
    public void push(int val) {
        int min=val;
        if(!stack.empty())
            min=Math.min(min,stack.peek().min);
        stack.push(new Pair(val,min));
    }
    
    public void pop() {
        if(!stack.empty())
            stack.pop();
    }
    
    public int top() {
        if(!stack.empty())
            return stack.peek().val;
        else
            return -1;
    }
    
    public int getMin() {
        if(!stack.empty())
            return stack.peek().min;
        else
            return -1;
    }
}

class Pair
{
    int val;
    int min;
    public Pair(int val,int min)
    {
        this.val=val;
        this.min=min;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
