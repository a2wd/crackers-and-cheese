// 2.3.5 Stack Queue
// Implement a queue using 2 stacks

import java.lang.*;
import java.util.*;

public class StackQueue
{
	Stack front, end;

	StackQueue()
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

	//Model answers
	public int sizeModel()
	{
		return front.size() + end.size();
	}

	public void addModel(int val)
	{
		front.push(val);
	}

	public void shiftStacksModel()
	{
		if(end.isEmpty())
		{
			while(!front.isEmpty())
			{
				end.push(front.pop());
			}
		}
	}

	public int peekModel()
	{
		shiftStacksModel();
		return end.peek();
	}

	public int removeModel()
	{
		shiftStacksModel();
		return end.pop();
	}


	public static void main(String[] args)
	{
		boolean useModel = false;

		if(args.length > 0)
		{
			if(!args[0].toLowerCase().equals("-m"))
			{
				printUsage();
				return;
			}

			useModel = true;
		}

		StackQueue queue = new StackQueue();
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
					System.out.println("Expected a number but got something else: [" + tokens[1] + "]");
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

				if(useModel)
				{
					queue.addModel(value);
				}
				else
				{
					queue.add(value);
				}
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
					if(useModel)
					{
						value = queue.removeModel();
					}
					else
					{
						value = queue.remove();
					}
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
					if(useModel)
					{
						value = queue.peekModel();
					}
					else
					{
						value = queue.peek();
					}
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
		System.out.println("Usage: java StackQueue [-m]");
		System.out.println("The optional flag, -m invokes the program with the model solution");
		System.out.println("StdIn: A series of commands to add, remove, or peek");
		System.out.println("Eg: add 120 would add the value 120 onto the queue");
		System.out.println("Exit with x");
	}
}