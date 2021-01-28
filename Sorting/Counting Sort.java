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
		countingSort(a);
		StringBuilder ans=new StringBuilder();
		for(int x: a)
			ans.append(x+" ");
		System.out.println(ans);
    }
	static void countingSort(int a[])
	{
		int k=Integer.MIN_VALUE;
		for(int x: a)
		{
			k=Math.max(k,x);
		}

		int count[]=new int[k+1];
		for(int i=0;i<a.length;i++)
		{
			count[a[i]]+=1;
		}
		for(int i=1;i<=k;i++)
		{
			count[i]=count[i]+count[i-1];
		}

		int sorted[]=new int[a.length];
		for(int i=a.length-1;i>=0;i--)
		{
			sorted[count[a[i]]-1]=a[i];
			count[a[i]]--;
		}
		for(int i=0;i<a.length;i++)
			a[i]=sorted[i];
	}
}
