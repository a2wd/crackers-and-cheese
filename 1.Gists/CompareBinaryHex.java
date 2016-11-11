public class CompareBinaryHex
{
	public static boolean compareBinToHex(String binary, String hex)
	{
		int n1 = convertToBase(binary, 2);
		int n2 = convertToBase(hex, 16);

		if(n1 < 0 || n2 < 0)
		{
			return false;
		}

		return n1 == n2;
	}

	public static int convertToBase(String number, int base)
	{
		if(base < 2 || (base > 10 && base != 16))
		{
			return -1;
		}

		int value = 0;

		for(int i = number.length() - 1; i >= 0; i--)
		{
			int digit = digitToValue(number.charAt(i));
			if(digit < 0 || digit >= base)
			{
				return -1;
			}
			int exp = number.length() - 1 - i;
			value += digit * Math.pow(base, exp);
		}

		return value;
	}

	public static int digitToValue(char c)
	{
		if(c >= '0' && c <= '9')
		{
			return c - '0';
		}

		if(c >= 'A' && c <= 'F')
		{
			return 10 + c - 'A';
		}

		if(c >= 'a' && c <= 'f')
		{
			return 10 + c - 'a';
		}

		return -1;
	}

	public static void main(String[] args)
	{
		if(args.length != 2)
		{
			System.out.println("Usage: CompareBinaryHex x y");
			System.out.println("Where x is a binary string and y is a hexidecimal string");
			return;
		}
		String bin = args[0];
		String hex = args[1];
		boolean binIsHex = compareBinToHex(bin, hex);

		System.out.println("Binary (" + bin + ") equals hex (" + hex + ") => " + binIsHex);
	}	
}