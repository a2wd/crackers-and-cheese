// 2.3.3 Set of Stacks
// Implement a stack which consists of multiple stacks each no bigger than some max value

import java.lang.*;
import java.util.*;

public class SetOfStacks
{
	List<Node> stacks;
	Node currentSubstack;
	int currentHeight;

	final int maxHeight;

	SetOfStacks(int height)
	{
		if(height < 1)
		{
			throw new ArrayIndexOutOfBoundsException();
		}

		this.maxHeight = height;

		stacks = new ArrayList<Node>();
		currentHeight = 0;
		currentSubstack = null;
	}

	public int peek()
	{
		if(currentSubstack == null)
		{
			if(stacks.size() == 0)
			{
				throw new EmptyStackException();
			}

			int lastStack = stacks.size() - 1;
			Node tempStack = stacks.get(lastStack);
			return tempStack.data;
		}

		return currentSubstack.data;
	}

	public void push(int value)
	{
		currentHeight++;
		Node newNode = new Node(value);

		if(currentSubstack == null)
		{
			currentSubstack = newNode;
			return;
		}

		newNode.next = currentSubstack;
		currentSubstack = newNode;

		if(currentHeight == maxHeight)
		{
			stacks.add(currentSubstack);
			currentSubstack = null;
			currentHeight = 0;
		}
	}

	public void moveToNextStack()
	{
		int stacksSize = stacks.size();
		if(stacksSize == 0)
		{
			throw new EmptyStackException();
		}

		currentSubstack = stacks.remove(stacksSize - 1);
		currentHeight = currentSubstack.size();
	}

	public int pop()
	{
		if(currentSubstack == null)
		{
			moveToNextStack();
		}

		int val = currentSubstack.data;
		currentSubstack = currentSubstack.next;
		currentHeight--;

		if(currentHeight == 0 && stacks.size() > 0)
		{
			moveToNextStack();
		}

		return val;
	}

	public int popAt(int stackIndex)
	{
		int stacksSize = stacks.size();

		if(stackIndex == stacksSize)
		{
			if(currentSubstack == null)
			{
				if(stackIndex == 0)
				{
					throw new EmptyStackException();
				}

				currentSubstack = stacks.remove(stackIndex - 1);
			}

			int val = currentSubstack.data;
			currentSubstack = currentSubstack.next;

			return val;
		}


		Node thisStack = stacks.get(stackIndex - 1);

		if(thisStack.size() == 1)
		{
			stacks.remove(stackIndex - 1);
		}

		return thisStack.data;
	}


	public static void main(String[] args)
	{
		if(args.length != 1)
		{
			printUsage();
			return;
		}

		int n = 0;
		try
		{
			n = Integer.parseInt(args[0]);
		}
		catch(Exception e)
		{
			printUsage();
			return;
		}

		SetOfStacks stack = new SetOfStacks(n);
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

			if(operation.equals("popat"))
			{
				if(tokens.length != 2)
				{
					System.out.println("Usage: popAt");
					continue;
				}

				try
				{
					value = stack.popAt(value);
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
		}
	}

	static void printUsage()
	{
		System.out.println("Usage: java SetOfStacks n");
		System.out.println("Where n is the maximum sub-stack height");
		System.out.println("StdIn: A series of commands to push, peek, pop or view the min");
		System.out.println("Eg: push 120 would push the value 120 onto the stack");
		System.out.println("Exit with x");
	}
}