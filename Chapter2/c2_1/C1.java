import java.util.Random;
import java.util.Hashtable;

public class C1{
    int delDup1 = 0;
    SLinkedList l;
    public C1(int len) {
	l = new SLinkedList();
	Random r = new Random();
	for (int i = 0; i < len; i++) {
	    //	    System.out.println(i);
	    Node temp = new Node(r.nextInt(7), l.returnHead());
	    l.setHead(temp);
	}
    }

    public void delDup1() {
	delDup1 = 0;
	Hashtable<Integer, Boolean> numbers = new Hashtable<Integer, Boolean>();
	Node temp = l.head;
	if (temp == null) {
	    return;
	}
	//	temp.setNext(temp.getNext().getNext());
	numbers.put(temp.getVal(), true);
	while (temp.getNext() != null) {
	    //	    System.out.println("--------------");
	    if (numbers.containsKey(temp.getNext().getVal())) {
		//System.out.println("--------------");
		temp.setNext(temp.getNext().getNext());
	    } else {
		numbers.put(temp.getNext().getVal(), true);	  
		temp = temp.getNext();
	    }
	}
	System.out.println(numbers);
    }


    public void delDup2() {
	Node temp = l.head;
	while (temp != null) {
	    Node tempNext = temp;
	    while (tempNext.getNext() != null) {
		if (tempNext.getNext().getVal() == temp.getVal()) {
		    tempNext.setNext(tempNext.getNext().getNext());
		} else {
		    tempNext = tempNext.getNext();
		}
	    }
	    temp = temp.getNext();
	}

    }

    public String toString() {
	Node temp = l.head;
	String str = "";
	while (temp != null) {
	    str = str + temp.getVal() + " -> ";
	    temp = temp.getNext();
	}
	return str;
    }
    public static void main(String[] args) {

	C1 test = new C1(10);
	//System.out.println("***********");
	System.out.println(test);
	test.delDup1();
	System.out.println(test);

	C1 test1 = new C1(10);
	//System.out.println("***********");
	System.out.println(test1);
	int delDup2 = 0;
	test1.delDup2();
	System.out.println(test1);

    }
}

class Node{
    int value;
    Node next;
    Node(int value) {
	this.value = value;
    }
    Node(int value, Node next) {
	this.value = value;
	this.next = next;
    }

    void setVal(int val) {
	value = val;
    }
    
    int getVal() {
	return value;
    }

    void setNext(Node next) {
	this.next = next;
    }

    Node getNext() {
	return next;
    }
}

class SLinkedList{
    Node head;
    SLinkedList(Node h) {
	head = h;
    }
    SLinkedList() {
	head = null;
    }
    void setHead(Node h) {
	head = h;
    }
    Node returnHead() {
	return head;
    }
}
