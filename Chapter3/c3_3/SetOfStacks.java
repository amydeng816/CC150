import java.util.ArrayList;

public class SetOfStacks {
    private ArrayList<Stack> l;
    private int last;
    private int sz;

    public SetOfStacks(int N) {
	l = new ArrayList<Stack>();
	l.add(new Stack<Integer>(N));
	sz = N;
    }

    public void push(Integer x) {
	if (l.get(last).isFull()) {
	    l.add(new Stack<Integer>(sz));
	    last++;
	}
	l.get(last).push(x);
    }

    public Integer pop() {
	if (isEmpty()) {
	    System.out.println("Empty stack");
	    return null;
	}
	if (l.get(last).isEmpty()) {
	    l.remove(last--);
	}
	return (Integer)l.get(last).pop();
    }

    public boolean isEmpty() {
	return l.get(0).isEmpty();
    }

    public static void main(String[] args) {
	SetOfStacks test = new SetOfStacks(10);
	for (int i = 0; i < 100; i++) {
	    test.push(1);
	}
	for (int i = 0; i < 100; i++) {
	    System.out.println(test.pop());
	}
	
    }
}

class Stack<E> {
    int sz;
    int ptr;
    E[] s;

    public Stack(int N) {
	sz = N;
	s = (E[])new Object[N];
    }

    public void push(E x) {
	if (isFull()) {
	    System.out.println("Stack is full.");
	    return;
	}
	s[ptr++] = x;
    }

    public E pop() {
	if (isEmpty()) {
	    System.out.println("Stack is empty.");
	    return null;
	}
	E temp = s[--ptr];
	s[ptr] = null;
	return temp;
    }

    public boolean isFull() {
	return ptr == sz;
    }

    public boolean isEmpty() {
	return ptr == 0;
    }
}
