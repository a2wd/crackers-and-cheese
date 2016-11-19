// 2.1 Remove Duplicates
// Given an unsorted linked list, remove duplicate values.
// Also do this without a buffer.
import java.util.HashMap;

public class RemoveDuplicates
{
	public static void removeDuplicates(Node n)
	{
		if(n == null || n.next == null)
		{
			return;
		}

		HashMap<Integer, Boolean> h = new HashMap<Integer, Boolean>();
		Node prev = new Node(0);
		Node curr = n;

		prev.next = curr;

		while(curr != null)
		{
			if(h.containsKey(new Integer(curr.data))) {
				prev.next = curr.next;
			}
			else {
				h.put(curr.data, new Boolean(true));
				prev = prev.next;
			}

			curr = curr.next;
		}

		return;
	}

	public static void removeDuplicatesWithoutBuffer(Node n)
	{
		if(n == null || n.next == null)
		{
			return;
		}

		Node pointer = n;

		while(pointer != null)
		{
				Node tempPrev = pointer;
				Node tempCurr = pointer.next;

				while(tempCurr != null)
				{
					if(tempCurr.data == pointer.data)
					{
						tempPrev.next = tempCurr.next;
					}
					else
					{
						tempPrev = tempPrev.next;
					}

					tempCurr = tempCurr.next;
				}

				pointer = pointer.next;
		}

		return;
	}

	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			System.out.println("Usage: java RemoveDuplicates 1 2 3 4 5 .. n");
			System.out.println("Where 1..n are a series of integers to build into a linked list");
			return;
		}

		Node n = null;
		boolean withoutBuffer = false;
		int i = 0;

		try
		{

			if(args[0].equals("-w") || args[0].equals("-W"))
			{
				withoutBuffer = true;
				i++;
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

			n.printData();

			if(withoutBuffer)
			{
				removeDuplicatesWithoutBuffer(n);
			}
			else
			{
				removeDuplicates(n);
			}

			n.printData();
		}
		catch(Exception e)
		{
			System.out.println("Unable to build linked list: " + e.toString());
		}
	}
}