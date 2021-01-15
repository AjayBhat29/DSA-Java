/* You are given a string s and should process m queries. Each query is described by two 1-based indices li, ri and integer ki. It means that you should cyclically shift the substring s[li... ri] ki times. 
The queries should be processed one after another in the order they are given.

One operation of a cyclic shift (rotation) is equivalent to moving the last character to the position of the first character and shifting all other characters one position to the right.
For example, if the string s is abacaba and the query is l1 = 3, r1 = 6, k1 = 1 then the answer is abbacaa. If after that we would process the query l2 = 1, r2 = 4, k2 = 2 then we would get the string baabcaa.

Input
The first line of the input contains the string s (1 ≤ |s| ≤ 10 000) in its initial state, where |s| stands for the length of s. It contains only lowercase English letters.

Second line contains a single integer m (1 ≤ m ≤ 300) — the number of queries.

The i-th of the next m lines contains three integers li, ri and ki (1 ≤ li ≤ ri ≤ |s|, 1 ≤ ki ≤ 1 000 000) — the description of the i-th query.

Output
Print the resulting string s after processing all m queries.

Examples

input:
abacaba
2
3 6 1
1 4 2

output:
baabcaa */

import java.util.*;
import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      //write your code here
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      String s=br.readLine();
      int m=Integer.parseInt(br.readLine());
      while(m-->0)
      {
        char a[]=s.toCharArray();
        StringTokenizer st=new StringTokenizer(br.readLine());
        int l=Integer.parseInt(st.nextToken());
        int r=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        StringBuilder ans=new StringBuilder();
        l--;
        r--;
        ans.append(s.substring(0,l));
        int n=r-l+1;
        k=k%n;
        reverse(l,r-k,a);
        reverse(r-k+1,r,a);
        reverse(l,r,a);
        for(int i=l;i<=r;i++)
          ans.append(a[i]);
        ans.append(s.substring(r+1));
        s=ans.toString();
      }
      System.out.println(s);
    }
    static void reverse(int start,int end,char a[])
    {
      while(start<end)
      {
        char temp=a[start];
        a[start]=a[end];
        a[end]=temp;
        start++;
        end--;
      }
    }
  }