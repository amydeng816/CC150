public class ThreeStacks<E> {
    private int[] ptr;
    private int[] sz;
    private E[] arr;

    public ThreeStacks(int capacity) {
	arr = (E[]) new Object[capacity];
	int n = capacity / 3;
	ptr = new int[] {0, n, n * 2};
	sz = new int[] {n, n, arr.length - 2 * n};
    }
    
    public E pop(int stackNum) {
	if (isEmpty(stackNum)) {
	    System.out.println("Stack " + stackNum + " is empty.");
	    return null;
	}
	E temp = arr[--ptr[stackNum - 1]];
	arr[ptr[stackNum - 1]] = null;
	return temp;
    }

    public void push(int stackNum, E data) {
	if (isFull(stackNum)) {
	    System.out.println("Stack " + stackNum + " is full.");
	    return;
	}
	arr[ptr[stackNum - 1]] = data;
	ptr[stackNum - 1]++;
    }

    public boolean isFull(int stackNum) {
	int s = 0;
	for (int i = 0; i < stackNum; i++) {
	    s = s + sz[i];
	}
	return ptr[stackNum - 1] == s;
    }

    public boolean isEmpty(int stackNum) {
	return ptr[stackNum - 1] == 0;
    }

    public E peek(int stackNum) {
	if (isEmpty(stackNum)) {
	    return null;
	}
	return arr[ptr[stackNum - 1] - 1];
    }

    public static void main(String[] args) {
	ThreeStacks<Integer> test = new ThreeStacks<Integer>(100);
	test.pop(1);
	System.out.println(test.peek(3));
	for (int i = 0; i < 35; i++) {
	    test.push(3, i);
	}
	System.out.println(test.peek(3));
	for (int i = 0; i < 37; i++) {
	    System.out.println(test.pop(3));
	}

    }
}
