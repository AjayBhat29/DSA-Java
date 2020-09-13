package selfHashMap;

public class HashTable<K,V>
{
	private class HTPair
	{
		K key;
		V value;
		HTPair(K key,V value)
		{
			this.key=key;
			this.value=value;
		}

		@Override
		public boolean equals(Object other)
		{
			HTPair op=(HTPair)other;
			return this.key.equals(op.key);
		}

		@Override
		public String toString()
		{
			return "{"+this.key+"-"+this.value+"}";
		}
	}
	public static final int DEFAULT_CAPACITY=10;

	private LinkedList<HTPair>[] bucketArray;
	private int size;
	
	public HashTable()
	{
		this(DEFAULT_CAPACITY);
	}

	public HashTable(int capacity)
	{
		this.bucketArray=(LinkedList<HTPair>[])new LinkedList[capacity];
		this.size=0;
	}

	//function to add a key-value pair into the Hash Table
	public void put(K key,V value) throws Exception
	{
		int bestIndex=hashFunction(key);
		LinkedList<HTPair> bucket=this.bucketArray[bestIndex];
		HTPair pta=new HTPair(key,value);
		if(bucket==null)
		{
			bucket=new LinkedList();
			bucket.addLast(pta);
			this.bucketArray[bestIndex]=bucket;
			this.size++;
		}
		else
		{
			int findAt=bucket.find(pta);
			if(findAt==-1)
			{
				bucket.addLast(pta);
				this.size++;
			}
			else
			{
				HTPair pair=bucket.getAt(findAt);
				pair.value=value;
			}
		}

		double lambda=(this.size*1.0)/this.bucketArray.length;
		if(lambda>0.75)
			this.rehash();
	}

	//function to retrieve the value from the Hash Table for a given key
	public V get(K key) throws Exception
	{
		int bestIndex=hashFunction(key);
		LinkedList<HTPair> bucket=this.bucketArray[bestIndex];
		HTPair ptf=new HTPair(key,null);

		if(bucket==null)
		{
			return null;
		}
		else
		{
			int findAt=bucket.find(ptf);
			if(findAt==-1)
			{
				return null;
			}
			else
			{
				HTPair pair=bucket.getAt(findAt);
				return pair.value;
			}
		}
	}

	//function to remove a key-Value pair form the Hash Table
	public V remove(K key) throws Exception
	{
		int bestIndex=hashFunction(key);
		LinkedList<HTPair> bucket=this.bucketArray[bestIndex];
		HTPair ptr=new HTPair(key,null);

		if(bucket==null)
			return null;
		else
		{
			int findAt=bucket.find(ptr);
			if(findAt==-1)
				return null;
			else
			{
			    HTPair pair=bucket.getAt(findAt);
			    bucket.removeAt(findAt);
			    this.size--;
				return pair.value;
			}
		}
	}
	
	//function to perform rehashing whenever the load factor(lambda) exceeds 0.75
	public void rehash() throws Exception
	{
		LinkedList<HTPair>[] oba=this.bucketArray;
		this.bucketArray=(LinkedList<HTPair>[]) new LinkedList[2*oba.length];
		this.size=0;
		for(LinkedList<HTPair> ob: oba)
		{
			while(ob!=null && !ob.isEmpty())
			{
				HTPair pair=ob.removeFirst();
				this.put(pair.key,pair.value);
			}
		}
	}

	//the hashCode function is similar to a black box which takes any input type and computes on the input to give an integer output
	//take the absolute value of this integer output and module ot with the size of the bucketArray, so as to get a valid index
	private int hashFunction(K key)
	{
		int hcode=key.hashCode();
		hcode=Math.abs(hcode);
		int bestIndex=hcode%this.bucketArray.length;
		return bestIndex;
	}

	//function to display the key value pairs present in the Hash Table
	public void display() throws Exception
	{
		for(LinkedList<HTPair> bucket: bucketArray)
		{
			if(bucket!=null && !bucket.isEmpty())
				bucket.display();
			// else
			// 	System.out.print("NULL");
			// System.out.println();
		}
		System.out.println("----------------------------------------");
	}
}