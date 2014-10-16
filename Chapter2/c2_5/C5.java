import java.util.Random;
import java.util.LinkedList;

public class C5{
    public static LinkedList sum1(LinkedList l1, LinkedList l2) {
	if (l1.size() == 0 && l2.size() == 0) {
	    return null;
	}
	LinkedList<Integer> l;
	LinkedList<Integer> temp;
	if (l1.size() > l2.size()) {
	    l = (LinkedList<Integer>)l1.clone();
	    temp = l2;
	} else {
	    l = (LinkedList<Integer>)l2.clone();
	    temp = l1;
	}
	int ten = 0;
	for (int i = 0; i < l.size(); i++) {
	    int t = 0;
	    if (i < temp.size()) {
		t = temp.get(i);
	    } 
	    int s = l.get(i) + t + ten;
	    ten = s / 10;
	    l.set(i, s % 10);
	}
	if (ten != 0) {
	    l.add(ten);
	}
	return l;
    }


    public static LinkedList sum2(LinkedList l1, LinkedList l2) {
	if (l1.size() == 0 && l2.size() == 0) {
	    return null;
	}
	LinkedList<Integer> l;
	LinkedList<Integer> temp;
	if (l1.size() > l2.size()) {
	    l = (LinkedList<Integer>)l1.clone();
	    temp = l2;
	} else {
	    l = (LinkedList<Integer>)l2.clone();
	    temp = l1;
	}
	int ten = 0;
	for (int i = l.size() - 1; i >= 0; i--) {
	    int t = 0;
	    if (i > l.size() - temp.size() - 1) {
		t = temp.get(temp.size() - (l.size() - i));
	    } 
	    int s = l.get(i) + t + ten;
	    ten = s / 10;
	    l.set(i, s % 10);
	}
	if (ten != 0) {
	    l.addFirst(ten);
	}
	return l;
    }

    public static void main(String[] args) {
	Random r = new Random();
	int n = r.nextInt(15);
	LinkedList<Integer> l1 = new LinkedList<Integer>();
	for (int i = 0; i < n; i++) {
	    l1.add(r.nextInt(10));
	}
	System.out.println(l1);
	   
	n = r.nextInt(15);
	LinkedList<Integer> l2 = new LinkedList<Integer>();
	for (int i = 0; i < n; i++) {
	    l2.add(r.nextInt(10));
	}
	System.out.println(l2);
	System.out.println(sum1(l1, l2));
	System.out.println(sum2(l1, l2));
    }
}

