// An implementation of a graph
import java.util.ArrayList;

public class Graph
{
	public ArrayList<Graph> children;
	public int data;

	Graph(int data)
	{
		this.data = data;
		children = new ArrayList<Graph>();
	}
}