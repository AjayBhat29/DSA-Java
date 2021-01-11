/* Each month, a CodeChef Long Contest starts at 3 PM IST (UTC+5:30) on the first Friday and it lasts for exactly 10 days (i.e. 240 hours). Also, a Cook-Off starts at 9:30 PM IST on the second-to-last (i.e. penultimate) Sunday and it lasts for 2.5 hours.

Let's denote a month by a pair (m,y), where m is one of the twelve months (numbered 1 through 12) and y is a year. You are given two (not necessarily distinct) months, e.g. Oct 2009 and Feb 2020. You have to find the total number of months between these two months (both inclusive) when the Long Contest and Cook-Off intersect, i.e. there is a moment in time when both contests for that month are running simultaneously. Here, we assume that both contests are held on each and every month without any interruptions or schedule changes.

Note: A year is a leap year if it a multiple of 400, or if it is a multiple of 4 but not a multiple of 100. For example, the year 2100 is not a leap year, but the year 2400 is a leap year.

Also Note that you have to assume 7th February, 2020 as Friday, and extrapolate it backwords till Year 1 using the leap year rules mentioned.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains two space-separated integers m1 and y1 describing the first month.
The second line contains two space-separated integers m2 and y2 describing the second month.
Output
For each test case, print a single line containing one integer ― the number of months between (m1,y1) and (m2,y2) when the Long Contest and the Cook-Off intersect.

Constraints
1≤T≤10^5
1≤m1,m2≤12
1≤y1≤y2≤10^9
the month (m1,y1) does not come later than (m2,y2)

Subtasks
Subtask #1 (15 points):
T≤103
y2≤2,020
Subtask #2 (25 points): y2≤106
Subtask #3 (60 points): original constraints

Example Input
2
2 2020
2 2020
10 2009
2 2020
Example Output
1
3
Explanation
Example case 1: On the Contests page, we can see that this month (Feb 2020), the Long Contest starts on the 7th and ends on the 17th, while the Cook-Off takes place on the 16th. Hence, there is one month in the given range where the Long Contest and the Cook-Off intersect. */

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		/*Observations made from the Greogorian Calendar :
		
		https://www.timeanddate.com/calendar/?year=1&country=22
		    
		    1. Overlaps will occur only in the months of February
		    2. Overlaps occur in the following two dates:
		        i. If first Friday is 7th of February
		       ii. If first Friday is 6th of February and that year is 
		            not a leap year.
		    3. The Gregorian Calendar will repeat itself after 400 years
		*/
		
		/*
		    1. The array []leap is a boolean array to identify if 
		        any given year is a leap year or not.
		    2. The array []febDate is used to store the dates of first 
		       friday in the month of February of each year.
		    3. The array []overlap is used to store the number of overlaps 
		       occured if any in that year(1- presence of overlap, 0 - absence of overlap).
		    4. If the month corresponding to year1 comes after February, then increment the year1.
		    5. Similarly, if the month corresponding to year2 comes before February, then decrement the year2.
		*/
		boolean []leap=new boolean[401];
		for(int i=1;i<=400;i++)
		{
		    if(i%400==0 || i%4==0 && i%100!=0)
		        leap[i]=true;
		}
		
		int []febDate=new int[401];
		febDate[1]=2;
		for(int i=2;i<=400;i++)
		{
		    if(leap[i-1])
		        febDate[i]=febDate[i-1]-2;
		    else
		        febDate[i]=febDate[i-1]-1;
		        
		    if(febDate[i]<=0)
		        febDate[i]=(febDate[i]+7)%8;
		}
		
		int []overlap=new int[401];
		for(int i=1;i<=400;i++)
		{
		    if(febDate[i]==7)
		        overlap[i]=1;
		    else if(febDate[i]==6 && !leap[i])
		        overlap[i]=1;
		}
		
		for(int i=1;i<=400;i++)
		    overlap[i]+=overlap[i-1];
		    
	    int val=overlap[400]-overlap[0];
		while(T-->0)
		{
		    st=new StringTokenizer(br.readLine());
		    int m1=Integer.parseInt(st.nextToken());
		    int y1=Integer.parseInt(st.nextToken());
		    st=new StringTokenizer(br.readLine());
		    int m2=Integer.parseInt(st.nextToken());
		    int y2=Integer.parseInt(st.nextToken());
		    long ans=0;
		    if(m1>2)
		        y1++;
		    if(m2<2)
		        y2--;
		    long val1=overlap[y2%400]+((long)(y2/400)*val);
		    long val2=overlap[(y1-1)%400]+((long)((y1-1)/400)*val);
		    ans=val1-val2;
		    System.out.println(ans);
		}  
	}
}
