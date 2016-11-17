// 2.1.6 Rotate a matrix
// Given an NxN matrix where each pixel is represented by a 4 byte variable, write a method to rotate the image 90*
// Do this in-situ
import java.util.Scanner;

public class RotateMatrix
{
	public static int rotatedMatrixWrapper(int[][] matrix, int i, int j)
	{
		int l = matrix.length - 1;

		return matrix[l - j][i];
	}

	public static void rotatedMatrixInSitu(int[][] matrix)
	{
		int l = matrix.length;

		for(int i = 0; i <  (l / 2); i++)
		{
			for(int j = 0; j < ((l + 1) / 2); j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[l - 1 - j][i];
				matrix[l - 1 - j][i] = matrix[l - 1- i][l - 1 - j];
				matrix[l - 1- i][l - 1 - j] = matrix[j][l - 1 - i];
				matrix[j][l - 1 - i] = temp;
			}
		}
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

	public static void printMatrix(int[][] matrix, boolean userWrapper)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				if(j != 0)
				{
					System.out.print(" ");
				}

				if(userWrapper)
				{
					System.out.print(rotatedMatrixWrapper(matrix, i, j));
				}
				else
				{
					System.out.print(matrix[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		boolean withoutAdditionalDataStructure = false;
		boolean userWrapper = false;

		if(args.length == 1)
		{
			if(args[0].equals("-h") || args[0].equals("-H"))
			{
				System.out.println("> Usage: java RotateMatrix [-w]");
				System.out.println("> Rotates an NxN matrix through 90 degress");
				System.out.println("> STDIN: n i1, i2..i(n^2)");
				System.out.println("> Where n is the matrix size and i1 through i(n^2) are the matrix values top left to bottom right");
				System.out.println("> The optional -w flag can be set to perform the rotation without an additional data structure");
				System.out.println("> The optional -i flag can be set to negate the rotation and add a wrapper to access the matrix as if rotated");
				return;
			}

			if(args[0].equals("-w") || args[0].equals("-W"))
			{
				withoutAdditionalDataStructure = true;
			}

			if(args[0].equals("-i") || args[0].equals("-I"))
			{
				userWrapper = true;
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

		printMatrix(matrix, false);

		if(userWrapper)
		{
			printMatrix(matrix, true);
			return;
		}

		if(withoutAdditionalDataStructure)
		{
			rotatedMatrixInSitu(matrix);

		}
		else
		{
			rotateMatrix(matrix);
		}

		printMatrix(matrix, false);
	}
}