// 2.2.3 Delete Node
// Implement an algorithm to delete a node in the middle of a singly linked list
// Given that node.

import java.util.Scanner;

public class DeleteNode
{
	public static Node deleteNode(Node n, Node list)
	{
		// Handle null values
		if(n == null || list == null)
		{
			return null;
		}

		//Handle first element removal
		if(n == list)
		{
			return list.next;
		}

		Node prev = new Node(0);
		Node curr = list;
		prev.next = curr;

		while(curr != null)
		{
			if(curr == n)
			{
				prev.next = curr.next;
				return list;
			}

			prev = prev.next;
			curr = curr.next;
		}

		return list;
	}

	public static Node findNode(int i, Node list)
	{
		Node n = list;

		while(n != null)
		{
			if(n.data == i)
			{
				return n;
			}

			n = n.next;
		}

		return n;
	}

	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			System.out.println("Usage: java DeleteNode 1 2 3 4 5 .. n");
			System.out.println("Where 1..n are a series of integers to build into a linked list");
			return;
		}

		Node n = null;

		try
		{
			for(int i = 0; i < args.length; i++)
			{
				int val = Integer.parseInt(args[i]);

				if(n == null)
				{
					n = new Node(val);
				}
				else
				{
					n.appendToTail(val);
				}
			}	

			System.out.println("Enter an integer n to delete an element from the linked list, or -1 to quit");
			n.printData();


			Scanner s = new Scanner(System.in);
			int k = s.nextInt();

			while(k > -1)
			{
				Node el = findNode(k, n);
				if(el == null)
				{
					System.out.println("That element could not be found");
				}
				else
				{
					n = deleteNode(el, n);

					if(n == null)
					{
						System.out.println("You have deleted the last element");
						return;
					}

					n.printData();
				}

				k = s.nextInt();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}