
public interface ADT_Graph_Interface 
{
	void addEdge(int in, int out);
	
	void addEdge(int in, int out, int weight);
	
	void deleteEdge(int in, int out);
	
	boolean isEmpty();
	
	int numV();
	
	int numE();
	
	int checkIfE(int in, int out);
	
	int Eweight(int in, int out);
	
	void printGraph();
	
	
}
