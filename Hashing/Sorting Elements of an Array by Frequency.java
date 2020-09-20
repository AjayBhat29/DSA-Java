
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException{
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		while(T-->0)
		{
		    int n=Integer.parseInt(br.readLine().trim());
		    StringTokenizer st=new StringTokenizer(br.readLine());
		    Map<Integer,Integer> hmap=new HashMap<>();
		    while(st.hasMoreTokens())
		    {
		        int x=Integer.parseInt(st.nextToken());
		        hmap.put(x,hmap.getOrDefault(x,0)+1);
		    }
		    PriorityQueue<Pair> pq=new PriorityQueue<>();
		    ArrayList<Integer> al=new ArrayList<>();
		    for(int x: hmap.keySet())
		    {
		        Pair p=new Pair(x,hmap.get(x));
		        pq.add(p);
		    }
		    LinkedList<Integer> ll=new LinkedList<>();
		    while(!pq.isEmpty())
		    {
		        Pair p=pq.poll();
		        int x=p.v;
		        while(x-->0)
    		        ll.addFirst(p.k);
		    }
		    StringBuilder ans=new StringBuilder();
		    for(int x: ll)
		        ans.append(x+" ");
		    System.out.println(ans);
		}
	}
}

class Pair implements Comparable<Pair>
{
    int k;
    int v;
    Pair(int k,int v)
    {
        this.k=k;
        this.v=v;
    }
    
    public int compareTo(Pair other)
    {
        // priority given to higher frequency
        int first = this.v-other.v;
        if(first!=0)
            return first;
        // in case of same frequency, priority given to the smaller number
        return other.k-this.k;
    }
}