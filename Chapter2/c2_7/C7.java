import java.util.Random;
import java.util.Stack;

public class C7{
    public static boolean isPalindrome1(SLinkedList l) {
	if (l.getHead() == null) {
	    return true;
	}
	Stack<Integer> s = new Stack<Integer>();
	Node runnerQuick = l.getHead();
	Node runnerSlow = l.getHead();
	while (runnerQuick.getNext() != null && runnerQuick.getNext().getNext() != null) {
	    runnerQuick = runnerQuick.getNext().getNext();
	    s.push(runnerSlow.getVal());
	    runnerSlow = runnerSlow.getNext();
	}
	if (runnerQuick.getNext() != null) {
	    runnerSlow = runnerSlow.getNext();
	}
	runnerSlow = runnerSlow.getNext();
	while (runnerSlow != null) {
	    if (s.pop() != runnerSlow.getVal()) {
		return false;
	    }
	    runnerSlow = runnerSlow.getNext();
	}
	return true;
    }

    public static boolean isPalindrome2(SLinkedList l) {
	SLinkedList lr = l.copy();
	Node temp = l.getHead();
	Node tempr = lr.getHead();
	while (temp != null) {
	    if (temp.getVal() != tempr.getVal()) {
		return false;
	    }
	    temp = temp.getNext();
	    tempr = tempr.getNext();
	}
	return true;
    }
    public static void main(String[] args) {
	Random r = new Random();
	int n = r.nextInt(10) + 10;
	SLinkedList test1 = new SLinkedList();
	for (int i = 0; i < n; i++) {
	    test1.add(new Node(r.nextInt()));
	}
	System.out.println(test1);
	System.out.println(C7.isPalindrome2(test1));
	System.out.println(C7.isPalindrome1(test1));
	SLinkedList test2 = new SLinkedList();
	test2.add(new Node(1));
	test2.add(new Node(2));
	test2.add(new Node(2));
	test2.add(new Node(1));

	System.out.println(test2);
	System.out.println(C7.isPalindrome2(test2));
	System.out.println(C7.isPalindrome1(test2));
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
