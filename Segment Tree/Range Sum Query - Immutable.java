/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int i, int j) Return the sum of the elements of the nums array in the range [i, j] inclusive (i.e., sum(nums[i], nums[i + 1], ... , nums[j]))
 

Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 

Constraints:

0 <= nums.length <= 104
-105 <= nums[i] <= 105
0 <= i <= j < nums.length
At most 104 calls will be made to sumRange.
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