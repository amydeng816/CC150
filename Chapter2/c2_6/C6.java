import java.util.Random;

public class C6{
    public static int findCircle(CLinkedList l) {
	Node runnerQuick = l.getHead();
	Node runnerSlow = l.getHead();
	do {
	    //	    System.out.println("*********");
	    runnerQuick = runnerQuick.getNext().getNext();
	    runnerSlow = runnerSlow.getNext();
	} while (!runnerQuick.equals(runnerSlow));
	//	System.out.println("*********");
	runnerQuick = l.getHead();
	int i = 1;
	do {
	    i++;
	    runnerQuick = runnerQuick.getNext();
	    runnerSlow = runnerSlow.getNext();
	} while (!runnerQuick.equals(runnerSlow));
	return i;
    }

    public static void main(String[] args) {
	Random r = new Random();
	int n = r.nextInt(10) + 10;
	CLinkedList test = new CLinkedList();
	for (int i = 0; i < n; i++) {
	    test.add(new Node(r.nextInt()));
	}
	System.out.println(test);
	int val = r.nextInt(10) + 1;
	System.out.println(val);

	if (test.circle(val)) {
	    System.out.println("-------------");
	    //System.out.println(test);
	    System.out.println(C6.findCircle(test));
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

class CLinkedList{
    Node head;
    Node tail;

    CLinkedList() {
	head = null;
	tail = head;
    }

    Node getHead() {
	return head;
    }

    void setHead(Node h) {
	if (head == null) {
	    tail = h;
	}
	head = h;
    }

    void add(Node n) {
	Node temp = head;
	if (temp == null) {
	    tail = n;
	}
	head = n;
	n.setNext(temp);
    }

    Node getTail() {
	return tail;
    }

    boolean circle(int num) {
	Node temp = head;
	int i = 1;
	while (temp != null && i < num) {
	    i++;
	    temp = temp.getNext();
	}
	
	if (i == num && temp != null) {
	    System.out.println(tail.getVal());
	    tail.setNext(temp);
	    System.out.println(tail.getNext().getVal());
	    /*	    System.out.println(tail.getNext().getNext().getVal());
	    temp = tail;
	    while (temp != null) {
		System.out.println(temp.getVal());
		temp = temp.getNext();
		}*/
	    return true;
	}
	return false;
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
