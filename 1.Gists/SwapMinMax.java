public class SwapMinMax
{
	public static boolean isSmaller(int x, int y)
	{
		return x < y;
	}

	public static boolean isBigger(int x, int y)
	{
		return x > y;
	}

	public static void swapValues(int[] array, int x, int y)
	{
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	public static void swap(int[] array)
	{
		int maxIndex = 0;
		int minIndex = 0;

		for(int i = 0; i < array.length; i++)
		{
			if(isBigger(array[i], array[maxIndex]))
			{
				maxIndex = i;
			}

			if(isSmaller(array[i], array[minIndex]))
			{
				minIndex = i;
			}
		}

		swapValues(array, maxIndex, minIndex);
	}

	public static void main(String[] args)
	{
		if(args.length < 1)
		{
			printUsage();
			return;
		}

		try
		{
			int[] argsAsInts = new int[args.length];

			for(int i = 0; i < args.length; i++)
			{
				argsAsInts[i] = Integer.parseInt(args[i]);
			}

			System.out.println("Before swapping the max and min:");
			printArray(argsAsInts);

			System.out.println("After swapping the max and min:");
			swap(argsAsInts);
			printArray(argsAsInts);
		}
		catch(Exception e)
		{
			printUsage();
			return;
		}
	}	

	public static void printArray(int[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			if(i != 0)
			{
				System.out.print(", ");
			}
			System.out.print(array[i]);
		}
		System.out.print("\n");
	}

	public static void printUsage()
	{

		System.out.println("Usage: java SwapMinMax [a..z]");
		System.out.println("Where [a..z] is a series of space-seperated integers");
	}
}