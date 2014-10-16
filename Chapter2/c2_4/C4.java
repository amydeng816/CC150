import java.util.Random;

public class C4{
    public static void partition(int x, SLinkedList l) {
	if (l.getHead() == null) {
	    return;
	}
	Node marker = new Node(x, l.getHead());
	boolean mfirst = true;
	l.setHead(marker);
	Node temp = l.getHead();
	while (temp.getNext() != null) {
	    if (temp.getNext().getVal() >= x) {
		temp = temp.getNext();	
	    } else {
		Node m = temp.getNext();
		temp.setNext(temp.getNext().getNext());
		m.setNext(l.getHead());
		l.setHead(m);
		if (mfirst) {
		    mfirst = false;
		    marker = m;
		}
	    }
	}
	if (mfirst) {
	    l.setHead(marker.getNext());
	} else {
	    marker.setNext(marker.getNext().getNext());
	}
	
    }

    public static void main(String[] args) {
	Random r = new Random();
	int n = r.nextInt(15) + 1;
	SLinkedList test = new SLinkedList();
	for (int i = 0; i < n; i++) {
	    test.add(new Node(r.nextInt(10)));
	}
	System.out.println(test);
	int num = r.nextInt(14);
	System.out.println(num);
	C4.partition(num,test);
	System.out.println(test);
    }
}

class Node{
    int value;
    Node next;
    Node(int val) {
	value = val;
    }
    Node(int val, Node next) {
	value = val;
	this.next = next;
    }

    int getVal() {
	return value;
    }

    Node getNext() {
	return next;
    }

    void setVal(int val) {
	value = val;
    }

    void setNext(Node next) {
	this.next = next;
    }
}

class SLinkedList{
    Node head;

    SLinkedList() {
	head = null;
    }

    Node getHead() {
	return head;
    }

    void setHead(Node h) {
	head = h;
    }

    void add(Node n) {
	Node temp = head;
	head = n;
	n.setNext(temp);
    }

    public String toString() {
	Node temp = head;
	String str = "";
	while (temp != null) {
	    str = str + temp.getVal() + " -> ";
	    temp = temp.getNext();
	}
	return str;
    }
}
