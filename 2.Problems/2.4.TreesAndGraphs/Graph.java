// An implementation of a graph
import java.util.ArrayList;

public class Graph
{
	public ArrayList<Graph> nodes;
	public boolean isVisited;
	public int data;

	Graph(int data)
	{
		this.data = data;
		this.isVisited = false;
		this.nodes = new ArrayList<Graph>();
	}
}