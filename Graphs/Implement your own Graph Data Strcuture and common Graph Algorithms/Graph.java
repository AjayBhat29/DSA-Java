import java.util.*;

public class Graph
{
	private class Vertex
	{
		HashMap<String,Integer> neighbours = new HashMap<>();
	}

	HashMap<String,Vertex> vertices;

	public Graph()
	{
		vertices = new HashMap<>();
	}

	public int numVertex()
	{
		return this.vertices.size();
	}

	public boolean containsVertex(String vertexName)
	{
		return this.vertices.containsKey(vertexName);
	}

	public void addVertex(String newVertex)
	{
		if(!vertices.containsKey(newVertex))
		{
			Vertex vertex=new Vertex();
			vertices.put(newVertex,vertex);
		}
	}

	public void removeVertex(String removeVertexName)
	{
		Vertex ver=vertices.get(removeVertexName);
		
		for(String str: ver.neighbours.keySet())
		{
			Vertex nbr=vertices.get(str);
			nbr.neighbours.remove(removeVertexName);
		}

		vertices.remove(removeVertexName);
	}

	public int numEdges()
	{
		int totEdge=0;
		for(String str: vertices.keySet())
		{
			Vertex temp=vertices.get(str);
			totEdge += temp.neighbours.size();
		}			
		totEdge/=2;
		return totEdge;
	}

	public int totalWeight()
	{
		int totWeight=0;
		for(String str: vertices.keySet())
		{
			Vertex temp=vertices.get(str);
			for(String nbr: temp.neighbours.keySet())
			    totWeight+=temp.neighbours.get(nbr);
		}			
		totWeight/=2;
		return totWeight;
	}

	public boolean containsEdge(String vertex1, String vertex2)
	{
		Vertex ver1=vertices.get(vertex1);
		Vertex ver2=vertices.get(vertex2);

		if(ver1==null || ver2==null || !ver1.neighbours.containsKey(vertex2))
			return false;

		return true;
	}

	public void addEdge(String vertex1,String vertex2,int cost)
	{
		Vertex ver1=vertices.get(vertex1);
		Vertex ver2=vertices.get(vertex2);

		if(ver1==null || ver2==null || ver1.neighbours.containsKey(vertex2))
			return;
		
		ver1.neighbours.put(vertex2,cost);
		ver2.neighbours.put(vertex1,cost);		
	}

	public void removeEdge(String vertex1, String vertex2)
	{
		Vertex ver1=vertices.get(vertex1);
		Vertex ver2=vertices.get(vertex2);

		if(ver1==null || ver2==null || !ver1.neighbours.containsKey(vertex2))
			return;

		ver1.neighbours.remove(vertex2);
		ver2.neighbours.remove(vertex1);		
	}

	public void display()
	{
		System.out.println("----------------------------");

		for(String str: vertices.keySet())
		{
			Vertex ver=vertices.get(str);
			System.out.println(str+" : "+ver.neighbours);
		}	

		System.out.println("-----------------------------");
	}

	public boolean hasPath(String vertex1,String vertex2,HashSet<String> visited)
	{
		visited.add(vertex1);

		if(containsEdge(vertex1,vertex2))
			return true;

		for(String nbr: vertices.get(vertex1).neighbours.keySet())
		{
			if(!visited.contains(nbr) && hasPath(nbr,vertex2,visited))
				return true;
		}

		return false;
	}

	private class Pair
	{
		String vName;
		String pathSoFar;
		Pair(String v,String p)
		{
			this.vName=v;
			this.pathSoFar=p;
		}
	}

	public boolean bfs(String source,String destination)
	{
		LinkedList<Pair> queue=new LinkedList<>();
		Set<String> visited=new HashSet<>();
		//create a new Pair(Source)
		Pair sp=new Pair(source,source);

		queue.addLast(sp);

		while(!queue.isEmpty())
		{
			Pair rp=queue.removeFirst();
			if(visited.contains(rp.vName))
				continue;

			visited.add(rp.vName);

			if(containsEdge(rp.vName,destination))
			{
				System.out.println(rp.pathSoFar+destination);
				return true;
			}

			Vertex rpvtx=vertices.get(rp.vName);
			for(String nbr: rpvtx.neighbours.keySet())
			{
				if(!visited.contains(nbr))
				{
					Pair np=new Pair(nbr,rp.pathSoFar+nbr);

					queue.addLast(np);
				}
			}			
		}
		return false;
	}

