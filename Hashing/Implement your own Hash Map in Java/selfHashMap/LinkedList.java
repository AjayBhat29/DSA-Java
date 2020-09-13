package selfHashMap;

public class LinkedList<T>
{
	private class Node
	{
		T data;
		Node next;

		Node(T data,Node next)
		{
			this.data=data;
			this.next=next;
		}
	}
	private int size;
	Node head;
	Node tail;

	public LinkedList()
	{
		this.size=0;
		this.head=null;
		this.tail=null;
	}
	
	//function to return the size(number of nodes) in the linkedlist
	public int size()
	{
		return this.size;
	}
	
	//function to check if linkedlist is empty
	public boolean isEmpty()
	{
		return this.size()==0;
	}
	
	//function to add a node at the beginning(head) of a linkedlist
	public void addFirst(T item)
	{
		Node node=new Node(item,this.head);
		
		this.head=node;
		if(this.isEmpty())
			this.tail=node;

		this.size++;
	}
	
	//function to add a note at the end(tail) of a linkedlist
	public void addLast(T item)
	{
		Node node=new Node(item,null);
		if(this.isEmpty())
		{
			this.head=node;
			this.tail=node;
		}
		else
		{
			this.tail.next=node;
			this.tail=node;
		}
		this.size++;
	}
	
	//function to return the node present at index
	public Node getNode(int index) throws Exception
	{
		if(index<0||index>=this.size())
			throw new Exception("Index Out Of Range");
		Node temp=this.head;
		int counter=0;
		while(counter<index)
		{
			temp=temp.next;
			counter++;
		}
		return temp;
	}	
	
	//function to add an item at the given index
	public void addAt(int index,T item)throws Exception
	{
		if(index<0||index>this.size())
			throw new Exception("Index Out Of Range");
		if(index==0)
			this.addFirst(item);
		else if(index==this.size())
			this.addLast(item);
		else
		{
			Node temp=getNode(index-1);
			Node node=new Node(item,temp.next);
			temp.next=node;
			this.size++;
		}
	}
	
	//function to get the first item of the linkedlist
	public T getFirst() throws Exception
	{
		if(this.isEmpty())
			throw new Exception("List Is Empty");
		return this.head.data;
	}
	
	//function to get the last item of the linkedlist
	public T getLast() throws Exception
	{
		if(this.isEmpty())
			throw new Exception("List Is Empty");
		return this.tail.data;
	}
	
	//function to return the data present at the index in the linkedlist
	public T getAt(int index)throws Exception
	{
		if(this.isEmpty())
			throw new Exception("List Is Empty");
		if(index<0||index>=this.size())
			throw new Exception("Index Out Of Range");
		Node temp=this.getNode(index);
		return temp.data;
	}
	
	//function to remove the first node from the linked list
	public T removeFirst() throws Exception
	{
		if(this.isEmpty())
			throw new Exception("List Is Empty");
		Node rv=this.head;
		if(this.size()==1)
		{
			this.tail=null;
			this.head=null;
		}
		else
		{
			this.head=this.head.next;
		}
		this.size--;
		return rv.data;
	}
	
	//function to remove the last node from the linkedlist
	public T removeLast() throws Exception
	{
		if(this.isEmpty())
			throw new Exception("List Is Empty");
		Node rv=this.tail;
		if(this.size()==1)
		{
			this.tail=null;
			this.head=null;
		}
		else
		{
			Node temp=this.getNode(this.size()-2);
			temp.next=null;
			this.tail=temp;
		}
		this.size--;
		return rv.data;
	}
	
	//function to remove node present at index in the linkedlist
	public T removeAt(int index) throws Exception
	{
		if(this.isEmpty())
			throw new Exception("List Is Empty");
		if(index<0||index>=this.size())
			throw new Exception("Index Out Of Range");
		if(index==0)
			return this.removeFirst();
		else if(index==this.size()-1)
			return this.removeLast();
		else
		{
			Node rv=this.getNode(index);
			Node temp=this.getNode(index-1);
			temp.next=temp.next.next;
			this.size--;
			return rv.data;
		}
	}
	
	//function to display items present in the linkedlist
	public void display() throws Exception
	{
		if(this.isEmpty())
			throw new Exception("List Is Empty");
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+"=>");
			temp=temp.next;
		}
		System.out.println("END");
	}
	
	//function to return the index of an item if present in the linkedlist
	public int find(T data)
	{
		int index=0;
		for(Node temp=head;temp!=null;temp=temp.next)
		{
			if(temp.data.equals(data))
				return index;
			index++;
		}
		return -1;	
	}
	
}