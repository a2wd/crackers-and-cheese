// 2.1.6 Rotate a matrix
// Given an NxN matrix where each pixel is represented by a 4 byte variable, write a method to rotate the image 90*
// Do this in-situ
import java.util.Scanner;

public class RotateMatrix
{
	public static void rotatedMatrixInSitu(int[][] matrix)
	{

	}

	public static void rotateMatrix(int[][] matrix)
	{
		int l = matrix.length;
		int[][] rotatedMatrix = new int[l][l];

		//Rotate matrix into rotatedMatrix
		for(int i = 0; i < l; i++)
		{
			for(int j = 0; j < l; j++)
			{
				rotatedMatrix[j][l - i - 1] = matrix[i][j];
			}
		}

		//Re-assign rotated values to matrix
		for(int i = 0; i < l; i++)
		{
			for(int j = 0; j < l; j++)
			{
				matrix[i][j] = rotatedMatrix[i][j];
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
		boolean withoutAdditionalDataStructure = false;

		if(args.length == 1)
		{
			if(args[0].equals("-h") || args[0].equals("-H"))
			{
				System.out.println("> Usage: java RotateMatrix [-w]");
				System.out.println("> Rotates an NxN matrix through 90 degress");
				System.out.println("> STDIN: n i1, i2..i(n^2)");
				System.out.println("> Where n is the matrix size and i1 through i(n^2) are the matrix values top left to bottom right");
				System.out.println("> The optional -w flag can be set to perform the rotation without an additional data structure");
				return;
			}

			if(args[0].equals("-w") || args[0].equals("-W"))
			{
				withoutAdditionalDataStructure = true;
			}
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

		if(withoutAdditionalDataStructure)
		{
			rotatedMatrixInSitu(matrix);

		}
		else
		{
			rotateMatrix(matrix);
		}

		printMatrix(matrix);
	}
}