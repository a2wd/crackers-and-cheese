// 2.3.7 Adoption Queue
// Write a custom two-type queue with enqueue(), dequeueAny(), dequeueDog() & dequeueCat()
public class Pets { public String Name; }
public class Dogs extends Pets {}
public class Cats extends Pets {}

public class AdoptionQueue
{
	LinkedList<Pets> dogs, cats, all;

	AdoptionQueue()
	{
		this.dogs = new LinkedList<Dogs>();
		this.cats = new LinkedList<Cats>();
		this.all = new LinkedList<Pets>();
	}

	void enqueue(Pets p)
	{
		if(p instanceof Dogs)
		{
			dogs.add(p);
		}

		if(p instanceof Cats)
		{
			cat.add(p);
		}

		all.add(p);
	}

	Pets dequeueAny()
	{
		if(all.count() == 0)
		{
			return null;
		}

		if(all.first() instanceof Cats)
		{
			cats.removeFirst();
			return all.removeFirst();
		}

		dogs.removeFirst();
		return all.removeFirst();
	}

	Cats dequeueCat()
	{
		if(cats.count() == 0)
		{
			return null;
		}

		Cats c = cats.removeFirst();
		all.remove(c);

		return c;
	}

	Dogs dequeueDogs()
	{
		if(dogs.count() == 0)
		{
			return null;
		}

		Dogs d = dogs.removeFirst();
		all.remove(d);

		return d;
	}
}