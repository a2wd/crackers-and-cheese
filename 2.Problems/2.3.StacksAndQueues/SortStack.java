// 2.3.6 Sort Stack
// Sort a stack using at most one other stack, with push, pop, peek & isEmpty. 

import java.lang.*;
import java.util.*;

public class SortStack
{
	public static void sortStack(Stack s)
	{
		if(s == null || s.isEmpty())
		{
			return;
		}

		Stack temp = new Stack();
		int curr = 0;
		int depth = 0;

		while(!s.isEmpty())
		{
			temp.push(s.pop());
			depth++;
		}

		//Base case, depth of 1 is sorted
		if(depth == 1)
		{
			return;
		}

		curr = temp.pop();
		int currDepth = depth - 1;

		for(int i = 0; i < currDepth; i++)
		{
			s.push(temp.pop());
		}

		s.push(curr);
		currDepth--;

		while(currDepth > 0)
		{
			//Get next value
			while(!s.isEmpty())
			{
				temp.push(s.pop());
			}
			curr = temp.pop();

			//Replace stack
			for(int i = 0; i < currDepth; i++)
			{
				s.push(temp.pop());
			}

			//Put value at correct location
			for(int i = currDepth; i < depth; i++)
			{
				if(temp.isEmpty() || curr > temp.peek())
				{
					s.push(curr);
				}
				else
				{
					s.push(temp.pop());
				}
			}

			currDepth--;
		}
	}

	public static void main(String[] args)
	{
		if(args.length < 1)
		{
			printUsage();
			return;
		}

		// try
		// {
			Stack s = new Stack();

			for(int i = 0; i < args.length; i++)
			{
				s.push(Integer.parseInt(args[i]));
			}

			System.out.println(s.toString());
			sortStack(s);
			System.out.println(s.toString());
		// }
		// catch(Exception e)
		// {
		// 	System.out.println("There was an error: " + e);
		// }
	}

	static void printUsage()
	{
		System.out.println("Usage: java SortStack i j k ... n");
		System.out.println("Where i .. n are a series of integer values to push onto the stack");
	}
}