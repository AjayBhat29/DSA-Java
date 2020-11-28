/*
A permutation, also called an “arrangement number” or “order,” 
is a rearrangement of the elements of an ordered list S into a one-to-one 
correspondence with S itself. A string of length n has n! permutation.

Below are the permutations of string ABC.
ABC ACB BAC BCA CBA CAB
*/

import java.util.*;
import java.math.*;

public class Main {
    public static void main(String args[]) {
        System.out.println(getPermutation("abc"));
    }
	static ArrayList<String> getPermutation(String str)
	{
	    if(str.length()==0)
	    {
	        ArrayList<String> base=new ArrayList<>();
	        base.add("");
	        return base;
	    }
		char curChar=str.charAt(0);
		String ros=str.substring(1);
		ArrayList<String> recResult=getPermutation(ros);
		ArrayList<String> myResult=new ArrayList<>();
		for(String s: recResult)
		{
		    for(int i=0;i<=s.length();i++)
		    {
		        myResult.add(s.substring(0,i)+curChar+s.substring(i));
		    }
		}
		return myResult;
	}
}
