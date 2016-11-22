// 2.2.5 Sum Linked Lists
// Sum the values of two linked lists stored in reverse order and return the sum as a linked list (3 -> 2 -> 1 = 123)
// eg. 3->3->3 + 9->2->1 = 2->6->4 (129 + 333 = 462)
// Also sum the lists when stored in forward order (1 -> 2 -> 3 = 123)

import java.util.Scanner;

public class SumLinkedLists
{
	public static Node sumReverseOrderLists(Node a, Node b)
	{
		Node sumList = null;
		Node head = null;


		if(a == null && b == null)
		{
			return sumList;
		}

		int carry = 0;

		while(a != null || b != null || carry != 0)
		{
			int i = a == null ? 0 : a.data;
			int j = b == null ? 0 : b.data;

			// Move list pointers to next items
			if(a != null)
			{
				a = a.next;
			}

			if(b != null)
			{
				b = b.next;
			}

			// Calculate this digit's value
			int sum = i + j + carry;

			if(sum > 9)
			{
				carry = 1;
				sum = sum - 10;
			}
			else
			{
				carry = 0;
			}

			// Add this digit's value to the sum
			Node digit = new Node(sum);

			if(sumList == null) {
				sumList = digit;
				head = sumList;
			}
			else
			{
				sumList.next = digit;
				sumList = sumList.next;
			}
		}

		return head;
	}

	private static int sumHelper(Node n)
	{
		int sum = 0;

		while(n != null)
		{
			sum *= 10;
			sum += n.data;
			n = n.next;
		}

		return sum;
	}

	public static Node sumForwardOrderLists(Node a, Node b)
	{
		Node sumList = null;

		if(a == null && b == null)
		{
			return sumList;
		}

		int i = sumHelper(a);
		int j = sumHelper(b);
		int sum = i + j;

		while(sum > 0)
		{
			int digit = sum % 10;
			sum /= 10;

			Node tail = new Node(digit);
			tail.next = sumList;
			sumList = tail;
		}		

		return sumList;
	}

	public static Node GetListFromScanner(Scanner s)
	{
		if(!s.hasNextLine())
		{
			return null;
		}

		Node n = null;

		try
		{
			String line = s.nextLine();
			String[] values = line.split(" ");

			for(int i = 0; i < values.length; i++)
			{
				int digit = Integer.parseInt(values[i]);

				if(digit < 0 || digit > 9)
				{
					return null;
				}

				if(n == null)
				{
					n = new Node(digit);
				}
				else
				{
					n.appendToTail(digit);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}

		return n;
	}

	public static void main(String[] args)
	{
		if(args.length > 1)
		{
			System.out.println("Usage: java [-f] SumLinkedLists");
			System.out.println("StdIn: a series of single digit integers on two lines representing linked lists to sum");
			System.out.println("Where the lists are stored in reverse order (244 = 4->4->2)");
			System.out.println("Unless the optional flag -f is passed to indicate the lists are stored in forward order (244 = 2->4->4)");
			return;
		}

		boolean forwardSum = false;

		if(args.length == 1 && args[0].toLowerCase().equals("-f"))
		{
			forwardSum = true;
		}

		Scanner s = new Scanner(System.in);
		Node a = GetListFromScanner(s);
		Node b = GetListFromScanner(s);

		if(a == null || b == null)
		{
			System.out.println("Please enter two lists of single-digit integers on consecutive lines");
			return;
		}

		Node sum = null;

		if(forwardSum)
		{
			sum = sumForwardOrderLists(a, b);
		}
		else
		{
			sum = sumReverseOrderLists(a, b);
		}

		if(sum == null)
		{
			System.out.println("Please enter two lists of single-digit integers on consecutive lines");
			return;
		}

		System.out.println("The sum of the two linked lists");
		a.printData();
		b.printData();
		System.out.println("Is:");
		sum.printData();
	}
}