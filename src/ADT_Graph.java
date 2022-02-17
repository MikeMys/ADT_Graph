import java.util.ArrayList;
import java.util.LinkedList;

public class ADT_Graph implements ADT_Graph_Interface
{
	private int v;
	//int matrix[][];
	private Vertex matrix[][];
	//int weight;
	
	/**
	 * Constructor to create an empty undirected graph
	 * @param ver number of vertex
	 */
	public ADT_Graph(int ver)		//accepts vertex
	{
		//this.vertex = new Vertex(v);
		this.v = ver;
		//matrixx = new Vertex[v][v];
		this.matrix = new Vertex[v][v];
	}
	
	/**
	 * Constructor to create an empty weighted graph
	 * @param ver number of vertex
	 * @param weight weight of vertex
	 */
	public ADT_Graph(int ver, int weight)		//accepts vertex
	{
		//this.vertex = new Vertex(v);
		this.v = ver;
		this.matrix = new Vertex[v][v];
		for(int i=0; i<v; i++)
		{
			for(int j=0; j<v;j++)
			{
				this.matrix[i][j] = new Vertex();
				this.matrix[i][j].setWeight(0);
				this.matrix[i][j].setColor("White");
			}
		}
		
	}
	
	/**
	 * sets the location of in and out to 1 as a default, does this for their mirror as well since it is an unweighted graph
	 * @param in first position of matrix
	 * @param out second position of matrix
	 */
	public void addEdge(int in, int out)
	{
		this.matrix[in][out].setWeight(1);
		
		this.matrix[out][in].setWeight(1);	//this is for any undirected graphs
	}
	
	/**
	 * Sets the matrix location to be the weight, since its directed
	 * @param in first position of matrix
	 * @param out second position of matrix
	 * @param w weight value
	 */
	public void addEdge(int in, int out, int w)
	{
		
		this.matrix[in][out].setWeight(w);
		
	}
	
	/**
	 * Placing a 0 into this matrix is considered deleted
	 * @param in first vertex in the matrix
	 * @param out second vertex in the matrix
	 */
	public void deleteEdge(int in, int out)
	{
		this.matrix[in][out].setWeight(0);
	}
	/**
	 * Checks through each location in the matrix to see if there is anthing is not equal to 0 (filled)
	 * @return true is matrix is empty, false otherwise
	 */
	public boolean isEmpty()
	{
		for(int i = 0; i < v; i++)
		{
			for(int j = 0; j < v; j++)
			{
				if(matrix[i][j].getWeight()!=0)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @return number of vertex in the matrix
	 */
	public int numV()
	{
		return v;
	}
	
	/**
	 * Decides whether it is an undirected or directed graph based on if matrix[i][j] == matrix[j][i]
	 * @return number of edges in the matrix
	 */
	public int numE()
	{
		boolean undirected = false;
		int count = 0;
		for(int i = 0; i < v; i++)
		{
			for(int j = 0; j < v; j++)
			{
				if(matrix[i][j].getWeight()!=0)
				{
					if(matrix[i][j] == matrix[j][i])
						undirected = true;
					count++;
				}
			}
		}
		if(undirected == true)
			return count/2;
		else
			return count;
	}
	
	/**
	 * 
	 * @param in first position of matrix
	 * @param out second position of matrix
	 */
	public int checkIfE(int in, int out)
	{
		if(matrix[in][out].getWeight() != 0)
		{
			if(matrix[in][out].getWeight() == 1)
				return 1;
			else
				return matrix[in][out].getWeight();
		}
		else
			return 0;
	}
	
	/**
	 * @param in first position of matrix
	 * @param out second position of matrix
	 * @return	weight of edge
	 */
	public int Eweight(int in, int out)
	{
		return matrix[in][out].getWeight();
	}
	
	/**
	 * This method takes in an initial vertex, and will add it to the queue, the loop will keep running until the queue is empty
	 * vertecies that are connected to s, by and edge, will be added to the queue as well and their colors will turn to gray
	 * Once a vertex has all of its adjacent vertices turned to gray, it will be turned to black and you will pop it off of the queue
	 * (Using poll) and then you will proceed to the next vertex that was added to the queue. This continues until all verticies are black
	 * Note: After a black vertex is popped off, it is printed to show the order that was traveled in the search
	 * Also: Since this is in a weighted graph, if there are no adjacent vertices, only the initial vertex will be printed
	 * @param s the vertex that the BFS will start on
	 */
	public void BFS(Vertex s)
	{
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		//queue holds vertex corresponding to the number 
		s.setColor("Gray");
		queue.add(s);
		ArrayList<Integer> before = new ArrayList<Integer>();
		ArrayList<String> check = new ArrayList<String>();
		while(queue.size() != 0)
		{
			//Dequeue and print
			s.setColor("Black");
			before.add(s.getNum());
			check.add(s.getColor());
			s = queue.poll();
			System.out.println(s.getNum()+" ");
			
			//Get all adjacent vertecis of dequeu vertex, if not gray then make gray
			for(int i=0; i<v; i++) 
			{
				if(matrix[s.getNum()][i].getWeight()!=0)
				{
					if(before.contains(i))
					{
					}
					else
					{
						before.add(i);
						Vertex hold = new Vertex(i);
						hold.setColor("Gray");
						queue.add(hold);
					}
				}
			}
		}
		System.out.println(check);
	}
	
	
	public void printGraph()
	{
        for (int i = 0; i < v; i++) 
        {
            for (int j = 0; j <v ; j++) 
            {
                System.out.print(matrix[i][j].getWeight()+ " ");
            }
            System.out.println();
        }
		
		for (int i = 0; i < v; i++) 
		{
            System.out.print("Vertex " + i + " is connected to: ");
            for (int j = 0; j <v ; j++) 
            {
                if(matrix[i][j].getWeight()!=0)
                {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}
