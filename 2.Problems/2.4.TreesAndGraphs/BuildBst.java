// 2.4.3 Build Bst
// Given an array of unique integers sorted in ascending order, build a binary search tree
public class BuildBst
{
	public static BinaryTree BuildBst(int[] values)
	{
		return BuildBst(values, 0, values.length);
	}

	public static BinaryTree BuildBst(int[] values, int lo, int hi)
	{
		if(hi - lo < 1)
		{
			return null;
		}

		int currentNode = ( ( (hi - lo) / 2 ) + lo ) - 1;

		BinaryTree node = new BinaryTree(values[currentNode]);

		node.left = BuildBst(values, lo, currentNode - 1);
		node.right = BuildBst(values, currentNode + 1, hi - 1);

		return node;
	}

	// Test client
	public static void main(String[] args) {
		if(args.length == 0)
		{
			printUsage();
			return;
		}

		int[] vals = new int[args.length];
		for(int i = 0; i < args.length; i++)
		{
			vals[i] = Integer.parseInt(args[i]);
		}

		BinaryTree b = BuildBst(vals);
		System.out.println(b.postOrder());
	}

	static void printUsage()
	{
		System.out.println("Usage: java BuildBst i j .. n");
		System.out.println("Where i .. n are a series of integers given in post order to build into a binary tree");
	}
}