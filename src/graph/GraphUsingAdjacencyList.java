package graph;

import java.util.ArrayList;
import java.util.List;

/*
 0 -- 1
 |   /|\2
 |  / |/
 4 -- 3	
 */

public class GraphUsingAdjacencyList {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(5);

		for(int i=0;i<5;i++) {
			adjList.add(new ArrayList<Integer>());
		}


		addNodes(adjList,0,1);
		addNodes(adjList,0,4);
		addNodes(adjList,1,2);
		addNodes(adjList,1,3);
		addNodes(adjList,1,4);
		addNodes(adjList,2,3);
		addNodes(adjList,3,4);

		printGraph(adjList);

	}

	public static void addNodes(ArrayList<ArrayList<Integer>> adjList, int u, int v) {

		adjList.get(u).add(v);
		adjList.get(v).add(u);

	}

	public static void printGraph(ArrayList<ArrayList<Integer>> adjList) {

		for(List<Integer> list : adjList) {

			System.out.println("List is :");
			System.out.print("Head");
			for(int a : list) {

				System.out.print("->" + a);

			}
			System.out.println();
		}

	}

}
