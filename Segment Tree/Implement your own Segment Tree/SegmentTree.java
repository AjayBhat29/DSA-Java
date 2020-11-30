import java.util.*;

public class SegmentTree
{
	private class Node
	{
		int data;
		int startInterval;
		int endInterval;
		Node left;
		Node right;
	}

	Node root;

	public SegmentTree(int arr[])
	{
		this.root=constructTree(arr,0,arr.length-1);
	}

	private Node constructTree(int []arr,int si,int ei)
	{
		if(si==ei)
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
		//using "+" operator because the Segment Tree calculates sum between any given range

		return node;		
	}

	public void display()
	{
		this.display(this.root);
	}
	private void display(Node node)
	{
		String str="";
		if(node.left!=null)
		{
			str=str+"Interval=["+node.left.startInterval+"-"+node.left.endInterval+"] and Data = "+node.left.data+"=> ";
		}
		else
		{
			str=str+"No Left Child => ";
		}
		str=str+"Interval=["+node.startInterval+"-"+node.endInterval+"] and Data = "+node.data;
		if(node.right!=null)
		{
			str=str+" <= data is = "+node.right.data+" and Interval = ["+node.right.startInterval+"-"+node.right.endInterval+"]";
		}
		else
		{
			str=str+" <= No Right Child";
		}

		System.out.println(str);

		if(node.left!=null)
			this.display(node.left);
		if(node.right!=null)
			this.display(node.right);
	}

	public int query(int qsi,int qei)
	{
		return this.query(this.root,qsi,qei);
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

	public void update(int index,int newValue)
	{
		this.root.data=this.update(this.root,index,newValue);
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
}