import java.util.*;

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

class MaxHeap<T extends Comparable<T>>
{
	ArrayList<T> data=new ArrayList<>();

	public void add(T item)
	{
		data.add(item);
		upheapify(data.size()-1);	
	}

	// function to perform upward swaps until max heap property is established
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

	//function to display the array list storing the elements of the max heap 
	public void display()
	{
		System.out.println(data);
	}

	//function to return the max heap size
	public int size()
	{
		return this.data.size();
	}

	// function to check if the heap is empty
	public boolean isEmpty()
	{
		return this.data.size()==0;
	}

	//function to remove the top priority element in the max heap
	public T remove()
	{
		swap(0,this.data.size()-1);
		T rv=this.data.remove(data.size()-1);

		downheapify(0);
		return rv;
	}

	//function to peform downward heapify until the condition of max heap is satisfied
	private void downheapify(int parentIndex)
	{
		int leftChildIndex= 2*parentIndex + 1;
		int rightChildIndex= 2*parentIndex + 2;

		int maxIndex=parentIndex;

		if(leftChildIndex<this.data.size() && isLarger(data.get(leftChildIndex),data.get(maxIndex))>0)
			maxIndex=leftChildIndex;
		if(rightChildIndex<this.data.size() && isLarger(data.get(rightChildIndex),data.get(maxIndex))>0)
			maxIndex=rightChildIndex;

		if(maxIndex!=parentIndex)
		{
			swap(parentIndex,maxIndex);
			downheapify(maxIndex);
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
		return t.compareTo(o);
	}
}

class heapMain
{
	public static void main(String []args)
	{
		MinHeap<String> minHeap=new MinHeap<>();

		minHeap.add("A");
		minHeap.add("Z");
		minHeap.add("AB");
		minHeap.add("BH");
		minHeap.add("YR");
		minHeap.add("CC");
		minHeap.display();
		System.out.print("In case of min heap, elements upon removal will appear in ascending order : ");
		System.out.println(minHeap.remove()+" "+minHeap.remove()+" "+minHeap.remove()+" "+minHeap.remove()+" "+minHeap.remove());

		System.out.println("----------------------------------------------------------------------------------------------------");

		MaxHeap<String> maxHeap=new MaxHeap<>();

		maxHeap.add("A");
		maxHeap.add("Z");
		maxHeap.add("AB");
		maxHeap.add("BH");
		maxHeap.add("YR");
		maxHeap.add("CC");
		maxHeap.display();
		System.out.print("In case of max heap, elements upon removal will appear in descending order : ");
		System.out.println(maxHeap.remove()+" "+maxHeap.remove()+" "+maxHeap.remove()+" "+maxHeap.remove()+" "+maxHeap.remove());
	}
}
