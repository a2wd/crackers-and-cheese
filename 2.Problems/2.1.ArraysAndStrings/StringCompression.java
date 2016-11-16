// 2.1.5 String Compression
// Implement a method to perform basic string compression
// Where: aabbbccd => a2b3c2d1
// Return the original string if the compressed version isn't smaller

public class StringCompression
{
	public static char[] compress(char[] input)
	{
		char[] compressed = new char[input.length];
		int position = 0;

		for(int i = 0; i < input.length; i++)
		{
			int charCount = 1;

			compressed[position] = input[i];
			position++;

			if(position == input.length)
			{
				return input;
			}

			while((i + 1) < input.length && input[i + 1] == compressed[position - 1])
			{
				i++;
				charCount++;
			}

			compressed[position] = (char)(charCount + '0');
			position++;

			if(position == input.length)
			{
				return input;
			}
		}

		return compressed;
	}

	public static void main(String[] args)
	{
		if(args.length != 1)
		{
			System.out.println("Usage: java StringCompression string");
			System.out.println("Where string is a string to be compressed");
			System.out.println("For instance: aaabbc => a3b2c1");
			System.out.println("If the compressed version isn't smaller, the original string is returned");
			return;
		}

		char[] c1 = args[0].toCharArray();
		
		String compressedInput = new String(compress(c1));

		System.out.println(compressedInput);
	}
}