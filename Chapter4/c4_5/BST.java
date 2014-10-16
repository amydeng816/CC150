public class BST {
    private TreeNode root;
    
    public BST() {
    }

    public BST(TreeNode root) {
	this.root = root;
    }

    public void setRoot(TreeNode root) {
	this.root = root;
    }

    public TreeNode Root() {
	return root;
    }

    public void insert(TreeNode x) {
	root = insertHelp(x, root);
    }
    
    private TreeNode insertHelp(TreeNode x, TreeNode temp) {
	if (temp == null) {
	    return x;
	}
	if (temp.getData() >= x.getData()) {
	    temp.setLeft(insertHelp(x, temp.getLeft()));
	} else {
	    temp.setRight(insertHelp(x, temp.getRight()));
	}
	return temp;
    }

    public void preOrder(TreeNode x) {
	if (x == null) {
	    return;
	}
	System.out.println(x.getData());
	preOrder(x.getLeft());
	preOrder(x.getRight());
    }


    public void inOrder(TreeNode x) {
	if (x == null) {
	    return;
	}
	inOrder(x.getLeft());
	System.out.println(x.getData());
	inOrder(x.getRight());
    }


    public void postOrder(TreeNode x) {
	if (x == null) {
	    return;
	}
	postOrder(x.getLeft());
	postOrder(x.getRight());
	System.out.println(x.getData());
    }
}
