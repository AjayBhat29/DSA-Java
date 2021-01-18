/* Write a program to print all the combinations of factors of given number n.

Examples:

Input : 16
Output :2 2 2 2 
        2 2 4 
        2 8 
        4 4 

Input : 12
Output : 2 2 3
         2 6
         3 4 */

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
        String s="1";
        int p=2;
        findFactor(n,p,s);
      }
    }
    static void findFactor(int n,int p,String s)
    {
      if(n==1)
      {
        System.out.println(s);
      }
      else
      {
        for(int i=p;i<=n;i++)
        {
          if(n%i==0)
            findFactor(n/i,i,s+" "+i);
        }
      }
    }
  }
  
