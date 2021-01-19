/* Given two numbers ‘a’ and ‘b’ such that (0 <= a <= 10^12 and b <= b < 10^250). Find the GCD of two given numbers.

Examples :
Input: a = 978 
       b = 89798763754892653453379597352537489494736
Output: 6

Input: a = 1221 
       b = 1234567891011121314151617181920212223242526272829
Output: 3 */


import java.util.*;
import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      //write your code here
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      int T=Integer.parseInt(br.readLine());
      StringTokenizer st;
      while(T-->0)
      {
        st=new StringTokenizer(br.readLine());
        long a=Long.parseLong(st.nextToken());
        String b=st.nextToken();
        System.out.println(gcdLarge(a,b));
      }
    }
    static long gcdLarge(long a,String b)
    {
      long reduced=reduceNumber(a,b);
      return gcd(a,reduced);
    }
    static long reduceNumber(Long a,String b)
    {
      long result=0;
      for(int i=0;i<b.length();i++)
        result=((result*10)+(b.charAt(i)-48))%a;
      return result;
    }
    static long gcd(long a,long b)
    {
      return b==0?a:gcd(b,a%b);
    }
  }
