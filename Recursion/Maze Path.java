/*
Given a starting position of a 2D matrix, find all unique paths to reach the last cell of the matrix.
You are allowed to move only one step right (H=horizontal) or one step down (V=vertical).
*/

import java.util.*;

public class Main
{
	public static void main(String[] args) 
	{
        System.out.println(getMazePath(0,0,2,2));    		
	}
	static ArrayList<String> getMazePath(int cr,int cc,int er,int ec)
	{
	    if(cr>er || cc>ec)
	    {
	        ArrayList<String> base=new ArrayList<>();
	        return base;
	    }

	    if(cr==er && cc==ec)
	    {
	        ArrayList<String> base=new ArrayList<>();
	        base.add("");
	        return base;
	    }

	    ArrayList<String> myResult=new ArrayList<>();

	    ArrayList<String> hrec=getMazePath(cr,cc+1,er,ec);
	    for(String path: hrec)
	        myResult.add("H"+path);

	    ArrayList<String> vrec=getMazePath(cr+1,cc,er,ec);
	    for(String path: vrec)
	        myResult.add("V"+path);

	    return myResult;
	}
}

/*
cr = current row
cc = current column
er = end row
ec = end column
hrec = horizontal stepping recursive result
vrec = vertical stepping recursive result
*/