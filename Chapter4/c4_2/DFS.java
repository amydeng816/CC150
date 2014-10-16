import java.util.Hashtable;
import java.util.LinkedList;

public class DFS {
    private Hashtable<Node, LinkedList<Node>> adj;

    public DFS(Graph g) {
	adj = g.graphHash();
    }

    public void graphDFS(Node n) {
	if (n == null) {
	    return;
	}
	n.setVisited(true);
	System.out.println(n.getData());
	LinkedList<Node> v = adj.get(n);
	for (Node x : v) {
	    if (!x.isVisited()) {
		graphDFS(x);
	    }
	}
	
    }

    public static void main(String[] args) {
	Graph g = new Graph();
	Node<Integer> n1 = new Node<Integer>(1);
	Node<Integer> n2 = new Node<Integer>(2);
	Node<Integer> n3 = new Node<Integer>(3);
	Node<Integer> n4 = new Node<Integer>(4);
	Node<Integer> n5 = new Node<Integer>(5);
	Node<Integer> n6 = new Node<Integer>(6);
	Node<Integer> n7 = new Node<Integer>(7);
	Node<Integer> n8 = new Node<Integer>(8);
	Node<Integer> n9 = new Node<Integer>(9);
	g.insert(n1, n2);
	g.insert(n1, n3);
	g.insert(n3, n4);
	g.insert(n4, n5);
	g.insert(n4, n8);
	g.insert(n4, n6);
	g.insert(n6, n7);
	g.insert(n7, n3);
	g.insert(n8, n9);
	g.insert(n7, n9);
	g.print();
	DFS test = new DFS(g);
	test.graphDFS(n1);
    }
}
