// 2.2.5 Sum Linked Lists
// Sum the values of two linked lists stored in reverse order and return the sum as a linked list (3 -> 2 -> 1 = 123)
// eg. 3->3->3 + 9->2->1 = 2->6->4 (129 + 333 = 462)
// Also sum the lists when stored in forward order (1 -> 2 -> 3 = 123)

public class SumLinkedLists
{
	public static Node sumReverseOrderLists(Node a, Node b)
	{
		Node sumList = null;
		Node head = sumList;


		if(a == null && b == null)
		{
			return sum;
		}

		int carry = 0;

		while(a != null || b != null)
		{
			int i = a == null ? 0 : a.data;
			int j = b == null ? 0 : b.data;

			int sum = i + j + carry;

			if(sum > 9)
			{
				carry = 1;
				sum = sum - 10;
			}
			else
			{
				carry = 0;
			}

			Node digit = new Node(sum);

			if(sumList == null) {
				sumList = digit;

			}
			else
			{
				sumList.next = digit;
				sumList = sumList.next;
			}
		}

		return sumList;
	}

	private int sumHelper(Node n)
	{
		int sum = 0;

		while(n != null)
		{
			sum */ 10;
			sum += n.data;
			n = n.next;
		}

		return sum;
	}

	public static Node sumForwardOrderLists(Node a, Node b)
	{
		if(a == null && b == null)
		{
			return SumList;
		}

		int i = sumHelper(a);
		int j = sumHelper(b);
		int sum = i + j;

		

		return sumList;
	}
}