// 2.3.1 Array Stack
// Implement three stacks with a single array
// This implementation uses a jagged/multidimensional array,
// but the same ideas would apply to a single, partitioned array

import java.util.Scanner;

public class ArrayStack
{
	Integer[][] stack;

	ArrayStack()
	{
		stack = new Integer[4][];

		// The first item can be used to keep track of other arrays
		stack[0] = new Integer[6];
		stack[0][0] = 0;
		stack[0][1] = 0;
		stack[0][2] = 0;
		stack[0][3] = 10;
		stack[0][4] = 10;
		stack[0][5] = 10;

		// Three stacks, default size of 10
		stack[1] = new Integer[10];
		stack[2] = new Integer[10];
		stack[3] = new Integer[10];
	}

	//Private helpers
	void resize(int stackIndex, int newSize)
	{
		if(stackIndex < 1 || stackIndex > 3)
		{
			return;
		}

		int currPos = stack[0][stackIndex - 1];
		stack[0][stackIndex + 3 - 1] = newSize;

		Integer[] newArray = new Integer[newSize];

		for(int i = 0; i < currPos; i++)
		{
			newArray[i] = stack[stackIndex][i];
		}

		stack[stackIndex] = newArray;
	}

	void sizeUp(int stackIndex)
	{
		int currSize = stack[0][stackIndex + 2];
		int newSize = currSize * 2;

		resize(stackIndex, newSize);
	}

	void sizeDown(int stackIndex)
	{
		int currSize = stack[0][stackIndex + 2];
		int newSize = currSize / 2;

		resize(stackIndex, newSize);
	}


	//Public API
	public boolean push(Integer value, int stackIndex)
	{
		if(stackIndex < 1 || stackIndex > 3 || value == null)
		{
			return false;
		}

		int top = stack[0][stackIndex - 1];
		stack[0][stackIndex - 1]++;

		if(top == stack[stackIndex].length - 1)
		{
			sizeUp(stackIndex);
		}

		stack[stackIndex][top] = value;

		return true;
	}

	public Integer peek(int stackIndex)
	{
		if(stackIndex < 1 || stackIndex > 3 || stack[0][stackIndex - 1] == 0)
		{
			return null;
		}

		int top = stack[0][stackIndex - 1] - 1;
		return stack[stackIndex][top];
	}

	public Integer pop(int stackIndex)
	{
		if(stackIndex < 1 || stackIndex > 3 || stack[0][stackIndex - 1] == 0)
		{
			return null;
		}

		stack[0][stackIndex - 1]--;
		int top = stack[0][stackIndex - 1];

		Integer val = stack[stackIndex][top];
		stack[stackIndex][top] = null;

		if(top < stack[stackIndex].length / 2)
		{
			sizeDown(stackIndex);
		}

		return val;
	}

	// Testing client
	public static void main(String[] args)
	{
		if(args.length != 0)
		{
			System.out.println("Usage: java ArrayStack");
			System.out.println("StdIn: A series of commands to push, peek or pop to any of the three stacks in array stack");
			System.out.println("Eg: push 120 3 would push the value 120 onto stack 3");
			System.out.println("Exit with x");
		}

		ArrayStack stack = new ArrayStack();
		Scanner scanner = new Scanner(System.in);

		while(true)
		{
			String s = scanner.nextLine();

			int[] values = new int[2];
			String[] tokens = s.split(" ");
			String operation = tokens[0].toLowerCase();

			if(operation.equals("x"))
			{
				return;
			}

			try
			{
				for(int i = 1; i < tokens.length; i++)
				{
					values[i - 1] = Integer.parseInt(tokens[i]);
				}
			}
			catch(Exception e)
			{
				System.out.println("Expected a number but got something else: " + e);
				continue;
			}

			if(operation.equals("push"))
			{
				if(tokens.length != 3 || values[1] < 1 || values[1] > 3)
				{
					System.out.println("Usage: push n i where n is an integer and i is a stack index between 1 and 3");
					continue;
				}

				stack.push(new Integer(values[0]), values[1]);
			}

			if(operation.equals("pop"))
			{
				if(tokens.length != 2 || values[0] < 1 || values[0] > 3)
				{
					System.out.println("Usage: pop i where i is a stack index between 1 and 3");
					continue;
				}

				Integer value = stack.pop(values[0]);

				if(value == null)
				{
					System.out.println("There are no more values in stack " + values[0]);
				}
				else
				{
					System.out.println(value);
				}
			}

			if(operation.equals("peek"))
			{
				if(tokens.length != 2 || values[0] < 1 || values[0] > 3)
				{
					System.out.println("Usage: peek i where i is a stack index between 1 and 3");
					continue;
				}

				Integer value = stack.peek(values[0]);

				if(value == null)
				{
					System.out.println("There are no more values in stack " + values[0]);
				}
				else
				{
					System.out.println(value);
				}
			}
		}
	}
}