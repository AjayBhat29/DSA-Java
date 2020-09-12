/* Implement your own Generic Linked List in Java*/

import java.util.*;

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
	public int size()
	{
		return this.size();
	}
	public boolean isEmpty()
	{
		return this.size()==0;
	}
	public void addFirst(T item)
	{
		Node node=new Node(item,this.head);
		
		this.head=node;
		if(this.isEmpty())
			this.tail=node;

		this.size++;
	}
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
	public void getNode(int index) throws Exception
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
	public T getFirst() throws Exception
	{
		if(this.isEmpty())
			throw new Exception("List Is Empty");
		return this.head.data;
	}
	public T getLast() throws Exception
	{
		if(this.isEmpty())
			throw new Exception("List Is Empty");
		return this.tail.data;
	}
	public T getAt(int index)throws Exception
	{
		if(this.isEmpty())
			throw new Exception("List Is Empty");
		if(index<0||index>=this.size())
			throw new Exception("Index Out Of Range");
		Node temp=this.getNode(index);
		return temp.data;
	}
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