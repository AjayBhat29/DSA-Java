/* Chef is becoming bored with the recent lockdown caused by the coronavirus outbreak. To pass some time, he has started learning cryptography. He is very excited to see different types of keys used in cryptography and decided to invent a new type of a key.

First, Chef made a sequence of integers A1,A2,…,AN, which lie between 1 and M inclusive. After a lot of sleepless nights, he has decided that his key will be the LCM of this sequence, but he is not satisfied ― he wants to make his key as large as possible. In order to do that, he wants to append exactly one more integer to the sequence. This integer must also lie between 1 and M inclusive.

Help Chef maximise the key. Find the integer which Chef should append to the sequence in order to make the key (the LCM of elements of the resulting sequence) as large as possible. If there are multiple solutions, choose the smallest among the integers to append which maximise the LCM.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains two space-separated integers N and M.
The second line contains N space-separated integers A1,A2,…,AN.
Output
For each test case, print a single line containing one integer ― the smallest value of the new element which maximises the LCM.

Constraints
1≤T≤100
1≤N,M≤10^4
1≤Ai≤M for each valid i

Subtasks
Subtask #1 (50 points): N,M≤10^2
Subtask #2 (50 points): original constraints

Example Input
2
3 2
2 1 2
4 7
2 5 6 3
Example Output
1
7 */

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
		    int m=Integer.parseInt(st.nextToken());
		    st=new StringTokenizer(br.readLine());
            int freq[]=new int[m+1];
            for(int i=0;i<n;i++)
            {
                int element=Integer.parseInt(st.nextToken());
                for(int j=2;j<=Math.sqrt(element);j++)
                {
                    if(element%j==0)
                    {
                        int powerCount=0;
                        while(element%j==0)
                        {
                            element=element/j;
                            powerCount++;
                        }
                        freq[j]=Math.max(freq[j],powerCount);
                    }
                }
                if(element!=1)
                    freq[element]=Math.max(freq[element],1);
            }
            int value=1;
            int maxValue=1;
            for(int i=2;i<=m;i++)
            {
                int element=i;
                int localMax=1;
                for(int j=2;j<=Math.sqrt(element);j++)
                {
                    if(element%j==0)
                    {
                        int powerCount=0;
                        while(element%j==0)
                        {
                            element=element/j;
                            powerCount++;
                        }
                        if(powerCount>freq[j])
                        {
                            localMax=localMax*(int)Math.pow(j,powerCount-freq[j]);
                        }
                    }
                }
                if(element!=1 && freq[element]==0)
                {
                    localMax=localMax*element;
                }
                if(localMax>maxValue)
                {
                    maxValue=localMax;
                    value=i;
                }
            }
            System.out.println(value);
		}
	}
}
