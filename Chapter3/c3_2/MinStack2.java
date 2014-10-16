import java.util.Random;
import java.util.Stack;

/* A practice of decorator pattern */
public class MinStack2 extends Stack<Integer> {
    private Stack<Integer> minPtr;

    public MinStack2() {
	minPtr = new Stack<Integer>();
    }

    public void push(int n) {
	if (minPtr.isEmpty() || n <= minPtr.peek()) {
	    minPtr.push(n);
	}
	super.push(n);
    }

    public Integer pop() {
	Integer temp = super.pop();
	if (temp == minPtr.peek()) {
	    minPtr.pop();
	}
	return temp;
    }

    public Integer min() {
	return minPtr.peek();
    }


    public static void main(String[] args) {
	MinStack2 test = new MinStack2();
	Random r = new Random();
	for (int i = 0; i < 11; i++) {
	    int x = r.nextInt(20);
	    test.push(x);
	    System.out.println(x + "---" + test.min());
	}
	System.out.println("+++++++++++");
	for (int i = 0; i < 11; i++) {
	    System.out.println(test.min() + "---" + test.pop());
	}
    }

}
