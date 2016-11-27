// A reference linked-list node implementation from cracking the coding interview.
public class Node {
	public Node next = null;
	public int data;

	public Node(int d) {
		data = d;
	}

	public void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;

		while(n.next != null) {
			n = n.next;
		}

		n.next = end;
	}

	public Node deleteNode(Node head, int d) {
		Node n = head;

		if(n.data == d) {
			return head.next;
		}

		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
				return head;
			}

			n = n.next;
		}

		return head;
	}

	public int size()
	{
		Node n = this;
		int size = 1;

		while(n.next != null)
		{
			n = n.next;
			size++;
		}

		return size;
	}

	public void printData()
	{
		Node n = this;

		System.out.print("LinkedList: ");

		while(n != null)
		{
			System.out.print(" " + n.data);
			
			n = n.next;
		}
		
		System.out.println();
	}
}