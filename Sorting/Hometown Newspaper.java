/* Rahul wants to create a newspaper. 
So he hires peoples who will help him collect the news. 
Rahul asks them to give the content C as a string, P the popularity value and D if the news is related to his hometown. 
As Rahul's newspaper is a local newspaper he would print the local news before others in decreasing order of the P popularity. 
Rest all news will be printed in decreasing order of popularity. 

Note - Popularity is distinct. 

Input format:
First line contains an integer T , where T is number of testcases. 
For every Testcase : 
First line contains N number of news items. 
Next N lines conatins three elements C ​- the content, P ￼ - popularity value and D - the
origin of news 0 or 1), 1 - if it is originated in the hometown else 0. 

Output format:
For every test case print, 
the N strings as it will be printed in Rahul's newspaper.

Constraints: 
1 <= T <= 70 
1 <= N <= 10^5 
0<= D <= 1 
1 <= P <= 10^5 

Time Limit:
1 second 

Example Input: 
1 
3 
News1 1 1
News2 2 0 
News3 4 1 

Output:
News3 
News1 
News2 

Explanation:
News3 and News1 are originated in the hometown so they will be printed first 
and News3 is more popular than News1 and then News2 will be printed. */

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
        int num=n;
        ArrayList<Triple> al=new ArrayList<>();
        while(num-->0)
        {
          StringTokenizer st=new StringTokenizer(br.readLine());
          String c=st.nextToken();
          int p=Integer.parseInt(st.nextToken());
          int d=Integer.parseInt(st.nextToken());
          Triple obj=new Triple(c,p,d);
          al.add(obj);
        }
        Collections.sort(al);
        StringBuilder a=new StringBuilder();
        StringBuilder b=new StringBuilder();
        for(int i=n-1;i>=0;i--)
        {
          Triple obj=al.get(i);
          if(obj.d==1)
          {
            a.append(obj.c);
            a.append("\n");
          }
          else
          {
            b.append(obj.c);
            b.append("\n");
          }
        }
        a.append(b);
        System.out.println(a);
      }
    }
  }
  
  class Triple implements Comparable<Triple> 
  {
    String c;
    int p;
    int d;
    Triple(String c,int p,int d)
    {
      this.c=c;
      this.p=p;
      this.d=d;
    }
    public int compareTo(Triple other)
    {
      return this.p-other.p;
    }
    public String toString()
    {
      return c+" "+p+" "+d;
    }
  }
