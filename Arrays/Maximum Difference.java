/* You are given an array A consisting of N integers, you have to find the maximum value of the following expression:
|Ai−Aj| +|i−j| where,0<=i,j<N and Ai,Aj are the Array elements.

Input Format
The first line of input contains an integer T denoting the number of test cases.
Each test case contains two lines, the first line contains integer N where N is the number of elements in the array.
Second line contains N space separated integers Ai.

Output Format
Print the maximum value of the above given expression, for each test case separated by a new line.

Constraints
1≤T≤100
1≤N≤10^5
0≤Ai≤10^5

Note: Use Fast I/O (scanf/printf or any other ways) to handle large test files.

Time Limit
1 second

Example
Input
2
3
2 2 2
4
2 3 4 2
Output
2
4

Sample test case explanation
For the first sample case, if we choose i=0  and j=2; then we get the maximum value as 2.
In the second test case, if we choose i=0 and j=2, we get the maximum value as 4. */

import java.util.*;
import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      //write your code here
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      int T=Integer.parseInt(br.readLine());
      while(T-->0)
      {
        int n=Integer.parseInt(br.readLine());
        int a[]=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
          a[i]=Integer.parseInt(st.nextToken());
        int min1=Integer.MAX_VALUE;
        int max1=Integer.MIN_VALUE;
        int min2=Integer.MAX_VALUE;
        int max2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
          min1=Math.min(min1,a[i]+i);
          min2=Math.min(min2,-(a[i]-i));
          max1=Math.max(max1,a[i]+i);
          max2=Math.max(max2,-(a[i]-i));
        }
        System.out.println(Math.max(max1-min1,max2-min2));
      }
    }
  }
