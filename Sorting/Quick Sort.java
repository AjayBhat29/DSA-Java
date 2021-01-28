import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
		Scanner scan=new Scanner(System.in);
		int n=0;
		if(scan.hasNextInt())
			n=scan.nextInt();
		int a[]=new int[n];
		int i=0;
		for(i=0;i<n;i++)
			a[i]=scan.nextInt();
		quickSort(a,0,n-1);
		StringBuilder ans=new StringBuilder();
		for(int x: a)
			ans.append(x+" ");
		System.out.println(ans);
    }
	static void quickSort(int a[],int lo,int hi)
	{
		if(lo>=hi)
		{
			return;
		}
		int mid=(lo+hi)/2;
		int pivot=a[mid];
		int left=lo;
		int right=hi;
		while(left<=right)
		{
			while(a[left]<pivot)
				left++;
			while(pivot<a[right])
				right--;
			if(left<=right)
			{
				int temp=a[left];
				a[left]=a[right];
				a[right]=temp;
				left++;
				right--;
			}
		}
		quickSort(a,lo,right);
		quickSort(a,left,hi);
	}
}