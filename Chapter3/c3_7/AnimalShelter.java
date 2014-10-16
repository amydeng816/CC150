import java.util.LinkedList;

public class AnimalShelter {
    private LinkedList<Animal> l;

    public AnimalShelter() {
	l = new LinkedList<Animal>();
    }

    public void enqueue(Animal a) {
	l.addFirst(a);
    }

    public Animal dequeueAny() {
	return (Animal)l.removeLast();
    }

    public Dog dequeueDog() {
	for (int i = l.size() - 1; i >= 0; i--) {
	    if (l.get(i) instanceof Dog) {
		return (Dog)l.remove(i);
	    }
	}
	return null;
    }

    public Cat dequeueCat() {
	for (int i = l.size() - 1; i >= 0; i--) {
	    if (l.get(i) instanceof Cat) {
		return (Cat)l.remove(i);
	    }
	}
	return null;
    }

    public static void main(String[] args) {
	Cat c1 = new Cat("aa");
	Cat c2 = new Cat("bb");
	Cat c3 = new Cat("cc");

	Dog d1 = new Dog("a");
	Dog d2 = new Dog("b");
	Dog d3 = new Dog("c");

	AnimalShelter test = new AnimalShelter();
	test.enqueue(c1);
	test.enqueue(d1);
	test.enqueue(c2);
	test.enqueue(d2);
	test.enqueue(c3);
	test.enqueue(d3);
	System.out.println(test.dequeueAny());
	System.out.println(test.dequeueCat());
	System.out.println(test.dequeueDog());
	System.out.println(test.dequeueAny());
	System.out.println(test.dequeueAny());
	System.out.println(test.dequeueAny());
	System.out.println(test.dequeueAny());
    }
}
