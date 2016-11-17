// 2.1.4 Replace Spaces
//Implement an algorithm to replace all spaces in a string
//With '%20', such that: "Ah ha  " => "Ah%20ha"
//Assume sufficient space is provided at the end of the string.
public class ReplaceSpaces
{
	public static void replaceSpacesEfficient(char[] input, int length)
	{
		int spaces = 0;

		for(int i = 0; i < length; i++)
		{
			if(input[i] == ' ')
			{
				spaces++;
			}
		}

		int position = length + spaces;
		input[position] = '\0';

		for(int i = length; i >= 0; i--)
		{
			if(input[i] == ' ')
			{
				input[position - 3] = '%';
				input[position - 2] = '2';
				input[position - 1] = '0';
				position -= 3;
			}
			else
			{
				input[position - 1] = input[i];
				position -= 1;
			}
		}
	}

	public static void replaceSpaces(char[] input)
	{
		int l = input.length;

		for(int i = 0; i < l; i++)
		{
			if(input[i] == ' ')
			{
				input[i] = '%';
				i++;

				char temp1;
				char temp2;

				char repl1 = '2';
				char repl2 = '0';

				for(int j = i; j < (l - 1); j += 2)
				{
					temp1 = input[j];
					temp2 = input[j+1];

					input[j] = repl1;
					input[j+1] = repl2;

					repl1 = temp1;
					repl2 = temp2;
				}
			}
		}

	}

	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			printUsage();
			return;
		}

		boolean useEfficientAlgorithm = false;
		char[] c;

		if(args.length == 2)
		{
			if(!args[0].equals("-e") && !args[0].equals("-E"))
			{
				printUsage();
				return;
			}

			//else
			useEfficientAlgorithm = true;
			c = args[1].toCharArray();
		}
		else
		{
			c = args[0].toCharArray();
		}

		if(useEfficientAlgorithm)
		{
			int endOfWord;
			for(endOfWord = c.length - 1; c[endOfWord] == ' '; endOfWord--);

			replaceSpacesEfficient(c, endOfWord);
		}
		else
		{
			replaceSpaces(c);
		}

		System.out.println(c);
	}

	public static void printUsage()
	{
		System.out.println("Usage: java ReplaceSpaces [-e] string");
		System.out.println("Replaces spaces in a string with '%20");
		System.out.println("Use the optional parameter -e to use an efficient algorithm");
	}
}