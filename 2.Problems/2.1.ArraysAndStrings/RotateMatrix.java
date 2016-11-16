// 2.1.6 Rotate a matrix
// Given an NxN matrix where each pixel is represented by a 4 byte variable, write a method to rotate the image 90*
// Do this in-situ
import java.util.Scanner;

public class RotateMatrix
{
	public static void rotateMatrix(int[][] matrix)
	{
		int l = matrix.length;
		int swaps = (l * l) / 2;

		for(int i = 0; i < l; i++)
		{
			for(int j = 0; j < l; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][l - i - 1];
				matrix[j][l - i - 1] = temp;

				swaps--;
				if(swaps == 0)
				{
					return;
				}
			}
		}
	}

	public static void printMatrix(int[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				if(j != 0)
				{
					System.out.print(" ");
				}
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		if(args.length != 0)
		{
			System.out.println("\nUsage: java RotateMatrix");
			System.out.println("Rotates an NxN matrix through 90 degress\n");
			System.out.println("STDIN: n i1, i2..i(n^2)");
			System.out.println("Where n is the matrix size and i1 through i(n^2) are the matrix values top left to bottom right\n");
			return;
		}

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[][] matrix = new int[n][n];

		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				matrix[i][j] = scanner.nextInt();
			}
		}
		System.out.println();

		printMatrix(matrix);
		rotateMatrix(matrix);
		printMatrix(matrix);
	}
}