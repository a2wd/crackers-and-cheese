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

	public void solve()
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

	// Test client
	public static void main(String[] args)
	{
		if(args.length == 0 || args[0].toLowerCase().equals("-h"))
		{
			System.out.println("Usage: java TowersOfHanoi [-h] [-r] a b c d .. n");
			System.out.println("Where a .. n are a series of integers to push on to the first tower");
			return;
		}

		Stack input = new Stack();

		try
		{
			for(int i = 0; i < args.length; i++)
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

		System.out.println("Solving recursively");
		towers.solve();

		System.out.println("After solving");
		towers.print();
	}
}