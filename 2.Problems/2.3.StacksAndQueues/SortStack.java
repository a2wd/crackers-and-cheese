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
			s.push(temp.pop());
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

		while(currDepth >= 0)
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
			boolean pushedCurr = false;
			for(int i = currDepth; i < depth; i++)
			{
				if(temp.isEmpty() || (curr < temp.peek() && pushedCurr == false))
				{
					s.push(curr);
					pushedCurr = true;
				}
				else
				{
					s.push(temp.pop());
				}
			}

			currDepth--;
		}
	}

	//Model solution
	public static Stack sortModel(Stack s)
	{
		Stack t = new Stack();

		while(!s.isEmpty())
		{
			int temp = s.pop();

			while(!t.isEmpty() && t.peek() > temp)
			{
				s.push(t.pop());
			}

			t.push(temp);
		}

		return t;
	}

	public static void main(String[] args)
	{
		if(args.length < 1)
		{
			printUsage();
			return;
		}

		int i = 0;
		boolean useModel = false;

		if(args[0].toLowerCase().equals("-m"))
		{
			i++;
			useModel = true;
		}

		try
		{
			Stack s = new Stack();

			for(; i < args.length; i++)
			{
				s.push(Integer.parseInt(args[i]));
			}

			System.out.println("Before sorting: " + s.toString());

			if(useModel)
			{
				s = sortModel(s);
			}
			else
			{
				sortStack(s);
			}

			System.out.println("After sorting: " + s.toString());
		}
		catch(Exception e)
		{
			System.out.println("There was an error: " + e);
		}
	}

	static void printUsage()
	{
		System.out.println("Usage: java SortStack [-m] i j k ... n");
		System.out.println("The optional flag -m invokes the program with the model solution");
		System.out.println("Where i .. n are a series of integer values to push onto the stack");
	}
}