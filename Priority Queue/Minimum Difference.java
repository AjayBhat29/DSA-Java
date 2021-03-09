/* Gurugram is divided into many sectors and each sector is represented by a number. 
Given N sectors and two integers P and Q, your task is to find Q closest sectors to sector. 

Input Format
The first line contains an integer T representing the number of test cases.
For each test case:
The first line contains an integer N denoting the number of sectors and two integers P and Q.
The second line contains N space-separated integers representing the sector numbers.

Note - Use heap concepts to solve the problem.

Output Format
For each test case print the Q closest sectors to P sector in descending order.

Constraints
1<=T<=10
1<=(Q,P)<=N<=10^5
1<=A[i]<=10^6

Time Limit
1 second

Example
Sample Input
2
7 3 3
48 17 3 36 10 21 4
7 5 3
40 3 23 42 34 8 17

Sample Output
10 4 3 
17 8 3

Sample test case explanation
In the second test case 
3 closest sectors to sector 5 are [3 8 17] which are printed in descending order. */

import java.util.*;
  import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      //write your code here
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      int T=Integer.parseInt(br.readLine());
      StringTokenizer st;
      StringBuilder ans=new StringBuilder();
      PriorityQueue<Pair> pq;
      while(T-->0)
      {
        st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int p=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int a[]=new int[n];
        pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++)
          a[i]=Integer.parseInt(st.nextToken());
        for(int i=0;i<q;i++)
        {
          int val=Math.abs(a[i]-p);
          pq.add(new Pair(val,i));
        }
        for(int i=q;i<n;i++)
        {
          int dif=Math.abs(a[i]-p);
          Pair peek_ele=pq.peek();
          if(dif<peek_ele.value)
          {
            pq.remove();
            pq.add(new Pair(dif,i));
          }
        } 
        while(!pq.isEmpty())
        {
          Pair rem=pq.remove();
          ans.append(a[rem.index]+" ");
        }
        ans.append("\n");
      }
      System.out.print(ans);
    }
  }
  class Pair implements Comparable<Pair>
  {
    int value;
    int index;
    
    public Pair(int v,int in)
    {
      value=v;
      index=in;
    }
    
    public int compareTo(Pair other)
    {
      return this.value-other.value;
    }
  }
