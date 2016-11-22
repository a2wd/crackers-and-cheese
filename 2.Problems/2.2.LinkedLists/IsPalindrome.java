// 2.2.7 Is Palindrome
// Given a singly-linked list, determine if it is a palindrome

import java.util.Stack;

public class IsPalindrome
{
	public static boolean isPalindromeModel(Node n)
	{
		Node fast = n;
		Node slow = n;

		Stack<Integer> stack = new Stack<Integer>();

		while(fast != null && fast.next!= null)
		{
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		if(fast != null)
		{
			slow = slow.next;
		}

		while(slow != null)
		{
			int top = stack.pop().intValue();

			if(top != slow.data)
			{
				return false;
			}

			slow = slow.next;
		}

		return true;
	}

	public static boolean isPalindrome(Node n)
	{
		//Quick exit for null lists
		if(n == null)
		{
			return false;
		}

		//Quick exit for size 1 lists
		if(n.next == null)
		{
			return true;
		}

		//Check for size & first/last elements
		Node head = n;
		int size = 1;

		while(head.next != null)
		{
			head = head.next;
			size++;
		}

		//Quick exit for size 2 & 3 lists
		if(head.data == n.data && size < 4)
		{
			return true;
		}

		//Iterate through list
		int headPos = 0;
		int tailPos = size;
		Node tail = head;
		head = n;

		while(headPos < tailPos)
		{
			if(tail.data != head.data)
			{
				return false;
			}	

			tail = head;
			head = head.next;
			headPos++;
			tailPos--;

			for(int t = headPos; t < tailPos; t++)
			{
				tail = tail.next;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			System.out.println("Usage: java IsPalindrome [-m] 1 2 3 4 5 .. n");
			System.out.println("Where 1..n are a series of integers to build into a linked list");
			return;
		}

		boolean useModelMethod = false;
		int i = 0;

		if(args[0].toLowerCase().equals("-m"))
		{
			useModelMethod = true;
			i++;
		}

		Node n = null;

		try
		{
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
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		boolean listIsPalindrome = false;

		if(useModelMethod)
		{
			listIsPalindrome = isPalindromeModel(n);
		}
		else
		{
			listIsPalindrome = isPalindrome(n);
		}


		n.printData();
		System.out.println("IsPalindrome() => " + listIsPalindrome);
	}
}