	public boolean dfs(String source,String destination)
	{
		LinkedList<Pair> stack=new LinkedList<>();
		Set<String> visited=new HashSet<>();
		//create a new Pair(Source)
		Pair sp=new Pair(source,source);

		stack.addFirst(sp);

		while(!stack.isEmpty())
		{
			Pair rp=stack.removeFirst();
			if(visited.contains(rp.vName))
				continue;

			visited.add(rp.vName);

			if(containsEdge(rp.vName,destination))
			{
				System.out.println(rp.pathSoFar+destination);
				return true;
			}

			Vertex rpvtx=vertices.get(rp.vName);
			for(String nbr: rpvtx.neighbours.keySet())
			{
				if(!visited.contains(nbr))
				{
					Pair np=new Pair(nbr,rp.pathSoFar+nbr);

					stack.addFirst(np);
				}
			}			
		}
		return false;
	}

	public void bft()
	{
		LinkedList<Pair> queue=new LinkedList<>();
		Set<String> visited=new HashSet<>();

		for(String key: vertices.keySet())
		{
			if(visited.contains(key))
				continue;

			Pair sp=new Pair(key,key);

			queue.addLast(sp);

			while(!queue.isEmpty())
			{
				Pair rp=queue.removeFirst();
				if(visited.contains(rp.vName))
					continue;

				visited.add(rp.vName);

				System.out.println(rp.vName+" "+rp.pathSoFar);
				
				Vertex rpvtx=vertices.get(rp.vName);
				for(String nbr: rpvtx.neighbours.keySet())
				{
					if(!visited.contains(nbr))
					{
						Pair np=new Pair(nbr,rp.pathSoFar+nbr);

						queue.addLast(np);
					}
				}			
			}
		}
	}

	public void dft()
	{
		LinkedList<Pair> stack=new LinkedList<>();
		Set<String> visited=new HashSet<>();

		for(String key: vertices.keySet())
		{
			if(visited.contains(key))
				continue;
			
			Pair sp=new Pair(key,key);

			stack.addFirst(sp);

			while(!stack.isEmpty())
			{
				Pair rp=stack.removeFirst();
				if(visited.contains(rp.vName))
					continue;

				visited.add(rp.vName);

				System.out.println(rp.vName+" "+rp.pathSoFar);
				
				Vertex rpvtx=vertices.get(rp.vName);
				for(String nbr: rpvtx.neighbours.keySet())
				{
					if(!visited.contains(nbr))
					{
						Pair np=new Pair(nbr,rp.pathSoFar+nbr);

						stack.addFirst(np);
					}
				}			
			}
		}
	}

	public boolean isCyclic()
	{
		LinkedList<Pair> queue=new LinkedList<>();
		Set<String> visited=new HashSet<>();

		for(String key: vertices.keySet())
		{
			if(visited.contains(key))
				continue;

			Pair sp=new Pair(key,key);

			queue.addLast(sp);

			while(!queue.isEmpty())
			{
				Pair rp=queue.removeFirst();
				if(visited.contains(rp.vName))
					return true;

				visited.add(rp.vName);
				
				Vertex rpvtx=vertices.get(rp.vName);
				for(String nbr: rpvtx.neighbours.keySet())
				{
					if(!visited.contains(nbr))
					{
						Pair np=new Pair(nbr,rp.pathSoFar+nbr);

						queue.addLast(np);
					}
				}			
			}
		}
		return false;
	}

	public boolean isConnected()
	{
		LinkedList<Pair> queue=new LinkedList<>();
		Set<String> visited=new HashSet<>();

		int flag=0;

		for(String key: vertices.keySet())
		{
			if(visited.contains(key))
				continue;

			flag++;

			Pair sp=new Pair(key,key);

			queue.addLast(sp);

			while(!queue.isEmpty())
			{
				Pair rp=queue.removeFirst();
				if(visited.contains(rp.vName))
					continue;

				visited.add(rp.vName);
				
				Vertex rpvtx=vertices.get(rp.vName);
				for(String nbr: rpvtx.neighbours.keySet())
				{
					if(!visited.contains(nbr))
					{
						Pair np=new Pair(nbr,rp.pathSoFar+nbr);

						queue.addLast(np);
					}
				}			
			}
		}
		if(flag>=2)
			return false;
		return true;
	}

	public boolean isTree()//a tree always has n-1 edges
	{
		return !isCyclic() && isConnected();
	}

