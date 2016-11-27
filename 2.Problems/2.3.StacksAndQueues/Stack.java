//Stack.java
//An example stack implementation with push, pop & peek

import java.util.EmptyStackException;
import java.lang.StringBuilder;

class Stack
{
	Node top;

	boolean isEmpty()
	{
		return (top == null);
	}

	int pop()
	{
		if(top == null)
		{
			throw new EmptyStackException();
		}

		int item = top.data;
		top = top.next;
		return item;
	}

	void push(int item)
	{
		Node t = new Node(item);
		t.next = top;
		top = t;
	}

	int peek()
	{
		if(top == null)
		{
			throw new EmptyStackException();
		}

		return top.data;
	}

	int size()
	{
		int size = 0;
		Node p = top;
		while(p != null)
		{
			p = p.next;
			size++;
		}

		return size;
	}

	public String toString()
	{
		Node n = top;
		StringBuilder s = new StringBuilder();

		while(n != null)
		{
			s.append(Integer.toString(n.data));
			s.append(",");
			n = n.next;
		}

		return s.toString();
	}
}