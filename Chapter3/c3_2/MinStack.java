import java.util.Random;

public class MinStack {
    private int[] stack;
    private int[] minPtr;
    private int ptr;

    public MinStack(int capacity) {
	stack = new int[capacity];
	minPtr = new int[capacity];
	ptr = 0;
    }

    public void push(int n) {
	if (isFull()) {
	    System.out.println("Stack is full.");
	    return;
	}
	if (ptr == 0) {
	    minPtr[ptr] = n;
	} else {
	    if (minPtr[ptr - 1] > n) {
		minPtr[ptr] = n;
	    } else {
		minPtr[ptr] = minPtr[ptr - 1];
	    }
	}
	stack[ptr++] = n;
    }

    public int pop() {
	if (isEmpty()) {
	    System.out.println("Stack is empty.");
	    return 0;
	}
	return stack[--ptr];
    }

    public int min() {
	if (isEmpty()) {
	    System.out.println("Stack is empty.");
	    return 0;
	}
	return minPtr[ptr - 1];
    }

    public boolean isFull() {
	return ptr == stack.length;
    }

    public boolean isEmpty() {
	return ptr == 0;
    }

    public static void main(String[] args) {
	MinStack test = new MinStack(10);
	Random r = new Random();
	for (int i = 0; i < 11; i++) {
	    int x = r.nextInt(20);
	    test.push(x);
	    System.out.println(x + "---" + test.min());
	}
	for (int i = 0; i < 13; i++) {
	    System.out.println(test.pop() + "---" + test.min());
	}
    }

}
