/* Chef made N pieces of cakes, numbered them 1 through N and arranged them in a row in this order. There are K possible types of flavours (numbered 1 through K); for each valid i, the i-th piece of cake has a flavour Ai.

Chef wants to select a contiguous subsegment of the pieces of cake such that there is at least one flavour which does not occur in that subsegment. Find the maximum possible length of such a subsegment of cakes.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains two integers N and K.
The second line contains N space-separated integers A1,A2,…,AN.
Output
For each test case, print a single line containing one integer ― the maximum length of a valid subsegment.

In other words,
Given an array with values from 11 to KK, find the maximum length of a subarray which does not contain all K values.

Constraints
1≤T≤1,000
1≤N≤10^5
2≤K≤10^5
1≤Ai≤K for each valid i
the sum of N over all test cases does not exceed 10^6

Subtasks
Subtask #1 (50 points):
N≤10^3
K=2
the sum of N over all test cases does not exceed 10^4

Subtask #2 (50 points): original constraints

Example Input
2
6 2
1 1 1 2 2 1
5 3
1 1 2 2 1
Example Output
3
5 */

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
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(T-->0)
		{
		    st=new StringTokenizer(br.readLine());
		    int n=Integer.parseInt(st.nextToken());
		    int k=Integer.parseInt(st.nextToken());
		    st=new StringTokenizer(br.readLine());
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		        a[i]=Integer.parseInt(st.nextToken());
		    int max=-1;
		    int i=0;
		    int freq[]=new int[100001];
		    int different=0;
		    k=k-1;
		    int currentCount=0;
		    int previousElement=0;
		    for(i=0;i<n;i++)
		    {
		        freq[a[i]]++;
		        if(freq[a[i]]==1)
		            currentCount++;
		        while(currentCount>k)
		        {
		            freq[a[previousElement]]--;
		            if(freq[a[previousElement]]==0)
		                currentCount--;
		            previousElement++;
		        }
		        max=Math.max(max,i-previousElement+1);
		    }
		    System.out.println(max);
		}
	}
}
