/* Chef Aditi keeps changing the flavours of her dishes and she wants to analyse feedback from her customers in order to improve her performance. 
The customers visiting Aditi's restaurant can rate the food online and Aditi knows an aggregated rating for each day. 
As she is busy cooking, you should perform the data analysis.
You are given a sequence A1,A2,…,AN of distinct integers denoting the customers' feedback during N days. 
You should process Q queries. 
In each query, you are given two integers L and R. 
Consider any contiguous subsequence Ap,Ap+1,…,Aq, where L≤p<q≤R; let's call it a maximal increasing subsequence if the following conditions hold:
Ap<Ap+1…<Aq
if p>L, then Ap<Ap−1
if q<R, then Aq>Aq+1
Similarly, let's define a maximal decreasing subsequence. You should find out if the number of maximal increasing subsequences is equal to the number of maximal decreasing subsequences (with L≤p<q≤R).
For example, if A=(10,20,30,5), we can see that the only maximal increasing subsequence of this sequence (for L=1 and R=N) is (10,20,30), since (10,20) does not satisfy the third condition and (20,30) does not satisfy the second condition, and there is only one maximal decreasing subsequence (30,5).

Input
The first line of the input contains two space-separated integers N and Q.
The second line contains N space-separated integers A1,A2,…,AN.
Q lines follow. Each of these lines contains two space-separated integers L and R describing a query.
Output
For each query, print a single line containing the string "YES" if the number of maximal increasing contiguous subsequences is equal to the number of maximal decreasing contiguous subsequences or "NO" otherwise (without quotes).

Constraints
2≤N≤10^5
1≤Q≤10^5
1≤Ai≤10^9 for each valid i
1≤L<R≤N
A1,A2,…,AN are pairwise distinct
Subtasks
Subtasks #1 (20 points): Q≤50
Subtasks #2 (80 points): original constraints

Example Input 1
4 3
1 3 2 4
1 4
2 3
2 4
Example Output 1
NO
NO
YES
Explanation 1
For the first query, there are two maximal increasing subsequences (1,3) and (2,4), but only one maximal decreasing subsequence (3,2). */
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String []sizes=br.readLine().split(" ");
		int n=Integer.parseInt(sizes[0]);
		int q=Integer.parseInt(sizes[1]);
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a[]=new int[n+1];
		for(int i=1;i<=n;i++)
		    a[i]=Integer.parseInt(st.nextToken());
	    int incRange[]=new int[n+1];
	    Set<Integer> hset=new HashSet<>();
	    for(int i=2;i<=n;i++)
	    {
	        if(a[i-1]<a[i] && (i+1==n+1||a[i]>a[i+1]))
	        {
	            incRange[i]++;
	            hset.add(i);
	        }
	    }
	    for(int i=2;i<=n;i++)
	        incRange[i]=incRange[i]+incRange[i-1];
	    int decRange[]=new int[n+1];
	    for(int i=2;i<=n;i++)
	    {
	        if(a[i-1]>a[i] && (i+1==n+1||a[i]<a[i+1]))
	        {
	            decRange[i]++;
	            hset.add(i);
	        }
	    }
	    for(int i=2;i<=n;i++)
	        decRange[i]=decRange[i]+decRange[i-1];
	    while(q-->0)
	    {
	        st=new StringTokenizer(br.readLine());
	        int l=Integer.parseInt(st.nextToken());
	        int r=Integer.parseInt(st.nextToken());
	        if(hset.contains(r))
	        {
	            if(incRange[r]-incRange[l]==decRange[r]-decRange[l])
	                System.out.println("YES");
	            else
	                System.out.println("NO");
	        }
	        else
	        {
	            if(a[r]<a[r-1])
	            {
	                if(incRange[r]-incRange[l]==decRange[r]-decRange[l]+1)
	                    System.out.println("YES");
	                else
	                    System.out.println("NO");
	            }
	            else if(a[r]>a[r-1])
	            {
	                if(incRange[r]-incRange[l]+1==decRange[r]-decRange[l])
	                    System.out.println("YES");
	                else
	                    System.out.println("NO");
	            }
	        }
	    }
	}
}

