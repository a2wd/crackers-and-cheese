// 2.3.5 My Queue
// Implement a queue using 2 stacks

import java.lang.*;
import java.util.*;

public class MyQueue
{
	Stack front, end;

	MyQueue()
	{
		this.front = new Stack();
		this.end = new Stack();
	}

	public void add(int val)
	{
		while(!front.isEmpty())
		{
			end.push(front.pop());
		}

		end.push(val);
	}

	public int remove()
	{
		if(front.isEmpty() && end.isEmpty())
		{
			throw new EmptyStackException();
		}

		while(!end.isEmpty())
		{
			front.push(end.pop());
		}

		return front.pop();
	}

	public int peek()
	{
		if(front.isEmpty() && end.isEmpty())
		{
			throw new EmptyStackException();
		}

		while(!end.isEmpty())
		{
			front.push(end.pop());
		}

		return front.peek();
	}


	public static void main(String[] args)
	{
		if(args.length > 0)
		{
			printUsage();
			return;
		}

		MyQueue queue = new MyQueue();
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

			if(operation.equals("add"))
			{
				if(tokens.length != 2)
				{
					System.out.println("Usage: add n where n is an integer");
					continue;
				}

				queue.add(value);
			}

			if(operation.equals("remove"))
			{
				if(tokens.length != 1)
				{
					System.out.println("Usage: remove");
					continue;
				}

				try
				{
					value = queue.remove();
				}
				catch(Exception e)
				{
					System.out.println("There are no more values in the queue: " + e);
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
					value = queue.peek();
				}
				catch(Exception e)
				{
					System.out.println("There are no more values in the queue: " + e);
					continue;
				}
				
				System.out.println(value);
			}
		}
	}

	static void printUsage()
	{
		System.out.println("Usage: java MyQueue");
		System.out.println("StdIn: A series of commands to add, remove, or peek");
		System.out.println("Eg: add 120 would add the value 120 onto the queue");
		System.out.println("Exit with x");
	}
}