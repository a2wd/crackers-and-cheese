// 2.1.4 Replace Spaces
//Implement an algorithm to replace all spaces in a string
//With '%20', such that: "Ah ha  " => "Ah%20ha"
//Assume sufficient space is provided at the end of the string.
public class ReplaceSpaces
{
	static void replaceSpaces(char[] input)
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
		if(args.length != 1)
		{
			System.out.println("Usage: java ReplaceSpaces string");
			System.out.println("Replaces spaces in a string with '%20");
			return;
		}

		char[] c = args[0].toCharArray();

		replaceSpaces(c);

		System.out.println(c);
	}
}