import java.util.Random;

public class C2{
    public static Wrapped recursion1(Wrapped x, int k) {
	if (x.getN() == null) {
	    x.setI(0);
	    return x;
	}
	x.setN(x.getN().getNext());
	int i = recursion1(x, k).getI() + 1;
	if (i == k) {
	    return x;
	}
	x.setI(i);
	return x;
    }

    public static Node iter(SLinkedList l, int k) {
	Node quick = l.getHead();
	for (int i = 0; i < k - 1; i++) {
	    if (quick == null) {
		return null;
	    }
	    quick = quick.getNext();
	}
	Node slow = l.getHead();
	while (quick.getNext() != null) {
	    quick = quick.getNext();
	    slow = slow.getNext();
	}
	return slow;
    }

    public static void main(String[] args) {
	Random r = new Random();
	int n = r.nextInt(10) + 10;
	SLinkedList test1 = new SLinkedList();
	for (int i = 0; i < n; i++) {
	    test1.add(new Node(r.nextInt()));
	}
	System.out.println(test1);
	Node x = C2.iter(test1, 5);
	if (x != null) {
	    System.out.println(x.getVal());
	} else {
	    System.out.println("NA");
	}

	Wrapped testr = new Wrapped(test1.getHead(), 0);
	System.out.println(testr.getN().getVal());
	Wrapped toprint = C2.recursion1(testr, 5);
	System.out.println(toprint.getN().getVal());
	
	SLinkedList test2 = new SLinkedList();
	Node x1 = C2.iter(test2, 100);
	if (x1 != null) {
	    System.out.println(x1.getVal());
	} else {
	    System.out.println("NA");
	}
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

    public void reverse() {
	if (head == null || head.getNext() == null) {
	    return;
	}
	Node temp = head.getNext();
	head.setNext(null);
	Node t = temp.getNext();
	while (t != null) {
	    temp.setNext(head);
	    head = temp;
	    temp = t;
	    t = temp.getNext();
	}
	temp.setNext(head);
	head = temp;
	
    }

    public SLinkedList copy() {
	SLinkedList l = new SLinkedList();
	Node temp = getHead();
	while (temp != null) {
	    l.add(new Node(temp.getVal()));
	    temp = temp.getNext();
	}
	return l;
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

class Wrapped{
    Node n;
    int ith;
    Wrapped(Node n, int i) {
	this.n = n;
	ith = i;
    }

    Node getN() {
	return n;
    }

    void setN(Node x) {
	n = x;
    }

    int getI() {
	return ith;
    }
    
    void setI(int i) {
	ith = i;
    }
}
