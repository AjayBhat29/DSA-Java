/*
Given a dice with 6 faces, numbered from 1 to 6.
Find all the combination of ways to reach destination 10 on a board having locations 1,2,3,4,5,6,7,8,9,10. 
*/

import java.util.*;

public class Main
{
	public static void main(String []args)
	{
		System.out.println(getBoardPath(0,10));
	}
	static ArrayList<String> getBoardPath(int curr,int end)
	{
		if(curr==end)
		{
			ArrayList<String> base=new ArrayList<>();
			base.add("\n");
			return base;
		}
		if(curr>end)
		{
			ArrayList<String> base=new ArrayList<>();
			return base;	
		}
		ArrayList<String> myResult=new ArrayList<>();
		for(int dice=1;dice<=6;dice++)
		{
			ArrayList<String> recResult=getBoardPath(curr+dice,end);

			for(String rrs: recResult)
			{
				myResult.add(dice+rrs);	
			}
		}
		return myResult;
	}
}