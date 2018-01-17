// 2.4.1 AreNodesConnected.java
// Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
import java.util.ArrayList;
import java.io.File;
import java.util.List;
import java.nio.charset.StandardCharsets;

public class AreNodesConnected
{
	public boolean AreConnected(Graph a, Graph b)
	{
		if(a == null || b == null)
		{
			return false;
		}

		//Check from both sides
		return IsConnectedTo(a, b) || IsConnectedTo(b, a);
	}

	public boolean IsConnectedTo(Graph a, Graph b)
	{
		ArrayList<Graph> nodes = new ArrayList<Graph>();
		nodes.add(a);

		int nodeSize = nodes.size();
		while(nodeSize != 0)
		{
			Graph currentNode = nodes.remove(nodeSize - 1);

			if(currentNode.isVisited)
			{
				continue;
			}

			currentNode.isVisited = true;

			for(Graph siblingNode : currentNode.nodes)
			{
				if(siblingNode == b)
				{
					return true;
				}

				nodes.add(siblingNode);
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		if(args.length != 3)
		{
			printUsage();
		}

		try
		{
			ArrayList<Graph> edges = new ArrayList<Graph>();

			List<String> lines = File.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8);
			if(lines.size() < 1)
			{
				printUsage();
				return;
			}

			for(String line : lines)
			{
				String[] values = line.split(" ");
				if(values.length == 0)
				{
					continue;
				}
				int nodeId = Integer.parseInt(values[0]);

				edges[nodeId] = new Graph(nodeId);
			}

			for(String line : lines)
			{
				String[] values = line.split(" ");
				if(values.length < 2)
				{
					continue;
				}

				for(int i = 1; i < values.length; i++)
				{
					edges[values[0]].nodes.add(edges[values[i]]);
				}
			}

			String nodeA = args[1];
			String nodeB = args[2];

			String areConnected = AreConnected(nodeA, nodeB) ? " is " : " isn't ";

			System.out.println("Node " + nodeA + areConnected + "connected to node " + nodeB);
		}
		catch(IOException ex)
		{
			System.out.println(ex);
			printUsage();
		}
	}

	static void printUsage()
	{
		System.out.println("Usage: java AreNodesConnected input.txt A B");
		System.out.println("Where input.txt is a txt file containing n lines and each line consists of a");
		System.out.println("unique int for the node data, and a series of space seperated node IDs to");
		System.out.println("connect as siblings and A & B are node IDs to check for a connection");
	}
}
