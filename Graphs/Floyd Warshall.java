/* The problem is to find shortest distances between every pair of vertices in a given edge weighted directed Graph. The Graph is represented as Adjancency Matrix, and the Matrix denotes the weight of the edegs (if it exists) else INF (1e7).

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. The first line of each test case contains an integer V denoting the size of the adjacency matrix. The next V lines contain V space separated values of the matrix (graph). All input will be integer type.

Output:
For each test case output will be V*V space separated integers where the i-jth integer denote the shortest distance of ith vertex from jth vertex. For INT_MAX integers output INF.

Constraints:
1 <= T <= 20 
1 <= V <= 100
1 <= graph[][] <= 500

Example:
Input
2
2
0 25
INF 0
3
0 1 43
1 0 6
INF INF 0

Output
0 25
INF 0 
0 1 7
1 0 6
INF INF 0 */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
		//code
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		while(T-->0)
		{
		    int v=Integer.parseInt(br.readLine());
		    long graph[][]=new long[v][v];
	        StringTokenizer st;

	        //taking the input for graph 
		    for(int i=0;i<v;i++)
		    {
                st=new StringTokenizer(br.readLine());
		        for(int j=0;j<v;j++)
		        {
		            String val=st.nextToken();
		            if(val.equals("INF"))
		                graph[i][j]=10000000;
		            else
		                graph[i][j]=Long.parseLong(val);
		        }
		    }

		    //Floyd Warshall Algorithm using Dynamic Pogramming
		    for(int k=0;k<v;k++)
		    {
		        for(int i=0;i<v;i++)
		        {
		            for(int j=0;j<v;j++)
		            {
		                long oc=graph[i][j];
		                long nc=graph[i][k]+graph[k][j];
		                
		                //updating the matrix only if the new cost is lesser than the old cost
		                if(nc<oc)
		                {
		                    graph[i][j]=nc;
		                }
		            }
		        }
		    }

		    //displaying the matrix
		    for(int i=0;i<v;i++)
		    {
		        for(int j=0;j<v;j++)
		        {
		            if(graph[i][j]>=10000000)
    		            System.out.print("INF ");
    		        else
    		            System.out.print(graph[i][j]+" ");
		        }
		        System.out.println();
		    }
		}
	}
}