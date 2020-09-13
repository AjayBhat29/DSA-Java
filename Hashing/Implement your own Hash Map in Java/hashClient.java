import selfHashMap.*;

import java.util.*;

class hashClient
{
	public static void main(String[] args) throws Exception
	{
		HashTable<String,Integer> map=new HashTable<>(4);

		System.out.println("~~~~~~~~~~~~~~~~~Testing the 'put' functionality of Hash Map~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		map.put("USA",200);
		map.put("UK",175);	
		map.put("India",300);
		mapo.display();
		
		System.out.println("~~~~~~~~~~~~~~~~~Testing the 'put' functionality of Hash Map(by updating the value of India~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		map.put("India",325);
		map.put("Sweden",100)
		map.display();

		System.out.println("~~~~~~~~~~~~~~~~~Testing the 'get' functionality of Hash Map~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(map.get("India"));
		System.out.println(map.get("Sweden"));
		System.out.println(map.get("RSA"));// should print NULL as RSA is not present in the Hash Map

		System.out.println("~~~~~~~~~~~~~~~~~Testing the 'remove' functionality of Hash Map~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(map.remove("China"));
		map.display();		
	}
}