// 2.2.4 Partition Linked List
// Given a singly linked list a value, partition the list so that elements 
// smaller than the value appear before elements greater than it.

import java.util.Scanner;

public class PartitionLinkedList
{
	public static Node addToList(Node list, Node n)
	{
		if(list == null)
		{
			list = n;
		}
		else
		{
			list.next = n;
			list = list.next;
		}

		return list;
	}

	public static Node partitionList(Node list, int val)
	{
		if(list == null)
		{
			return null;
		}

		Node hi = null;
		Node mid = null;
		Node lo = null;
		Node hiHead = null;
		Node midHead = null;
		Node loHead = null;

		while(list != null)
		{
			if(list.data == val)
			{
				mid = addToList(mid, list);

				if(midHead == null)
				{
					midHead = mid;
				}
			}
			else if(list.data < val)
			{
				lo = addToList(lo, list);

				if(loHead == null)
				{
					loHead = lo;
				}
			}
			else
			{
				hi = addToList(hi, list);

				if(hiHead == null)
				{
					hiHead = hi;
				}
			}

			list = list.next;
		}

		if(hi != null)
		{
			hi.next = null;
		}

		if(mid != null)
		{
			mid.next = hiHead;
		}

		if(lo != null && hiHead != null)
		{
			lo.next = hiHead;
		}

		if(lo != null && midHead != null)
		{
			lo.next = midHead;
		}

		if(loHead != null)
		{
			return loHead;
		}

		if(midHead != null)
		{
			return midHead;
		}

		return hiHead;
	}

	public static Node copyList(Node list)
	{
		if(list == null)
		{
			return null;
		}

		Node copy = new Node(list.data);
		Node head = copy;

		list = list.next;

		while(list != null)
		{
			copy.next = new Node(list.data);
			copy = copy.next;
			list = list.next;
		}

		return head;
	}

	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			System.out.println("Usage: java PartitionLinkedList 1 2 3 4 5 .. n");
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

			n.printData();

			System.out.println("Enter an integer to partition the list around, or x to quit");

			Scanner s = new Scanner(System.in);

			while(!s.hasNext("x"))
			{
				int val = s.nextInt();

				Node c = copyList(n);
				c = partitionList(c, val);
				c.printData();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}