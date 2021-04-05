/* Given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the array. The next line contains n space separated integers forming the array. The last line contains the window size k.

Output:
For each testacase, in a new line, print the space separated negative integer starting from the first till the end for every window size k. If a window does not contain a negative integer , then print 0 for that window.

Constraints:
1<=T<=10^5
1<=n<=10^5
1<=a[i]<=10^5
1<=k<=n

Example:
Input:
2
5
-8 2 3 -6 10
2
8
12 -1 -7 8 -15 30 16 28
3

Output:
-8 0 -6 -6
-1 -1 -7 -15 -15 0 
Explanation: For the first subarray, there is -8.
For the second subarray there is no negative
element, so the answer is zero. Similiarly,
the answer is -6 for the next two subarrays. */

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder ans=new StringBuilder();
		while(T-->0)
		{
		    int n=Integer.parseInt(br.readLine());
		    st=new StringTokenizer(br.readLine());
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		        a[i]=Integer.parseInt(st.nextToken());
		    int k=Integer.parseInt(br.readLine());
		    int []sol=firstNegative(a,k);
		    for(int x: sol)
		        ans.append(x+" ");
		    ans.append("\n");
		}
		System.out.print(ans);
	}
	
	static int[] firstNegative(int arr[],int k)
	{
	      int n = arr.length;
        int sol[] = new int[n - k + 1];
        LinkedList<Integer> q = new LinkedList<>();
        int i = 0,j = 0,h = 0;
        while(j < n)
        {
            if(arr[j] < 0)
                q.addLast(arr[j]);
                
            if(j - i + 1 < k)
                j++;
            else
            {
                if(q.isEmpty())
                    sol[h++] = 0;
                else
                {
                    sol[h++] = q.getFirst();
                    if(arr[i] == q.getFirst())
                        q.removeFirst();
                }
                i++;
                j++;
            }
        }
        return sol;
	}
}
