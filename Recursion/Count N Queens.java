/*
Count the number of ways 'N' queens can be placed in a NxN chess board,
where no pair of queens are placed in confliciting posotions.
*/

import java.util.*;

public class Main
{
	final static int N = 4; 

	public static void main(String []args)
	{
		boolean board[][]=new boolean[N][N];
		System.out.println(countNQueens(board,0));
	}

	public static int countNQueens(boolean [][]board,int row)
	{
		if(row==board.length)
			return 1;

		int count=0;
		for(int col=0;col<board[row].length;col++)
		{
			if(isItSafe(board,row,col))
			{
				board[row][col]=true;
				count=count+countNQueens(board,row+1);
				board[row][col]=false;
			}
		}

		return count;
	}

	private static boolean isItSafe(boolean [][]board,int row,int col)
	{
		//if any queen is present in vertical column 
		for(int r=row;r>=0;r--)
			if(board[r][col])
				return false;

		//if any queen is present in north-west diagonal
		for(int r=row,c=col;r>=0 && c>=0;r--,c--)
			if(board[r][c])
				return false;

		//if any queen is present in north-east diagonal
		for(int r=row,c=col;r>=0 && c<board.length;r--,c++)
			if(board[r][c])
				return false;

		return true;
	}
}