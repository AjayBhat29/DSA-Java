/* Ram and Shyam are sitting next to each other, hoping to cheat on an exam. However, the examination board has prepared p different sets of questions (numbered 0 through p−1), which will be distributed to the students in the following way:

The students are assigned roll numbers — pairwise distinct positive integers.
If a student's roll number is r, this student gets the ((r−1)%p)-th set of questions.
Obviously, Ram and Shyam can cheat only if they get the same set of questions.

You are given the roll numbers of Ram and Shyam: A and B respectively. Find the number of values of p for which they can cheat, or determine that there is an infinite number of such values.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first and only line of each test case contains two space-separated integers A and B.
Output
For each test case, print a single line — the number of values of p for which Ram and Shyam can cheat, or −1 if there is an infinite number of such values.

Constraints
1≤T≤100
1≤A,B≤10^8
Example Input
1
2 6
Example Output
3
Explanation
Example case 1: They can cheat for p=1, p=2 or p=4. */

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
		    int a=Integer.parseInt(st.nextToken());
		    int b=Integer.parseInt(st.nextToken());
		    int diff=Math.abs(a-b);
		    int count=0;
		    for(int i=1;i<=Math.sqrt(diff);i++)
		    {
		        if(diff%i==0)
		        {
		            if(diff/i==i)
		                count++;
		            else
		                count+=2;
		        }
		    }
		    System.out.println(count);
		}
	}
}
