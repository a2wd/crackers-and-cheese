// 2.1.8 Is rotation
// Return true if string 1 is a rotation of string 2
// You must use isSubstring once, a function which returns true if string a exists in string b

public class IsRotation
{
	public static boolean isSubstring(String s1, String s2)
	{
		return s2.contains(s1);
	}

	public static boolean isRotation(String s1, String s2)
	{
		if(s1 == null || s2 == null || s1.length() != s2.length())
		{
			return false;
		}

		String s3 = s2 + s2;

		if(isSubstring(s1, s3))
		{
			return true;
		}

		return false;
	}

	public static void main(String[] args)
	{
		if(args.length != 2)
		{
			System.out.println("Usage: java IsRotation string1 string2");
			System.out.println("Returns true if string1 is a rotation of string 2, else returns false");
			System.out.println("Example: hello -> elloh = true");
			return;
		}

		if(isRotation(args[0], args[1]))
		{
			System.out.println(args[0] + " is a rotation of " + args[1]);
		}
		else
		{
			System.out.println(args[0] + " is different to " + args[1]);
		}
	}
}