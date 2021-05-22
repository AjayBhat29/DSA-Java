/* Given 2 integers N and P. Find the square root of N upto P places of precision using Binary Search technique */

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
	    float ans=0;
	    
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
	    float inc=(float)0.1;
	    for(int place=1;place<=P;place++){
	        while(ans*ans<=N)
	            ans+=inc;
	        ans-=inc;
	        inc=inc/10;
	    }

	    return ans;
	}
}
