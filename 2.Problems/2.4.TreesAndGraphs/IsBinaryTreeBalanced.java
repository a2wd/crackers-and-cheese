// 2.4.1 IsBinaryTreeBalanced.java
//Implement a function to check if a binary tree is balanced.
//The heights of the nodes will never differ by more than 1.
public class IsBinaryTreeBalanced
{
	static int NodeHeight(BinaryTree root)
	{
		if(root == null)
		{
			return -1;
		}

		return Math.max(1 + NodeHeight(root.left), 1 + NodeHeight(root.right));
	}

	public static boolean IsBalanced(BinaryTree root)
	{
		if(root == null)
		{
			return false;
		}

		int leftDepth = NodeHeight(root.left);
		int rightDepth = NodeHeight(root.right);

		if(Math.abs(leftDepth - rightDepth) > 1)
		{
			return false;
		}

		return true;
	}

	public static void main(String args[])
	{
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.left.left = new BinaryTree(3);

		System.out.println("\n" + root.toString());
		System.out.println("Is balanced: " + IsBalanced(root) + "\n");

		root.right = new BinaryTree(4);

		System.out.println(root.toString());
		System.out.println("Is balanced: " + IsBalanced(root) + "\n");

		root.right.right = new BinaryTree(5);

		System.out.println(root.toString());
		System.out.println("Is balanced: " + IsBalanced(root) + "\n");

		root.right.right.right = new BinaryTree(6);

		System.out.println(root.toString());
		System.out.println("Is balanced: " + IsBalanced(root) + "\n");

		root.left.left.left = new BinaryTree(7);

		System.out.println(root.toString());
		System.out.println("Is balanced: " + IsBalanced(root) + "\n");

		int[] bstArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		BinaryTree balancedTree = BuildBst.BuildBst(bstArray);

		System.out.println(balancedTree.toString());
		System.out.println("Is balanced: " + IsBalanced(balancedTree) + "\n");
	}
}