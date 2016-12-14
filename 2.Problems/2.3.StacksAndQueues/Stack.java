//Stack.java
//An example stack implementation with push, pop & peek

import java.util.EmptyStackException;
import java.lang.StringBuilder;

class Stack
{
	Node top;
	int size;

	Stack()
	{
		this.top = null;
		this.size = 0;
	}

	boolean isEmpty()
	{
		return (size == 0);
	}

	int pop()
	{
		if(size == 0)
		{
			throw new EmptyStackException();
		}

		int item = top.data;
		top = top.next;
		size--;
		return item;
	}

	void push(int item)
	{
		Node t = new Node(item);
		t.next = top;
		top = t;
		size++;
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
		return size;
	}

	public String toString()
	{
		Node n = top;
		StringBuilder s = new StringBuilder();

		while(n != null)
		{
			s.append(Integer.toString(n.data));

			if(n.next != null)
			{
				s.append(",");
			}
			n = n.next;
		}

		return s.toString();
	}
}