	public ArrayList<ArrayList<String>> getConnectedComponents()
	{
		LinkedList<Pair> queue=new LinkedList<>();
		Set<String> visited=new HashSet<>();
		ArrayList<ArrayList<String>> ans=new ArrayList<>();
		for(String key: vertices.keySet())
		{
			if(visited.contains(key))
				continue;

			ArrayList<String> subans=new ArrayList<>();

			Pair sp=new Pair(key,key);

			queue.addLast(sp);

			while(!queue.isEmpty())
			{
				Pair rp=queue.removeFirst();
				if(visited.contains(rp.vName))
					continue;

				visited.add(rp.vName);

				subans.add(rp.vName);
				
				Vertex rpvtx=vertices.get(rp.vName);
				for(String nbr: rpvtx.neighbours.keySet())
				{
					if(!visited.contains(nbr))
					{
						Pair np=new Pair(nbr,rp.pathSoFar+nbr);

						queue.addLast(np);
					}
				}			
			}
			ans.add(subans);
		}
		return ans;
	}

	/* 
	A spanning tree is a subset of Graph G which has all vertices covered with minimum
	possible number of edges. Hence, a spanning tree does not have cycles and it cannot be disconnected.

	Properites:
	1. A connected graph G can have more than one spanning tree.
	2. Spanning tree has exactly n-1 edges, where n is the number of nodes.
	3. All posssible spanning trees of a graph G have the same number of edges and vertices.
	4. The spanning tree does not have any cycle.
	5. Removing one edge from the spanning tree will make the graph disconnected, i.e. the spanning tree
		is minimally connected.
	6. Adding one edge to the spanning tree will create a circuit or loop, i.e. the spanning tree is maximally acyclic. 
	
	Minimum Spanning Tree (MST) :
	In a weighted graph, a minimum spanning tree is a spanning tree that has 
	minimum weight than all other spanning trees of the same graph.

	*/

	/*============================================================================================ 
	Prim's Algorithm */
	private class PrimsPair implements Comparable<PrimsPair>
	{
		String vname;
		String acqvname;
		int cost;

		@Override
		public int compareTo(PrimsPair other)
		{
			return this.cost-other.cost;
		}
	}

	public Graph prims()
	{
		Graph mst = new Graph();
		
		HashMap<String,PrimsPair> map=new HashMap<>();
		PriorityQueue<PrimsPair> heap=new PriorityQueue<>();

		// make a pair and put in heap and map
		for(String key: vertices.keySet())
		{
			PrimsPair np=new PrimsPair();
			np.vname=key;
			np.acqvname=null;
			np.cost=Integer.MAX_VALUE;

			heap.add(np);
			map.put(key,np);
		}

		while(!heap.isEmpty())
		{
			//remove a pair
			PrimsPair rp=heap.poll();
			map.remove(rp.vname);

			//add to mst
			if(rp.acqvname==null)
				mst.addVertex(rp.vname);
			else
			{
				mst.addVertex(rp.vname);
				mst.addEdge(rp.vname,rp.acqvname,rp.cost); 
			}

			//update the neighbors of removed pair
			for(String nbr: vertices.get(rp.vname).neighbours.keySet())
			{
				if(map.containsKey(nbr))
				{
					int oc=map.get(nbr).cost;
					int nc=vertices.get(rp.vname).neighbours.get(nbr);
					if(nc<oc)
					{
						PrimsPair gp=map.get(nbr);
						gp.acqvname=rp.vname;
						gp.cost=nc;

						heap.remove(gp);
						heap.add(gp);
					}
				}
			}
		}

		return mst;
	}

	//=============================================================================================
	/* ==========================================================================================
	Kruskal's Algorithm:
	Kruskal's Algorithm is used to find the minimum cost spanning tree using the greedy approach.
	For greedy approach, at every stage find a locally optimal solution and it will finally
	lead to a globally optimal solution.
	*/
	public class DisjointSet
	{
		HashMap<String,Node> map=new HashMap<>();

		private class Node
		{
			int rank;
			String data;
			Node parent;
		}

		public void create(String value)
		{
			Node nn=new Node();
			nn.parent=nn;
			nn.data=value;
			nn.rank=0;

			map.put(value,nn);
		}

		public void union(String value1,String value2)// union by rank
		{
			Node n1=map.get(value1);
			Node n2=map.get(value2);

			Node re1=find(n1);
			Node re2=find(n2);

			if(re1.data.equals(re2.data))// if both elements belong to the same set, then simply return
				return;

			if(re1.rank==re2.rank)
			{
				re2.parent=re1;
				re1.rank+=1;
			}
			else if(re1.rank>re2.rank)
			{
				re2.parent=re1;
			}	
			else
			{
				re1.parent=re2;
			}
		}

		public String find(String value)
		{
			return find(map.get(value)).data;
		}
		private Node find(Node node){
			if(node==node.parent)
				return node;
			
			Node rr=find(node.parent);
			node.parent=rr;//path compression
			return rr;
		}
	}

	private class EdgePair implements Comparable<EdgePair>
	{
		String v1;
		String v2;
		int cost;

