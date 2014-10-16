import java.util.LinkedList;
import java.util.Hashtable;
import java.util.Set;

public class Graph {
    Hashtable<Node, LinkedList<Node>> adj;

    public Graph() {
	adj = new Hashtable<Node, LinkedList<Node>>();
    }

    public void insert(Node n1, Node n2) {
	if (!adj.containsKey(n1)) {
	    adj.put(n1, new LinkedList<Node>());
	}
	if (!adj.containsKey(n2)) {
	    adj.put(n2, new LinkedList<Node>());
	}
	adj.get(n1).add(n2);
	adj.get(n2).add(n1);
    }

    public void print() {
	Set<Node> keys = adj.keySet();
	for(Node key : keys) {
	    System.out.println(key.getData() + ": ");
	    LinkedList<Node> temp = adj.get(key);
	    for (Node x : temp) {
		System.out.print(x.getData() + "->");
	    }
	    System.out.println();
	}
    }

    public Hashtable<Node, LinkedList<Node>> graphHash() {
	return adj;
    }
}
