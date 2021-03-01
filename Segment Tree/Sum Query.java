/* Jacob is given an array of N elements and Q queries. In each query he is given two values l,r.
Jacob has to find the sum of all the elements from l to r.
As the sum might be quite large print the answer modulo 10^9+7.

Input format
The first line contains an integer T, denoting the number of test cases.
Each test case contains an integer N.
The next line contains N space-separated integers (1 based indexing).
The next line contains a value Q.
The next Q lines contain two integer l and r. 

Output format
Print the answer of each query in a new line.

Constraints
1<=T<=10
1<=N,Q<=10^5

Time Limit
1 second

Example
Input
1
5 
1 2 3 4 5
3
1 2
2 3
3 4
Output
3
5
7

Explanation
The sum of elements from index 1 to index 2 is 3, similarly for other queries (1 based indexing). */

import java.util.*;
import java.io.*;
  
  public class Main {
    public static void main(String args[]) throws IOException {
      
      //write your code here
      BufferedReader br=new  BufferedReader(new InputStreamReader(System.in));
      int T=Integer.parseInt(br.readLine());
      StringBuilder ans=new StringBuilder();
      while(T-->0)
      {
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a[]=new int[n];
        for(int i=0;i<n;i++)
          a[i]=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(br.readLine());
        SegmentTree tree=new SegmentTree(a);
        while(q-->0)
        {
          st=new StringTokenizer(br.readLine());
          int l=Integer.parseInt(st.nextToken())-1;
          int r=Integer.parseInt(st.nextToken())-1;
          ans.append(tree.querySegmentTree(l,r,n)+"\n");
        }
      }
      System.out.print(ans);
    }
  }
  
  class SegmentTree //Sum Query Segment Tree
  {
    static int M=1000000007;
    int []segment_tree_array;
    
    public SegmentTree(int a[])
    {
        segment_tree_array = createSegmentTree(a); 
        // for(int x: segment_tree_array)
        //   System.out.print(x+" ");
        // System.out.println();
    }
    
    private int[] createSegmentTree(int arr[])
    {
      int x=(int)Math.ceil(Math.log(arr.length)/Math.log(2));
      int size=2*(int)Math.pow(2,x)-1;
      int segmentTree[]=new int[size];
      for(int i=0;i<segmentTree.length;i++)
      {
        segmentTree[i]=0;
      }
      constructSegmentTree(segmentTree,arr,0,arr.length-1,0);
      return segmentTree;
    }
    private void constructSegmentTree(int []segmentTree,int arr[],int lo,int hi,int position) 
    {
      if(lo==hi)
      {
        segmentTree[position]=arr[lo];
        return;
      }
      
      int mid=(lo+hi)/2;
      
      constructSegmentTree(segmentTree,arr,lo,mid,2*position+1);
      constructSegmentTree(segmentTree,arr,mid+1,hi,2*position+2);
      
      segmentTree[position]=segmentTree[2*position+1]%M+segmentTree[2*position+2]%M;  
    }
    
    public int querySegmentTree(int q_left,int q_right,int length)
    {
      return query(0,length-1,q_left,q_right,0);//lo,hi,q_left,q_right,position
    }
    private int query(int lo,int hi,int q_left,int q_right,int position)
    {
      if(q_left<=lo && q_right>=hi)//complete overlap
        return segment_tree_array[position];
      
      if(q_left>hi || q_right<lo)// no overlap
        return 0;
      
      int mid=(lo+hi)/2;
      
      int sum1=query(lo,mid,q_left,q_right,2*position+1);
      int sum2=query(mid+1,hi,q_left,q_right,2*position+2);
      
      return sum1%M+sum2%M;
    }
    
    public void updateSegmentTree(int arr[],int index,int value)
    {
      arr[index]=value;
      update(index,value,0,arr.length-1,0);//index,updated value,low,high,position
    }
    private void update(int index,int value,int lo,int hi,int position)
    {
      if(index<lo || index>hi)
        return;
      
      if(lo==hi)
      {
        segment_tree_array[position] = value;
        return;
      }
      
      int mid=(lo+hi)/2;
      
      update(index,value,lo,mid,2*position+1);
      update(index,value,mid+1,hi,2*position+2);
      
      segment_tree_array[position]=segment_tree_array[2*position+1]%M+segment_tree_array[2*position+2]%M;   
    }
  }
  
