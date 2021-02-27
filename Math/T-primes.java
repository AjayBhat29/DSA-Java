/* We know that prime numbers are positive integers that have exactly two distinct positive divisors. Similarly, we'll call a positive integer t Т-prime, if t has exactly three distinct positive divisors.

You are given an array of n positive integers. For each of them determine whether it is Т-prime or not.

Input
The first line contains a single positive integer, n (1 ≤ n ≤ 105), showing how many numbers are in the array. The next line contains n space-separated integers xi (1 ≤ xi ≤ 1012).

Please, do not use the %lld specifier to read or write 64-bit integers in С++. It is advised to use the cin, cout streams or the %I64d specifier.

Output
Print n lines: the i-th line should contain "YES" (without the quotes), if number xi is Т-prime, and "NO" (without the quotes), if it isn't.

Examples
inputCopy
3
4 5 6
outputCopy
YES
NO
NO
Note
The given test has three numbers. The first number 4 has exactly three divisors — 1, 2 and 4, thus the answer for this number is "YES". The second number 5 has two divisors (1 and 5), and the third number 6 has four divisors (1, 2, 3, 6), hence the answer for them is "NO". */

import java.util.*;
import java.io.*;
  
  public class Main {
     static Set<Integer> getPrime(int n)
     {
        boolean arr[]=new boolean[n+1];
        Arrays.fill(arr,true);
        for(int i=2;i*i<=n;i++)
        {
            if(arr[i]==true)
            {
                for(int j=i*i;j<=n;j=j+i)
                    arr[j]=false;
            }
        }
        Set<Integer> hset=new HashSet<>();
        for(int i=2;i<=n;i++)
            if(arr[i]==true)
                hset.add(i);
        return hset;
     }
     static Set<Integer> hset=getPrime(1000001);
    public static void main(String args[]) throws IOException {
      
      //write your code here
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      int T=Integer.parseInt(br.readLine());
      StringTokenizer st=new StringTokenizer(br.readLine());
      StringBuilder ans=new StringBuilder();
      while(T-->0)
      {
        long n=Long.parseLong(st.nextToken());
        if(Tprime(n))
            ans.append("YES\n");
        else
            ans.append("NO\n");
      }
      System.out.print(ans);
    }
    static boolean Tprime(long n)
    {
        int lower=(int)Math.sqrt(n);
        int higher=(int)(Math.ceil(Math.sqrt(n)));
        // System.out.println(lower+" "+higher);
        return lower==higher && hset.contains(lower);
    }
  }

