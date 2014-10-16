import java.util.LinkedList;
import java.util.Random;

public class BSTDepth {
    private LinkedList<LinkedList> l;

    public BSTDepth() {
	l = new LinkedList<LinkedList>();
    }

    public void build(TreeNode root) {
	if (root == null) {
	    return;
	}

	LinkedList<TreeNode> templ = new LinkedList<TreeNode>();
	templ.add(root);
	l.add(templ);
	while (true) {
	    templ = l.getLast();
	    LinkedList next = new LinkedList<TreeNode>();

	    for (TreeNode n : templ) {
		if (n.getLeft() != null) {
		    next.add(n.getLeft());
		}
		if (n.getRight() != null) {
		    next.add(n.getRight());
		}
	    }
	    if (!next.isEmpty()) {
		l.add(next);		
	    } else {
		break;
	    }
	}
    }

    public String toString() {
	String str = "";
	for (LinkedList<TreeNode> ll : l) {
	    for (TreeNode nn : ll) {
		str = str + nn.getData() + " ";
	    }
	    str = str + "\n";
	}
	return str;
    }
    
    public static void main(String[] args) {
	BST tree = new BST();
	Random r = new Random();
	for (int i = 0; i < 10; i++) {
	    int x = r.nextInt(20);
	    System.out.println(x);
	    tree.insert(new TreeNode(x));
	}
	System.out.println("-------------");
	tree.postOrder(tree.Root());
	System.out.println("-------------");
	BSTDepth test = new BSTDepth();
	test.build(tree.Root());
	System.out.println(test);
    }
}
