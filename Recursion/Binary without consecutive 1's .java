/* Given an integer N, generate all binary strings such that there are no consecutive 1's.

Input format:
First line contains integer T, denoting number of testcases. 
For each testcase : An integer, the value of N.

Output format
For each testcase print all the possible binary strings in a new line. 

Example
Input
1
3

Output
000
001
010
100
101 */

import java.util.*;
import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      //write your code here
      Scanner scan=new Scanner(System.in);
      int T=scan.nextInt();
      while(T-->0)
      {
        int size=scan.nextInt();
        generateBinary(size);
        System.out.println();
      }
    }
    static void generateBinary(int size)
    {
      char a[]=new char[size];
      
      a[0]='0';
      printBinary(a,1);
      
      a[0]='1';
      printBinary(a,1);
    }
    static void printBinary(char a[],int i)
    {
      if(i==a.length)
      {
        StringBuilder ans=new StringBuilder();
        for(char c: a)
          ans.append(c);
        System.out.println(ans);
        return;
      }
      
      if(a[i-1]=='0')
      {
        a[i]='0';
        printBinary(a,i+1);
        a[i]='1';
        printBinary(a,i+1);
      }
      else
      {
        a[i]='0';
        printBinary(a,i+1);
      }
    }
  }

