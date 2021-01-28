import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) 
	{
        // Your Code Here
		Scanner scan=new Scanner(System.in);
		int n=0;
		if(scan.hasNextInt())
			n=scan.nextInt();
		int a[]=new int[n];
		int i;
		for(i=0;i<n;i++)
		{
			if(scan.hasNextInt())
				a[i]=scan.nextInt();
		}
		int []sorted=mergeSort(a,0,n-1);
		StringBuilder ans=new StringBuilder();
		for(int x: sorted)
			ans.append(x+" ");
		System.out.println(ans);
    }
	static int[]mergeSort(int a[],int lo,int hi)
	{
		if(lo==hi)
		{
			int br[]=new int[1];//br=base result
			br[0]=a[lo];
			return br;
		}
		int mid=(lo+hi)/2;
		int []fh=mergeSort(a,lo,mid);//fh=first half
		int []sh=mergeSort(a,mid+1,hi);//sh=second half
		int []sorted=mergeTwoArrays(fh,sh);
		return sorted;
	}
	static int[] mergeTwoArrays(int a[],int b[])
	{
		int []merged=new int[a.length+b.length];
		int i=0,j=0,k=0;
		while(i<a.length && j<b.length)
		{
			if(a[i]<=b[j])
			{
				merged[k++]=a[i++];
			}
			else
			{
				merged[k++]=b[j++];
			}
		}
		while(i<a.length)
		{
			merged[k++]=a[i++];
		}
		while(j<b.length)
		{
			merged[k++]=b[j++];
		}
		return merged;
	}
}