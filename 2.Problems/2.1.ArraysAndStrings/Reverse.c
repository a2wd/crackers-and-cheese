// 2.1.2 Reverse
// In C or C++, write a function, reverse, that reverses a string.
// void reverse(char* str)
#include <stdio.h>

int length(char* str)
{
	if(str == NULL)
	{
		return 0;
	}

	int i = 0;
	while(*(str + i) != '\0')
	{
		i++;
	}

	return i;
}

void reverse(char* str)
{
	int len = length(str);
	if(len == 0 || len == 1) 
	{
		return;
	}

	for(int i = 0; i < (len/2); i++)
	{
		char temp = *(str + i);
		*(str + i) = *(str + len - i - 1);
		*(str + len - i - 1) = temp;
	}
}

int main(int argc, char* argv[])
{
	if(argc != 2)
	{
		printf("Usage: Reverse.exe input\nWhere input is a string to reverse");

		return 1;
	}

	printf("%s reversed is: ", argv[1]);
	reverse(argv[1]);
	printf("%s\n", argv[1]);

	return 0;
}