
public class Helper 
{
	public static void start()
	{
		ADT_Graph graph = new ADT_Graph(6, 0);
		System.out.println("Runnning is empty: " +graph.isEmpty());
		System.out.println("This is the number of verticies: " +graph.numV());
		System.out.println("This is the number of edges: " +graph.numE());
		/*
		graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        */
		 graph.addEdge(0, 1, 4);
         graph.addEdge(1, 2, 3);
         graph.addEdge(2, 3, 2);
         graph.addEdge(1, 3, 5);
         graph.addEdge(1, 4, 7);
         graph.addEdge(3, 4, 2);
         graph.addEdge(0, 4, 4);
         graph.addEdge(4, 5, 4);
         graph.addEdge(3, 5, 6);
         
        
        System.out.println("Checking is edge between 1 and 2...weight is: " +graph.checkIfE(1, 2));
        System.out.println("Checking is edge between 0 and 3...weight is: " +graph.checkIfE(0, 3));
        System.out.println("This is the edge weight between 2 and 3: " +graph.Eweight(2, 3));
		System.out.println("This is the number of edges: " +graph.numE());
        System.out.println("Running is empty: " +graph.isEmpty());
        graph.printGraph();
        Vertex start = new Vertex(0);
        System.out.println("This is the breath first search: ");
        graph.BFS(start);
        graph.deleteEdge(0, 4);
        System.out.println("This is the breath first search after deleting an edge: ");
        graph.BFS(start);
        graph.printGraph();
	}
}
