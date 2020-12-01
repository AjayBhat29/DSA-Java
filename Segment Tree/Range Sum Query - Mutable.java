/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
 

Constraints:

The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
0 <= i <= j <= nums.length - 1
*/

class NumArray {
    class Node{
        int startInterval;
        int endInterval;
        int data;
        Node left;
        Node right;
    }
    Node root;
    
    public NumArray(int[] nums) {
        if(nums.length==0)
            this.root=null;
        else
            this.root=constructTree(nums,0,nums.length-1);
    }
    private Node constructTree(int []arr,int si,int ei)
    {
        if(ei==si)
        {
            Node leafNode = new Node();
            leafNode.data=arr[si];
            leafNode.startInterval=si;
            leafNode.endInterval=ei;
            return leafNode;
        }
        
        Node node=new Node();
		node.startInterval=si;
		node.endInterval=ei; 

		int mid=(si+ei)/2;
		node.left=this.constructTree(arr,si,mid);
		node.right=this.constructTree(arr,mid+1,ei);

		node.data=node.left.data+node.right.data;
        
		return node;		
    }
    
    public void update(int i, int val) {
        this.root.data=this.update(this.root,i,val);
    }
    private int update(Node node,int index,int newValue)
	{
		if(index>=node.startInterval && index<=node.endInterval)
		{
			if(index==node.startInterval && index==node.endInterval)
				node.data=newValue;
			else
				node.data=update(node.left,index,newValue)+update(node.right,index,newValue);					
		}
		
		return node.data;	
	}
    
    public int sumRange(int i, int j) {
        return this.query(this.root,i,j);
    }
    private int query(Node node,int qsi,int qei)
	{
		//node is completely within query range
		if(node.startInterval>=qsi && node.endInterval<=qei)
			return node.data;

		//node is lying completely outside query range
		else if(node.endInterval<qsi || node.startInterval>qei)
			return 0;

		//overlapping case
		return query(node.left,qsi,qei)+query(node.right,qsi,qei);
	}
}