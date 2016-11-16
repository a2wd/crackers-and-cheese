// SwapInSitu.c
// Swap two ints without using a temporary variable
// This can be accomplished with the XOR operator
// Alternatives include addition/subtraction or multiplication/division

#include <stdio.h>

int main(void)
{
	//Swap integers
	int a = 5;
	int b = 7;

	printf("int a = %d, int b = %d\n", a, b);
	printf("Swapping ints...\n");

	a = a ^ b;
	b = a ^ b;
	a = a ^ b;

	printf("int a = %d, int b = %d\n\n", a, b);

	//Swap chars
	char c = 'q';
	char d = '#';

	printf("char c = %c, char d = %c\n", c, d);
	printf("Swapping chars...\n");

	c = c ^ d;
	d = c ^ d;
	c = c ^ d;

	printf("char c = %c, char d = %c\n\n", c, d);

	//Swap floats
	float f = 3.14159; //pi
	float g = 1.61803; //phi

	printf("float f = %f, float g = %f\n", f, g);
	printf("Swapping floats...\n");

	f = f ^ g;
	g = f ^ g;
	f = f ^ g;

	printf("float f = %f, float g = %f\n", f, g);

	return 0;
}