		@Override
		public int compareTo(EdgePair other)
		{
			return this.cost-other.cost;
		}

		public String toString()
		{
			return v1+"-"+v2+" : "+cost;
		}
	}

	public ArrayList<EdgePair> getAllEdges()
	{
		ArrayList<EdgePair> edges=new ArrayList<>();
		for(String vname: vertices.keySet())
		{
			Vertex vtx=vertices.get(vname);

			for(String nbr: vtx.neighbours.keySet())
			{
				EdgePair ep=new EdgePair();
				ep.v1=vname;
				ep.v2=nbr;
				ep.cost=vtx.neighbours.get(nbr);

				edges.add(ep);
			}
		}
		return edges;
	}

	public void kruskal()
	{
		//sort the edges in increasing order of weights
		ArrayList<EdgePair> edges=getAllEdges();
		Collections.sort(edges);

		DisjointSet set=new DisjointSet();

		//create as many sets as there are vertices
		for(String vname: vertices.keySet())
		{
			set.create(vname);
		}

		//traverse over all the edges
		for(EdgePair edge: edges)
		{
			String re1=set.find(edge.v1);
			String re2=set.find(edge.v2);

			if(re1.equals(re2))
				continue;
			else
			{
				System.out.println(edge);
				set.union(edge.v1,edge.v2);
			}
		}
	}

	//=====================================================================
	//=====================================================================
	/* Dijkstra's Algorithm
	Single Source Shortest Path Algorithm.
	Find minimum cost distance from source vertex to every other vertex.
	Data Structures used: Heap and HashMap. 
	This algorithm will not work in case of negative edge weights. */
	private class DijkstraPair implements Comparable<DijkstraPair>
	{
		String vname;
		String pathSoFar;
		int cost;

		@Override
		public int compareTo(DijkstraPair other)
		{
			return this.cost-other.cost;
		}
	}

	public HashMap<String,Integer> dijkstra(String src)
	{
		HashMap<String,DijkstraPair> map=new HashMap<>();
		HashMap<String,Integer> ans=new HashMap<>();
		PriorityQueue<DijkstraPair> heap=new PriorityQueue<>();

		// make a pair and put in heap and map
		for(String key: vertices.keySet())
		{
			DijkstraPair np=new DijkstraPair();
			np.vname=key;
			np.pathSoFar=null;
			np.cost=Integer.MAX_VALUE;

			if(key.equals(src))
			{
				np.cost=0;
				np.pathSoFar=key;
			}
			heap.add(np);
			map.put(key,np);
		}

		while(!heap.isEmpty())
		{
			//remove a pair
			DijkstraPair rp=heap.poll();
			map.remove(rp.vname);

			//add to "ans" hashmap
			ans.put(rp.vname,rp.cost);

			//update the neighbors of removed pair
			for(String nbr: vertices.get(rp.vname).neighbours.keySet())
			{
				if(map.containsKey(nbr))
				{
					int oc=map.get(nbr).cost;
					int nc=rp.cost+vertices.get(rp.vname).neighbours.get(nbr);
					if(nc<oc)
					{
						DijkstraPair gp=map.get(nbr);
						gp.pathSoFar=rp.pathSoFar+nbr;
						gp.cost=nc;

						heap.remove(gp);
						heap.add(gp);
					}
				}
			}
		}

		return ans;
	}
	//============================================================================================
	//============================================================================================
	/* Bellman Ford
	Single Source Shortest Path Algorithm.\
	Overcomes the case of negative edge weights which is not handled by Dijkstra's algorithm.
	However this algorithm does not work in the presence of negative weight cycle.*/
	public HashMap<String,Integer> bellmanFord(String src) throws Exception
	{
		ArrayList<EdgePair> edges=getAllEdges();

		HashMap<String,Integer> map=new HashMap<>();

		//fill map with infinity for all edges except source
		for(String vname: vertices.keySet())
		{
			map.put(vname,100000);
			if(vname.equals(src))
				map.put(vname,0);
		}

		int V=vertices.size();

		for(int i=1;i<=V;i++)
		{
			for(EdgePair edge: edges)
			{
				int oc=map.get(edge.v2);
				int nc=map.get(edge.v1)+edge.cost;

				if(oc>nc)
				{
					if(i<=V-1)
						map.put(edge.v2,nc);
					else
						throw new Exception("Negative Weight Circle is Present !!!");
				}
			}
		}
		return map;
	}
	//===================================================================================================
	//===================================================================================================
	/* Floyd Warshall :- All Pair Shortest Path (APSP)
	O(V^3) time compleixty.*/

}	