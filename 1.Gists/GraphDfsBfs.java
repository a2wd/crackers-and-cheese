class Graph
{
  List<Graph> adjacent;
  boolean visited;
  Object data;

  Graph(Object data)
  {
    this.data = data;
    this.adjacent = new List<Graph>();
    this.visited = false;
  }
}

public class GraphDfsBfs
{
  void bfs(Graph root)
  {
    if(root == null)
    {
      return;
    }

    //visit(root);
    root.visited = true;

    for(Graph n : root.adjacent)
    {
      if(n.visited == false)
      {
        bfs(n);
      }
    }
  }

  void dfs(Graph root)
  {
    Queue q = new Queue();
    visit(root);
    queue.enqueue(root);

    while(!queue.isEmpty())
    {
      Graph n = queue.dequeue();
      for(Graph a : n.adjacent)
      {
        if(a.visited == false)
        {
          //visit(a);
          a.visited = true;
          queue.enqueue(a);
        }
      }
    }
  }

  public static void main()
  {
    System.out.println("Graph searching");
  }
}
