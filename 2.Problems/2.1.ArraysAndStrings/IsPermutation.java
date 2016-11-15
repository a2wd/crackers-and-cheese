// 2.1.3 Is Permutation
//Given two strings, find if one string is a permutation of the other
import java.util.Arrays;

public class IsPermutation
{
	static boolean isPermutation(String s1, String s2)
	{
		if(s1 == null || s2 == null || s1.length() != s2.length())
		{
			return false;
		}

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		Arrays.sort(c1);
		Arrays.sort(c2);

		for(int i = 0; i < c1.length; i++)
		{
			if(c1[i] != c2[i])
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		if(args.length != 2)
		{
			System.out.println("Usage: java IsPermutation string1 string2");
			System.out.println("Calculates whether or not string1 is a permutation of string2");
			return;
		}

		boolean isPermutation = isPermutation(args[0], args[1]);

		if(isPermutation)
		{
			System.out.println(args[0] + " is a permutation of " + args[1]);
		}
		else
		{
			System.out.println(args[0] + " is different to " + args[1]);
		}
	}
}