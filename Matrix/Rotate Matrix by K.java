import java.util.*;
import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
	    int matrix[][] = {{12, 23, 34}, 
	                        {45, 56, 67},  
	                        {78, 89, 91}}; 
	   	int k = 2; 
	    rotateMatrix(matrix, k); 
    }

    static void rotateMatrix(int matrix[][], int k)
    {

    	int row=matrix.length;
    	int col=matrix[0].length;
    	
    	k=k%row;
    	
    	for(int i=0;i<row;i++)
    	{
            int a[]=new int[row];
            for(int j=0;j<col;j++)
                a[j]=matrix[i][j];
    		rotateRow(a,k);
    		for(int j=0;j<col;j++)
    		    matrix[i][j]=a[j];
    	}

    	displayMatrix(matrix,row,col);
    }
    
    static void rotateRow(int a[],int k)
    {
    	int n=a.length;
    	//rotate right
    	swap(a,0,n-k-1);
    	swap(a,n-k,n-1);
    	swap(a,0,n-1);
    	/* OR rotate left
    	swap(a,0,k-1);
    	swap(a,k,n-1);
    	swap(a,0,n-1); */
    }

    static void swap(int a[],int start,int end)
    {
    	while(start<=end)
    	{
    		int temp=a[start];
    		a[start]=a[end];
    		a[end]=temp;
    		start++;
    		end--;
    	}
    }

    static void displayMatrix(int [][]matrix,int row, int col)
    {
    	for(int i=0;i<row;i++)
    	{
    		for(int j=0;j<col;j++)
    			System.out.print(matrix[i][j]+" ");
    		System.out.println();
    	}
    }
 }
  
