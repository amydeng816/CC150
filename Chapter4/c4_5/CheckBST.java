import java.util.Random;

public class CheckBST {
    private Integer l;
    public CheckBST() {
	l = Integer.MIN_VALUE;
    }

    private boolean checkHelp(TreeNode temp) {
	if (temp == null) {
	    return true;
	}
	checkHelp(temp.getLeft());
	if (l.compareTo(temp.getData()) > 0) {
	    return false;
	} else {
	    l = temp.getData();
	}
	checkHelp(temp.getRight());
	return true;
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
	tree.Root().setData(0);
	System.out.println("-------------");
	CheckBST test = new CheckBST();
	System.out.println(test.checkHelp(tree.Root()));
	tree.inOrder(tree.Root());
    }
}
