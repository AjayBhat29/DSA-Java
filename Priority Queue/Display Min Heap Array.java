/* Given an array containing N integers, your task is to create a min-heap using the elements of the given array and print the heap array. 
Elements needs to be inserted one by one in the heap.
Note: Use heap concepts to solve the problem.

Input Format
The first line contains an integer T denoting the number of test cases.
For each of the next T lines.
The first line contains an integer N denoting the number of elements in the array.
The second line contains N space-separated integers.

Output Format
For each test case print the min-heap array.

Constraints
1<=T<=10

1<=N<=10^6

1<=A[i]<=10^6

Time Limit
1 second

Example
Sample Input
2
5
3 2 4 1 5
4
4 2 3 4

Sample Output
1 2 4 3 5 
2 4 3 4 */

import java.util.*;
import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      //write your code here
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      int T=Integer.parseInt(br.readLine());
      StringBuilder ans=new StringBuilder();
      while(T-->0)
      {
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        MinHeap<Integer> pq=new MinHeap<>();
        while(st.hasMoreTokens())
          pq.add(Integer.parseInt(st.nextToken()));
        for(int x: pq.data)
          ans.append(x+" ");
        ans.append("\n");
      }
      System.out.print(ans);
    }
  }
class MinHeap<T extends Comparable<T>>
{
	ArrayList<T> data=new ArrayList<>();

	public void add(T item)
	{
		data.add(item);
		upheapify(data.size()-1);	
	}

	// function to perform upward swaps until min heap property is established
	private void upheapify(int childIndex)
	{
		int parentIndex=(childIndex-1)/2;
		if(isLarger(data.get(childIndex),data.get(parentIndex))>0)
		{
			swap(parentIndex,childIndex);
			upheapify(parentIndex);	
		}
	}

	// function to swap elements at child index and parent index
	private void swap(int i,int j)
	{
		T iThElement=data.get(i);
		T jThElement=data.get(j);

		data.set(i,jThElement);
		data.set(j,iThElement);
	}

	//function to display the array list storing the elements of the min heap 
	public void display()
	{
		System.out.println(data);
	}

	//function to return the min heap size
	public int size()
	{
		return this.data.size();
	}

	// function to check if the heap is empty
	public boolean isEmpty()
	{
		return this.data.size()==0;
	}

	//function to remove the top priority element in the min heap
	public T remove()
	{
		swap(0,this.data.size()-1);
		T rv=this.data.remove(this.data.size()-1);

		downheapify(0);
		return rv;
	}

	//function to peform downward heapify until the condition of min heap is satisfied
	private void downheapify(int parentIndex)
	{
		int leftChildIndex= 2*parentIndex + 1;
		int rightChildIndex= 2*parentIndex + 2;

		int minIndex=parentIndex;

		if(leftChildIndex<data.size() && isLarger(data.get(leftChildIndex),data.get(minIndex))>0)
			minIndex=leftChildIndex;
		if(rightChildIndex<this.data.size() && isLarger(data.get(rightChildIndex),data.get(minIndex))>0)
			minIndex=rightChildIndex;

		if(minIndex!=parentIndex)
		{
			swap(parentIndex,minIndex);
			downheapify(minIndex);
		}
	}

	//function to get the top priority element of the heap
	public T get()
	{
		return this.data.get(0);
	}

	// if t is having higher priority, positive value will be returned
	public int isLarger(T t,T o)
	{
		return o.compareTo(t);
	}

}
