import java.util.*;

class Graph
{
  ArrayList<Graph> adjacent;
  boolean visited;
  Object data;

  Graph(Object data)
  {
    this.data = data;
    this.adjacent = new ArrayList<Graph>();
    this.visited = false;
  }
}

public class GraphDfsBfs
{
  public static void bfs(Graph root)
  {
    if(root == null)
    {
      return;
    }

    visit(root);
    root.visited = true;

    for(Graph n : root.adjacent)
    {
      if(n.visited == false)
      {
        bfs(n);
      }
    }
  }

  public static void dfs(Graph root)
  {
    Queue queue = new Queue();
    visit(root);
    queue.enqueue(root);

    while(!queue.isEmpty())
    {
      Graph n = (Graph) queue.dequeue();
      for(Graph a : n.adjacent)
      {
        if(a.visited == false)
        {
          visit(a);
          a.visited = true;
          queue.enqueue(a);
        }
      }
    }
  }

  public static void visit(Graph g)
  {
    if(g != null)
    {
      System.out.println("Visiting " + g.data.toString());
    }
  }

  public static void main(String[] args)
  {
    System.out.println("Graph searching");
  }
}
