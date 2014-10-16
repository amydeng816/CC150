import java.util.PriorityQueue;
import java.util.Collection;
import java.util.LinkedList;

public class FindKth {
    public static Integer find(int k, Collection<Integer> c) {
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(c);
	int count = 0;
	Integer kth = null;
	while (count < k) {
	    kth = pq.peek();
	    pq.remove(kth);
	    for (Integer num : c) {
		if (!pq.contains(num * kth)) {
		    pq.offer(num * kth);
		}
	    }
	    count++;
	}
	return kth;
    }

    public static void main(String[] args) {
	LinkedList<Integer> l = new LinkedList<Integer>();
	l.add(3);
	l.add(5);
	l.add(7);
	for (int i = 1; i < 11; i++) {
	    System.out.println(FindKth.find(i, l));
	}
    }

}
