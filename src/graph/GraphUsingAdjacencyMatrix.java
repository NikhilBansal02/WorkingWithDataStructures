package graph;

/*
0 -- 1
|   /|\2
|  / |/
4 -- 3	
*/
public class GraphUsingAdjacencyMatrix {
	
	int adj[][];
	int vertices;
	
	public GraphUsingAdjacencyMatrix(int vertices) {
		this.vertices = vertices;
		this.adj = new int[vertices][vertices];
	}
	
	/**
	 * @param i, row
	 * @param j, column 
	 * @param w, weight
	 */
	public void createGraph(int i,int j, int w) {
		
		adj[i][j] = w;
		adj[j][i] = w;
	}
	
	/**
	 * @param i, row
	 * @param j, column 
	 */
	public void removeEdgeInGraph(int i,int j) {
		
		adj[i][j] = 0;
		adj[j][i] = 0;
		
	}
	
	public String toString() {
	    StringBuilder s = new StringBuilder();
	    for (int i = 0; i < vertices; i++) {
	      s.append(i + ": ");
	      for (int j : adj[i]) {
	        s.append((j==1 ? 1 : 0) + " ");
	      }
	      s.append("\n");
	    }
	    return s.toString();
	  }
	
	public static void main(String[] args) {
		
		GraphUsingAdjacencyMatrix graph = new GraphUsingAdjacencyMatrix(5);
		graph.createGraph(0, 1, 1); // Added weights as 1 for all edges for now.
		graph.createGraph(0, 4, 1); // if weight are present then tohse can be passed.
		graph.createGraph(1, 2, 1);
		graph.createGraph(1, 3, 1);
		graph.createGraph(1, 4, 1);
		graph.createGraph(2, 3, 1);
		graph.createGraph(3, 4, 1);
		
		System.out.println(graph.toString());
		
		
	}

}
