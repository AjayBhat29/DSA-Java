private void shortestPath(ArrayList<ArrayList<Integer>> adj,int N,int src){
	    int []dist=new int[N];
	    Arrays.fill(dist,100000);
	    
	    Queue<Integer> q=new LinkedList<>();
	    q.add(src);
	    dist[src]=0;
	    
	    while(!q.isEmpty()){
	        int node=q.poll();
	        for(int nbr:adj.get(node)){
	            if(dist[node]+1<dist[nbr]){
	                dist[nbr]=dist[node]+1;
	                q.add(nbr);
	            }
	        }
	    }
	    
	    for(int i=0;i<N;i++)
	        System.out.print(dist[i]+" ");
	}
