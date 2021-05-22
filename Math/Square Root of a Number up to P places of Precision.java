/* Given 2 integers N and P. Find the square root of N upto P places of precision using Binary Search technique */

/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		int N=scan.nextInt();
		int P=scan.nextInt();
		
		System.out.println(square_root(N,P));
	}
	
	static float square_root(int N,int P) {
	    int s=0;
	    int e=N;
	    int mid;
	    double ans=0;
	    
	    //binary search for integer part
	    while(s<=e){
	        mid=(s+e)/2;
	        
	        if(mid*mid==N){
	            return mid;
	        }
	        
	        if(mid*mid<N){
	            ans=mid;
	            s=mid+1;
	        }
	        
	        else{
	            e=mid-1;
	        }
	    }
	    
	    //linear search for floating decimal part
	    double inc=0.1;
	    for(int place=1;place<=P;place++){
	        while(ans*ans<=N)
	            ans+=inc;
	        ans-=inc;
	        inc=inc/10;
	    }

	    return (float)ans;
	}
}
