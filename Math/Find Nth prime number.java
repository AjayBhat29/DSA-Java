/* Given a number N. Print the Nth prime number 

Input format
First-line contains integer T, denoting the number of test cases.
For each test case, an integer N is provided.

Output format
For each test case on a new line, print the Nth prime number.

Example
Input
3
2
3
4

Output
3
5
7 */

import java.util.*;
import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      //write your code here
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      int T=Integer.parseInt(br.readLine());
      ArrayList<Integer> prime=getPrime(1000005);  
      while(T-->0)
      {
        int n=Integer.parseInt(br.readLine());
        System.out.println(prime.get(n-1));
      }
    }
    static ArrayList<Integer> getPrime(int n)
    {
      boolean []arr=new boolean[n+1];
      Arrays.fill(arr,true);
      arr[1]=false;
      for(int i=2;i*i<=n;i++)
      {
        if(arr[i]==true)
        {
          for(int j=i*i;j<=n;j=j+i)
              arr[j]=false;
        }
      }
      ArrayList<Integer> al=new ArrayList<>();
      for(int i=2;i<n;i++)
      {
        if(arr[i]==true)
          al.add(i);
      }
      return al;
    }
  }
