/* When Varsha was travelling home, she saw a mysterious villa. Varsha is curious about this strange villa and wants to explore it. When she reached the entry gate, the guard gave her a problem to solve and said that he would allow her to enter the villa only if she solved it.

The guard gave Varsha two integers X and K. Varsha needs to determine whether there is an integer A such that it has exactly X positive integer divisors and exactly K of them are prime numbers.

Varsha found this problem really hard to solve. Can you help her?

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first and only line of each test case contains two space-separated integers X and K.
Output
For each test case, print a single line containing one integer: 1 if a valid integer A exists or 0 if it does not exist.

Constraints
1≤T≤10^3
1≤X,K≤10^9

Subtasks
Subtask #1 (15 points):

T≤100
K≤2
Subtask #2 (85 points): original constraints

Example Input
1
4 2
Example Output
1
Explanation
Example case 1: A=6 has X=4 factors: 1, 2, 3 and 6. It also has exactly K=2 prime factors: 2 and 3. */

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
		    int x=Integer.parseInt(st.nextToken());
		    int k=Integer.parseInt(st.nextToken());
		    System.out.println(countDivisors(x,k));
		}
	}
	static int countDivisors(int x,int k)
    {
        int count=0;
        while(x%2==0)
        {
            x/=2;
            count++;
        }
        for(int i=3;i<=Math.sqrt(x);i++)
        {
            while(x%i==0)
            {
                x/=i;
                count++;
            }
        }
        if(x>2)
            count++;
        if(count<k)
            return 0;
        return 1;
    }
}
