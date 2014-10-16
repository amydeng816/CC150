import java.util.Random;

public class C3{
    public static void del(Node m) {
	m.setVal(m.getNext().getVal());
	m.setNext(m.getNext().getNext());
    }

    public static void main(String[] args) {
	Random r = new Random();
	int n = r.nextInt(10) + 2;
	SLinkedList test = new SLinkedList();
	for (int i = 0; i < n; i++) {
	    test.add(new Node(r.nextInt()));
	}
	System.out.println(test);
	int n2 = n/2;
	Node temp = test.getHead();
	for (int i = 0; i < n2; i++) {
	    temp = temp.getNext();
	}
	C3.del(temp);
	System.out.println(n2+1);
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
