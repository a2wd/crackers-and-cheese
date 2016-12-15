// TwoValues.java
// Given a sorted array of integers, return true if any two values add up to a given sum.

import java.util.Arrays;

public class TwoValues
{
	public static boolean solve(int[] arr, int sum)
	{
		if(arr == null || arr.length == 0)
		{
			return false;
		}

		int head = 0;
		int tail = arr.length - 1;

		while(head < tail)
		{
			int val = arr[head] + arr[tail];

			if(val == sum)
			{
				return true;
			}

			if(val < sum)
			{
				head++;
			}

			if(val > sum)
			{
				tail--;
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		if(args.length < 3)
		{
			System.out.println("usage: java TwoValues s 1 2 3 .. n");
			System.out.println("Where s is a sum to check for and 1 .. n are a series of integers");
			return;
		}

		int sum = Integer.parseInt(args[0]);
		int[] values = new int[args.length - 1];

		for(int i = 1; i < args.length; i++)
		{
			values[i - 1] = Integer.parseInt(args[i]);
		}

		Arrays.sort(values);
		boolean sumExistsInArray = solve(values, sum);
		System.out.println(sum + " exists in array: " + sumExistsInArray);
	}
}