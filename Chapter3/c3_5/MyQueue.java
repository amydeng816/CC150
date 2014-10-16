import java.util.Stack;
import java.util.Random;

public class MyQueue<E> {
    Stack<E> s1;
    Stack<E> s2;

    public MyQueue() {
	s1 = new Stack<E>();
	s2 = new Stack<E>();
    }

    public int size() {
	return s1.size() + s2.size();
    }

    public void enqueue(E x) {
	s1.push(x);
    }

    public E dequeue() {
	if (s2.isEmpty()) {
	    reverse();
	}
	return s2.pop();	
    }

    private void reverse() {
	while (!s1.isEmpty()) {
	    s2.push(s1.pop());
	}
    }

    public E peek() {
	if (isEmpty()) {
	    return null;
	}
	if (s2.isEmpty()) {
	    reverse();
	}
	return s2.peek();	
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    public static void main(String[] args) {
	MyQueue<Integer> test = new MyQueue<Integer>();
	Random r = new Random();
	for (int i = 0; i < 10; i++) {
	    int x = r.nextInt(20);
	    System.out.println(x);
	    test.enqueue(x);
	}
	System.out.println("------------");
	for (int i = 0; i < 11; i++) {
	    System.out.println(test.peek());
	    System.out.println(test.dequeue());
	}
    }
}
