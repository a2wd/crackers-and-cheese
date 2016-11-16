// 2.1.7 Zero Matrix
// If an element of the input matrix is 0, zero the column and row.

public class ZeroMatrix
{
	public static void zeroMatrix(int[][] matrix)
	{
		
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

		if(args.length == 1 && (args[0].equals("-h") || args[0].equals("-H"))
		{
			System.out.println("> Usage: java ZeroMatrix");
			System.out.println("Where an element in a matrix is 0, the column and row will be zeroed");
			System.out.println("> STDIN: n i1, i2..i(n^2)");
			System.out.println("> Where n is the matrix size and i1 through i(n^2) are the matrix values top left to bottom right");
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

		zeroMatrix(matrix);

		printMatrix(matrix);
	}
}