import java.util.LinkedList;

public class AnimalShelter2 {
    private LinkedList<Cat> l1;
    private LinkedList<Dog> l2;
    private int order;

    public AnimalShelter2() {
	l1 = new LinkedList<Cat>();
	l2 = new LinkedList<Dog>();
    }

    public void enqueue(Animal a) {
	a.setOrder(++order);
	if (a instanceof Cat) {
	    l1.addFirst((Cat)a);
	} else {
	    l2.addFirst((Dog)a);
	}
    }

    public Animal dequeueAny() {
	if (l1.size() == 0 && l2.size() == 0) {
	    return null;
	}
	if (l1.size() == 0) {
	    return (Animal)l2.removeLast();
	}
	if (l2.size() == 0) {
	    return (Animal)l1.removeLast();
	} 
	return (Animal)(l1.getLast().getOrder() < l2.getLast().getOrder() ? l1.removeLast() : l2.removeLast());
    }

    public Dog dequeueDog() {
	if (l2.size() == 0) {
	    return null;
	}
	return l2.removeLast();
    }

    public Cat dequeueCat() {
	if (l1.size() == 0) {
	    return null;
	}
	return l1.removeLast();
    }

    public static void main(String[] args) {
	Cat c1 = new Cat("aa");
	Cat c2 = new Cat("bb");
	Cat c3 = new Cat("cc");

	Dog d1 = new Dog("a");
	Dog d2 = new Dog("b");
	Dog d3 = new Dog("c");

	AnimalShelter2 test = new AnimalShelter2();
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
