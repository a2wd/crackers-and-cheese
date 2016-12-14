// 2.3.7 Adoption Queue
// Write a custom two-type queue with enqueue(), dequeueAny(), dequeueDog() & dequeueCat()
import java.util.*;

class Pets { public String Name; }
class Dogs extends Pets {}
class Cats extends Pets {}

public class AdoptionQueue
{
	LinkedList<Object> all, dogs, cats;

	AdoptionQueue()
	{
		this.dogs = new LinkedList<Object>();
		this.cats = new LinkedList<Object>();
		this.all = new LinkedList<Object>();
	}

	void enqueue(Pets p)
	{
		if(p instanceof Dogs)
		{
			dogs.add(p);
		}

		if(p instanceof Cats)
		{
			cats.add(p);
		}

		all.add(p);
	}

	Object dequeueAny()
	{
		if(all.size() == 0)
		{
			return null;
		}

		if(all.get(0) instanceof Cats)
		{
			cats.removeFirst();
			return all.removeFirst();
		}

		dogs.removeFirst();
		return all.removeFirst();
	}

	Cats dequeueCat()
	{
		if(cats.size() == 0)
		{
			return null;
		}

		Cats c = (Cats) cats.removeFirst();
		all.remove(c);

		return c;
	}

	Dogs dequeueDog()
	{
		if(dogs.size() == 0)
		{
			return null;
		}

		Dogs d = (Dogs) dogs.removeFirst();
		all.remove(d);

		return d;
	}

	public static void main(String[] args)
	{
		if(args.length != 0)
		{
			System.out.println("Usage: java AdoptionQueue");
			System.out.println("Stdin: x (to exit), e (enqueue) dog|cat petname, dd (dequeue dog), dc (dequeue cat), da (dequeue any)");
			return;
		}

		AdoptionQueue q = new AdoptionQueue();
		Scanner scanner = new Scanner(System.in);

		while(true)
		{
			try
			{
				String s = scanner.nextLine().toLowerCase();

				if(s.equals("x"))
				{
					return;
				}

				if(s.equals("dd"))
				{
					Dogs d = q.dequeueDog();
					System.out.println("Dequeued a dog: " + d.Name);
				}

				if(s.equals("dc"))
				{
					Cats c = q.dequeueCat();
					System.out.println("Dequeued a cat: " + c.Name);
				}

				if(s.equals("da"))
				{
					Pets p = (Pets) q.dequeueAny();
					System.out.println("Dequeued a pet: " + p.Name);
				}

				String[] sa = s.split(" ");
				if(sa.length == 3 && sa[0].equals("e") && (sa[1].equals("dog") || sa[1].equals("cat")))
				{
					if(sa[1].equals("dog"))
					{
						Dogs d = new Dogs() {{ Name = sa[2]; }};
						q.enqueue(d);
						continue;
					}

					Cats c = new Cats() {{ Name = sa[2]; }};
					q.enqueue(c);
				}
			}
			catch(Exception e)
			{
				System.out.println("Stdin: x (to exit), e (enqueue) dog|cat petname, dd (dequeue dog), dc (dequeue cat), da (dequeue any)");
			}
		}
	}
}