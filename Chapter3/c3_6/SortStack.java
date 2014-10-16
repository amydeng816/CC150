import java.util.Random;
import java.util.Stack;

public class SortStack {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public SortStack() {
	s1 = new Stack<Integer>();
	s2 = new Stack<Integer>();
    }

    public void sort() {
	Integer temp = null;
	while (!s1.isEmpty()) {
	    temp = s1.pop();
	    while (!s2.isEmpty() && temp.compareTo(s2.peek()) < 0) {
		s1.push(s2.pop());
	    }
	    s2.push(temp);	
	}
    }

    public static void main(String[] args) {
	Random r = new Random();
	SortStack test = new SortStack();
	for (int i = 0; i < 10; i++) {
	    int x = r.nextInt(20);
	    test.s1.push(x);
	    System.out.println(x);
	}
	test.sort();
	System.out.println("----------");

	for (int i = 0; i < 10; i++) {
	    System.out.println(test.s2.pop());
	}
    }
    
}
