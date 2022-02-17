
public class Vertex 
{
	String color;
	int num;
	int weight;
	
	/**
	 * Creates an empty vertex
	 */
	public Vertex()
	{
		
	}
	
	/**
	 * Creates a vertex with number label, num
	 * Sets the weight to zero and color to white as a base
	 * @param num the label for the vertex
	 */
	public Vertex(int num)
	{
		this.num = num;
		this.color = "White";
		this.weight = 0;
	}
	
	/**
	 * @return the number label of a vertex
	 */
	public int getNum()
	{
		return num;
	}
	/**
	 * Sets the number label of a vertex
	 * @param num the label sent by the user
	 */
	public void setNum(int num)
	{
		this.num = num;
	}
	/**
	 * @return the color of the vertex
	 */
	public String getColor()
	{
		return this.color;
	}
	/**
	 * Sets the color label of a vertex
	 * @param color the color the user inputs
	 */
	public void setColor(String color)
	{
		this.color = color;
	}
	/**
	 * Sets the weight label of a vertex
	 * @param weight the weight set by the user
	 */
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
	/**
	 * @return the weight of a vertex
	 */
	public int getWeight()
	{
		return weight;
	}
	
}
