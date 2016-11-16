// 2.1.1 Unique Chars
// Implement an algorithm to decide if a string has all unique characters
// What if you cannot use additional data structures?
import java.lang.*;

public class UniqueChars
{
	public static boolean hasUniqueChars(String s)
	{
		if(s == null || s.length() == 0) {
			throw new IllegalArgumentException("Null or empty string passed to method");
		}

		if(s.length() == 1) {
			return true;
		}

		boolean counter[] = new boolean[Character.MAX_VALUE];
		char c[] = s.toCharArray();

		for(int i = 0; i < c.length; i++)
		{
			if(counter[c[i]] == true)
			{
				return false;
			}

			counter[c[i]] = true;
		}

		return true;
	}

	static boolean hasUniqueCharsWithoutCounter(String s)
	{
		if(s == null || s.length() == 0) {
			throw new IllegalArgumentException("Null or empty string passed to method");
		}

		char[] c = s.toCharArray();

		if(c.length == 1) {
			return true;
		}

		for(int i = 0; i < c.length - 1; i++)
		{
			for(int j = i; j < c.length; j++)
			{
				if(c[i] == c[j])
				{
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		if(args.length < 1)
		{
			System.out.println("Usage: java UniqueChars string [-w]");
			System.out.println("-w is an optional flag to run the calculation without any additional data structures");
			return;
		}

		boolean isUnique;

		if(args.length == 2 && (args[1] == "-w" || args[1] == "-W"))
		{
			isUnique = hasUniqueCharsWithoutCounter(args[0]);
		}
		else
		{
			isUnique = hasUniqueChars(args[0]);
		}

		if(isUnique)
		{
			System.out.println(args[0] + " comprises all unique characters.");
		}
		else
		{
			System.out.println(args[0] + " has duplicate characters.");

		}
	}
}