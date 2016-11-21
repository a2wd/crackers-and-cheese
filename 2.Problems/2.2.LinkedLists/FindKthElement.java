// 2.2.2 Find Kth Element
// Given a singly linked list, find the Kth to last element

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindKthElement
{
	public static Node findKthElement(int k, Node n)
	{
		if(n == null || k < 0)
		{
			return null;
		}

		int size = 0;
		Node pointer = n;

		while(pointer != null)
		{
			pointer = pointer.next;
			size++;
		}

		if(k > size - 1)
		{
			return null;
		}

		int stepsToElement = size - k - 1;
		pointer = n;

		while(stepsToElement > 0)
		{
			stepsToElement--;
			pointer = pointer.next;
		}

		return pointer;
	}

	public static Node findKthElementOnePass(int k, Node n)
	{
		if(n == null || k < 0)
		{
			return null;
		}

		List<Node> l = new ArrayList<Node>();
		Node pointer = n;

		while(pointer != null)
		{
			l.add(pointer);
			pointer = pointer.next;
		}

		int element = l.size() - k - 1;

		if(element < 0 || element >= l.size())
		{
			return null;
		}

		return l.get(element);
	}

	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			System.out.println("Usage: java FindKthElement [-s] 1 2 3 4 5 .. n");
			System.out.println("Where -s is an optional flag to use an additional data structure and make one pass");
			System.out.println("and 1..n are a series of integers to build into a linked list");
			return;
		}

		Node n = null;

		try
		{
			int i = 0;
			boolean useOnePass = false;

			if(args[0].equals("-s") || args[0].equals("-S"))
			{
				i++;
				useOnePass = true;
			}

			for(; i < args.length; i++)
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

			System.out.println("Enter an integer K to return the Kth to last element of the following linked list, or -1 to exit");
			n.printData();


			Scanner s = new Scanner(System.in);
			int k = s.nextInt();

			while(k != -1)
			{
				Node KthNode = null;

				if(useOnePass)
				{
					KthNode = findKthElementOnePass(k, n);
				}
				else
				{
					KthNode = findKthElement(k, n);
				}

				if(KthNode == null)
				{
					System.out.println("That is out of the bounds of the linked list");
				}
				else
				{
					System.out.println(KthNode.data);
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