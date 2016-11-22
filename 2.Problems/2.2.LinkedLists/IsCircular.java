// 2.2.6 Is Circular
// For a circular linked list, return the element at which the list repeats
// ie: a -> b -> c -> d -> e -> c, IsCircular() => c

import java.util.ArrayList;
import java.util.List;

public class IsCircular
{
	public static Node unlink(Node n)
	{
		while(n != null && n.next != null)
		{
			Node next = n.next;
			n.next = null;
			n = next;
		}

		return n;
	}

	public static Node findLoop(Node n)
	{
		if(n == null || n.next == null)
		{
			return null;
		}

		Node p = n;
		List<Node> l = new ArrayList<Node>();

		while(p != null)
		{
			if(l.contains(p))
			{
				return p;
			}

			l.add(p);
			p = p.next;
		}

		return null;
	}

	public static void main(String[] args)
	{
		if(args.length != 0)
		{
			System.out.println("Usage: java IsCircular");
			System.out.println("A client to demonstrate unlinking a circular linked list");
			return;
		}

		Node n = new Node(1);

		for(int i = 2; i < 6; i++)
		{
			n.appendToTail(i);
		}

		n.printData();

		System.out.println("Hooking up 5 to 2");

		Node runner = n;
		Node tail = null;
		Node middle = null;

		while(runner != null)
		{
			if(runner.data == 2)
			{
				middle = runner;
			}

			if(runner.data == 5)
			{
				tail = runner;
			}

			runner = runner.next;
		}
		tail.next = middle;

		System.out.println("The first 15 items in the loop are:");

		runner = n;
		for(int i = 1; i < 16 && runner != null; i++)
		{
			System.out.print(i + "[" + runner.data + "] ");
			runner = runner.next;
		}
		System.out.println();

		System.out.println("Finding loop");
		Node l = findLoop(n);
		System.out.println("Loop at: " + l.data);

		System.out.println("Unlinking");
		l = unlink(n);
		System.out.println("Loop at: " + l.data);
	}
}