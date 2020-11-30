import java.util.*;

class SegmentTreeMain
{
	public static void main(String[] args) 
	{
		int arr[]={3,8,7,6,-2,-8,4,9};
		SegmentTree tree=new SegmentTree(arr);
		tree.display();
		System.out.println("************");
		System.out.println("Sum is = "+tree.query(2,6));

		tree.update(3,14);
		tree.display();
		System.out.println("Sum is = "+tree.query(2,6));		
	}
}