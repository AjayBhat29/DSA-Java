	void dijkstra(int source,ArrayList<ArrayList<Node>> adj,int N){
	    int []dist=new int[N];
	    Arrays.fill(dist,10000001);
	    
	    dist[src]=0;
	    
	    PriorityQueue<Node> pq=new PriorityQueue<>();
	    pq.add(new Node(src,dist[src]));
	    
	    while(!pq.isEmpty()){
	        Node node=pq.poll();
	        
	        for(Node nbr:adj.get(node.getValue())){
	            if(dist[node.getValue()]+nbr.getWeight()<dist[nbr.getValue()]){
	                dist[nbr.getValue()]=dist[node.getValue()]+nbr.getWeight();
	                pq.add(new Node(nbr.getValue(),dist[nbr.getValue()]));
	            }
	        }
	    }
	    
	    for(int i=0;i<N;i++){
	        System.out.print(dist[i]+" ");
	    }
	}
	
	private class Node implements Comparable<Node>{
	    int value;
	    int weight;
	    
	    public Node(int v,int w){
	        this.value=v;
	        this.weight=w;
	    }
	    
	    int getValue(){
	        return this.value;
	    }
	    
	    int getWeight(){
	        return this.weight;
	    }
	    
	    public int compareTo(Node other){
	        return this.weight-other.weight;
	    }
	} 
