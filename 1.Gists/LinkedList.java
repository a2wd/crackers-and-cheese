// An implementation of a simple linked list
import java.util.Scanner;

public class LinkedList<E>
{
	//Linked list implementation
	private E e;
	public LinkedList<E> next = null;

	public LinkedList(E e)
	{
		this.e = e;
	}

	public E Get()
	{
		return this.e;
	}

	public void Set(E e)
	{
		this.e = e;
	}

	public void AddNode(E nodeValue)
	{
		LinkedList<E> pointer = this;
		while(pointer.next != null)
		{
			pointer = pointer.next;
		}

		pointer.next = new LinkedList<E>(nodeValue);
	}

	public LinkedList<E> DeleteNode(LinkedList<E> head, E nodeValue)
	{
		LinkedList<E> pointer = head;

		if(head.Get() == nodeValue)
		{
			return head.next;
		}

		while(pointer.next != null)
		{
			if(pointer.next.Get() == nodeValue)
			{
				pointer.next = pointer.next.next;
				return head;
			}

			//else
			pointer = pointer.next;
		}

		return head;
	}

	public void PrintValues()
	{
		LinkedList<E> pointer = this;

		System.out.print("Linked list:");

		while(pointer != null)
		{
			System.out.print(" " + pointer.Get());

			pointer = pointer.next;
		}

		System.out.println();
	}

	//Linked list client
	public static void main(String args[])
	{
		if(args.length == 0)
		{
			System.out.println("Usage: java LinkedList x1 x2 x3 ... xn");
			System.out.println("Where x1 ... xn are a series of integers to add to the linked list");
			return;
		}

		LinkedList<Integer> l = null;

		for(int i = 0; i < args.length; i++)
		{
			Integer j;

			try
			{
				j = Integer.parseInt(args[i]);

				if(l == null)
				{
					l = new LinkedList<Integer>(j);
				}
				else
				{
					l.AddNode(j);
				}
			}
			catch(Exception e)
			{
				System.out.println("There was a problem building the linked list: " + e);
			}
		}

		l.PrintValues();

		System.out.println("\nTo delete an item, type its value, to exit, type 0");

		Scanner s = new Scanner(System.in);

		Integer i = null;
		while(i == null || i != 0)
		{
			i = s.nextInt();

			if(i != 0)
			{
				l = l.DeleteNode(l, i);
			}

			if(l == null)
			{
				return;
			}

			l.PrintValues();
		}
	}
}