import java.util.Random;

public class FindNext {
    public TreeNode findNext(TreeNode x) {
	if (x == null) {
	    return null;
	}
	if (x.getRight() != null) {
	    x = x.getRight();
	    return mostLeft(x);
	} else {
	    while (x.Parent() != null && x.getData() > x.Parent().getData()) {
		x = x.Parent();
	    }
	}
	return x.Parent();
    }

    private TreeNode mostLeft(TreeNode x) {
	TreeNode temp = x;
	while (temp.getLeft() != null) {
	    temp = temp.getLeft();
	}
	return temp;
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
	tree.inOrder(tree.Root());
	System.out.println("-------------");
	FindNext test = new FindNext();
	System.out.println(test.findNext(tree.Root()).getData());
	System.out.println("-------------");
	TreeNode temp = test.findNext(tree.Root().getLeft());
	if (temp != null) {
	    System.out.println(temp.getData());
	}
	System.out.println("-------------");
	temp = test.findNext(tree.Root().getRight());
	if (temp != null) {
	    System.out.println(temp.getData());
	}
    }
}
