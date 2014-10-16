import java.util.ArrayList;

public class SetOfStacksWithPopAt {
    private ArrayList<Stack> l;
    private int last;
    private int sz;
    private int num;

    public SetOfStacksWithPopAt(int N) {
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
	num++;
    }

    public Integer pop() {
	if (isEmpty()) {
	    System.out.println("Empty stack");
	    return null;
	}
	if (l.get(last).isEmpty()) {
	    l.remove(last--);
	}
	num--;
	return (Integer)l.get(last).pop();
    }

    public boolean isEmpty() {
	return num == 0;
    }

    public Integer popAt(int index) {
	if (index > last) {
	    System.out.println("Index out of range.");
	    return null;
	}
	if (!l.get(index).isEmpty()) {
	    return (Integer)l.get(index).pop();
	}
	System.out.println("The stack in " + index + " is empty.");
	return null;
    }

    public static void main(String[] args) {
	SetOfStacksWithPopAt test = new SetOfStacksWithPopAt(1);
	for (int i = 0; i < 10; i++) {
	    test.push(i);
	}
	System.out.println("=========");
	for (int i = 0; i < 2; i++) {
	    System.out.println(test.popAt(3));
	}
	System.out.println("=========");
	for (int i = 0; i < 13; i++) {
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
