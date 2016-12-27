// An implementation of a binary tree
import java.util.LinkedList;

public class BinaryTree
{
	public BinaryTree left, right;
	public int data;

	BinaryTree(int data)
	{
		this.data = data;
		left = null;
		right = null;
	}

	public String postOrder()
	{
		LinkedList<BinaryTree> nodes = new LinkedList<BinaryTree>();
		LinkedList<Integer> vals = new LinkedList<Integer>();
		nodes.add(this);

		while(nodes.size() > 0)
		{
			BinaryTree curr = nodes.removeFirst();
			vals.add(curr.data);

			if(curr.left != null)
			{
				nodes.add(curr.left);
			}

			if(curr.right != null)
			{
				nodes.add(curr.right);
			}
		}

		return vals.toString();
	}

	//Test client
	public static void main(String[] args)
	{
		BinaryTree t = new BinaryTree(1);
		t.left = new BinaryTree(2);
		t.right = new BinaryTree(3);
		t.left.left = new BinaryTree(4);
		t.left.right = new BinaryTree(5);
		t.right.left = new BinaryTree(6);
		t.right.right = new BinaryTree(7);

		System.out.println(t.postOrder());
	}
}