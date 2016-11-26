// 2.3.2 Min Stack
// Implement a stack which in addition to push, poop & peek also has a min method to return the minimum value.
// All operations should run in O(n) time.

import java.util.Scanner;
import java.util.EmptyStackException;

public class MinStack
{
	Node stack, mins;

	public void push(int val)
	{
		Node newNode = new Node(val);

		if(stack == null)
		{
			stack = newNode;
			mins = new Node(val);
			return;
		}

		newNode.next = stack;
		stack = newNode;

		if(val <= mins.data)
		{
			Node newMin = new Node(val);
			newMin.next = mins;
			mins = newMin;
		}
	}

	public int pop()
	{
		if(stack == null)
		{
			throw new EmptyStackException();
		}

		int val = stack.data;
		stack = stack.next;

		if(val == mins.data)
		{
			mins = mins.next;
		}

		return val;
	}

	public int min()
	{
		if(mins == null)
		{
			throw new EmptyStackException();
		}

		return mins.data;
	}

	public int peek()
	{
		if(stack == null)
		{
			throw new EmptyStackException();
		}

		return stack.data;
	}

	public static void main(String[] args)
	{
		if(args.length != 0)
		{
			System.out.println("Usage: java MinStack");
			System.out.println("StdIn: A series of commands to push, peek, pop or view the min");
			System.out.println("Eg: push 120 would push the value 120 onto the stack");
			System.out.println("Exit with x");
			return;
		}

		MinStack stack = new MinStack();
		Scanner scanner = new Scanner(System.in);

		while(true)
		{
			String s = scanner.nextLine();

			int value = 0;
			String[] tokens = s.split(" ");
			String operation = tokens[0].toLowerCase();

			if(operation.equals("x"))
			{
				return;
			}

			if(tokens.length == 2)
			{
				try
				{
					value = Integer.parseInt(tokens[1]);
				}
				catch(Exception e)
				{
					System.out.println("Expected a number but got something else: " + e);
					continue;
				}
			}

			if(operation.equals("push"))
			{
				if(tokens.length != 2)
				{
					System.out.println("Usage: push n where n is an integer");
					continue;
				}

				stack.push(value);
			}

			if(operation.equals("pop"))
			{
				if(tokens.length != 1)
				{
					System.out.println("Usage: pop");
					continue;
				}

				try
				{
					value = stack.pop();
				}
				catch(Exception e)
				{
					System.out.println("There are no more values in stack " + value);
					continue;
				}

				System.out.println(value);
			}

			if(operation.equals("peek"))
			{
				if(tokens.length != 1)
				{
					System.out.println("Usage: peek");
					continue;
				}

				try
				{
					value = stack.peek();
				}
				catch(Exception e)
				{
					System.out.println("There are no more values in stack " + value);
					continue;
				}
				
				System.out.println(value);
			}

			if(operation.equals("min"))
			{
				if(tokens.length != 1)
				{
					System.out.println("Usage: min");
					continue;
				}

				try
				{
					value = stack.min();
				}
				catch(Exception e)
				{
					System.out.println("There are no more values in stack " + value);
					continue;
				}
				
				System.out.println(value);
			}
		}
	}
}