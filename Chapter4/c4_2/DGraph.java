import java.util.LinkedList;
import java.util.Hashtable;
import java.util.Set;

public class DGraph {
    Hashtable<Node, LinkedList<Node>> adj;

    public DGraph() {
	adj = new Hashtable<Node, LinkedList<Node>>();
    }

    public void insert(Node start, Node end) {
	if (!adj.containsKey(start)) {
	    adj.put(start, new LinkedList<Node>());
	}
	adj.get(start).add(end);
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
