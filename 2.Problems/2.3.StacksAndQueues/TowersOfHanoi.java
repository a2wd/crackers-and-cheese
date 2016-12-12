// 2.3.4 Towers of Hanoi
// Solve the towers of hanoi problem, using stacks

import java.lang.*;
import java.util.*;

public class TowersOfHanoi
{
	int size;
	Stack a, b, c;

	TowersOfHanoi(Stack input)
	{
		if(input == null)
		{
			throw new IllegalArgumentException();
		}

		Stack temp = new Stack();

		this.a = new Stack();
		this.b = new Stack();
		this.c = new Stack();

		while(!input.isEmpty())
		{
			temp.push(input.pop());
		}

		this.size = 0;
		while(!temp.isEmpty())
		{
			this.a.push(temp.pop());
			this.size++;
		}
	}

	public void solveIterative()
	{
		while(true)
		{
			if(size % 2 == 0)
			{
				if(completed())
				{
					return;
				}
				swap(a, b);

				if(completed())
				{
					return;
				}
				swap(a, c);

				if(completed())
				{
					return;
				}
				swap(b, c);

			}
			else
			{
				if(completed())
				{
					return;
				}
				swap(a, c);

				if(completed())
				{
					return;
				}
				swap(a, b);

				if(completed())
				{
					return;
				}
				swap(b, c);
			}
		}
	}

	public void swap(Stack first, Stack second)
	{
		if(first.isEmpty() && second.isEmpty())
		{
			return;
		}

		if(second.isEmpty())
		{
			second.push(first.pop());
			return;
		}

		if(first.isEmpty())
		{
			first.push(second.pop());
			return;
		}

		if(first.peek() > second.peek())
		{
			first.push(second.pop());
			return;
		}

		second.push(first.pop());
	}

	public boolean completed()
	{
		return a.isEmpty() && b.isEmpty();
	}

	public void solveRecursive()
	{
		move(size, a, c, b);
	}

	private void move(int size, Stack source, Stack target, Stack aux)
	{
		if(size > 0)
		{
			move(size - 1, source, aux, target);
			target.push(source.pop());
			move(size - 1, aux, target, source);
		}
	}

	// Helper toString
	public void print()
	{
		String[] aVals = a.toString().split(",");
		String[] bVals = b.toString().split(",");
		String[] cVals = c.toString().split(",");

		reverse(aVals);
		reverse(bVals);
		reverse(cVals);

		int max = Math.max(aVals.length, bVals.length);
		max = Math.max(max, cVals.length);

		for(int i = max - 1; i >= 0; i--)
		{
			String aString = i < aVals.length && !aVals[0].equals("") ? aVals[i] : "|";
			String bString = i < bVals.length && !bVals[0].equals("") ? bVals[i] : "|";
			String cString = i < cVals.length && !cVals[0].equals("") ? cVals[i] : "|";

			System.out.println(" " + aString + " " + bString + " " + cString);
		}
		System.out.println(" -----");
	}

	public void reverse(String[] arr)
	{
		for(int i = 0; i < arr.length / 2; i++)
		{
			String temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
	}

	// Test client
	public static void main(String[] args)
	{
		if(args.length == 0 || args[0].toLowerCase().equals("-h"))
		{
			System.out.println("Usage: java TowersOfHanoi [-h] [-r] a b c d .. n");
			System.out.println("Where a .. n are a series of integers in descending order to push on to the first tower");
			return;
		}

		Stack input = new Stack();

		boolean useRecursive = false;
		int i = 0;
		if(args[0].toLowerCase().equals("-r"))
		{
			useRecursive = true;
			i++;
		}

		try
		{
			for(; i < args.length; i++)
			{
				int val = Integer.parseInt(args[i]);
				input.push(val);
			}
		}
		catch(Exception e)
		{
			System.out.println("Expected integers as input arguments");
			return;
		}

		TowersOfHanoi towers = new TowersOfHanoi(input);
		System.out.println("Before solving");
		towers.print();

		if(useRecursive)
		{
			System.out.println("Solving recursively");
			towers.solveRecursive();
		}
		else
		{
			System.out.println("Solving iteratively");
			towers.solveIterative();
		}

		System.out.println("After solving");
		towers.print();
	}
}