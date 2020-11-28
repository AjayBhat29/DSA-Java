/*
Given a starting position of a 2D matrix, find all unique paths to reach the last cell of the matrix.
You are allowed to move only one step right (H=horizontal) or one step down (V=vertical) or one step diagonal (D=south-east)
*/

import java.util.*;

public class Main
{
	public static void main(String[] args) 
	{
        System.out.println(getMazePathDiagonal(0,0,2,2));    		
	}
	static ArrayList<String> getMazePathDiagonal(int cr,int cc,int er,int ec)
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

	    ArrayList<String> hrec=getMazePathDiagonal(cr,cc+1,er,ec);
	    for(String path: hrec)
	        myResult.add("H"+path);

	    ArrayList<String> vrec=getMazePathDiagonal(cr+1,cc,er,ec);
	    for(String path: vrec)
	        myResult.add("V"+path);
	        
	   ArrayList<String> drec=getMazePathDiagonal(cr+1,cc+1,er,ec);
	    for(String path: drec)
	        myResult.add("D"+path);

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
drec = diagonal stepping recursive result
*/
