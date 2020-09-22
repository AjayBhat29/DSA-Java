/* Sieve of Eratosthenes

Given a number N, calculate the prime numbers upto N using Sieve of Eratosthenes.  

Input: 
The first line of the input contains T denoting the number of testcases. T testcases follow. Each testcase contains one line of input containing N.

Output: 
For all testcases, in a new line, print all the prime numbers upto or equal to N.

Constraints:
1 <= T<= 100
1 <= N <= 104

Example:
Input:
2
10
35
Output:
2 3 5 7
2 3 5 7 11 13 17 19 23 29 31 */


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T-->0)
		{
		    int n=Integer.parseInt(br.readLine());
		    SOE(n);
		}
	}
	
	static void SOE(int n)
	{
	    boolean []primes=new boolean[n+1];

        
        for(int mult=2;mult*mult<=n;mult++)
        {
            if(!primes[mult])
            {
                for(int table=2;table*mult<=n;table++)
                {
                    primes[table*mult]=true;
                }
            }
        }
        
        StringBuilder ans=new StringBuilder();
        for(int i=2;i<=n;i++)
        {
            if(!primes[i])
                ans.append(i+" ");
        }
        
        System.out.println(ans);
	}
}