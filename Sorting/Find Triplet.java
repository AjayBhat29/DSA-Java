/* Given an array of integers you have to find three numbers such that sum of two elements equals the third element.

Input Format:
First line contains an integer T, number of test cases. 
Then follows T test cases. 
Each test case consists of two lines.
First-line contains N
Second lines contains N space-separated integers A[i].

Output Format:
Print T lines, each containing the three space-separated integers 
n1,n2,n3 such that 
n1=n2+n3 and n3>n2.
If no such triplet exists simply print −1.

If multiple such triplets exist print the one with maximum n1 value. 
For a condition such that, n1=n2+n3 ,n1′=n2′+n3′ and 
n1=n1′ && n3>n3′
print (n1,n2,n3).

Constraints:
1<=T<=10
1<=N<=5∗10^4
1<=A[i]<=10^6

Time Limit
1.5 second

Example:
Input:
2
5
20 40 30 50 70
4
29 15 13 30

Output:
70 20 50
-1        */

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
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a[]=new int[n];
        for(int i=0;i<n;i++)
          a[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(a);
        int n1=-1,n2=-1,n3=-1;
        int I=0,J=n-2,k=n-1;
        while(I<J && J<k)
        {
          int target=a[k];
          int i=I,j=J;
          while(i<j)
          {
            if(a[i]+a[j]==target)
            {
              n1=target;
              n2=a[i];
              n3=a[j];
              break;
            }
            else if(a[i]+a[j]<target)
            {
              i++;
            }
            else
            {
              j--;
            }
          }
          if(n1!=-1)
          {
            break;
          }
          else
          {
            I=0;
            J--;
            k--;
          }
        }
        if(n1!=-1)
        {
          System.out.println(n1+" "+n2+" "+n3);
        }
        else
        {
          System.out.println(-1);
        }
      }
    }
  }
