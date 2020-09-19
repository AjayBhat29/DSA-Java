/* Given K sorted arrays each with N elements merge them and output the sorted array

Input Format
First line contains 2 space separated integers K and N.
Next lines contain K*N space separated integers

Constraints
Elements of array <= |10^15|
N <= 10^5
K <= 10

Output Format
Single line consisting of space separated numbers

Sample Input
3 4
1 3 5 7 2 4 6 8 0 9 10 11
Sample Output
0 1 2 3 4 5 6 7 8 9 10 11 */

import java.util.*; 

class Main 
{ 
	public static void main(String args[]) 
	{ 
		int k=0; 
		Scanner scan=new Scanner(System.in); 
		if(scan.hasNextInt()) 
			k=scan.nextInt(); 
		int n=0; 
		if(scan.hasNextInt()) 
			n=scan.nextInt();

		//Priority Queue in Java is Min Heap by default 
		PriorityQueue<Integer> pq=new PriorityQueue<>();

		//Pointer array which stores the starting indices of each of the K Sorted Arrays 
		int []pointer=new int[k]; 

		//Input Array which stores all the n*k elements as given by the problem statement
		int input[]=new int[n*k]; 

		for(int i=0;i<n*k;i++) 
		{ 
			input[i]=scan.nextInt(); 
		} 

		//Initialising the starting indices of the pointer array values
		for(int i=1;i<k;i++) 
			pointer[i]=n*i;  

		// Adding the first elements from each of the K Sorted Arrays
		for(int i=0;i<k;i++) 
			pq.add(input[pointer[i]]); 


		while(!pq.isEmpty()) 
		{ 
			int min=Integer.MAX_VALUE; 
			int j=-1; 
			for(int i=0;i<k;i++) 
			{ 
				if(pointer[i]!=-1 && input[pointer[i]]<min) 
				{ 
					min=input[pointer[i]]; 
					j=i; 
				} 
			} 
			int prev=pointer[j]; 
			pointer[j]+=1; 
			int next=pointer[j]; 
			prev/=n; 
			next/=n; 
			//prev and next are used to handle the edge case where the pointer of one sorted array moves on to the starting index of the next adjacent array
			if(prev!=next) 
				pointer[j]=-1; 

			System.out.print(pq.poll()+" ");

			if(pointer[j]!=-1) 
				pq.add(input[pointer[j]]); 
		} 
	} 
}