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
	if (root == null) {
	    root = x;
	    return;
	}
	TreeNode temp = root;
	while (true) {
	    if (x.getData() > temp.getData()) {
		if (temp.getRight() == null) {
		    temp.setRight(x);
		    x.setParent(temp);
		    return;
		} else {
		    temp = temp.getRight();
		}
	    } else {
		if (temp.getLeft() == null) {
		    temp.setLeft(x);
		    x.setParent(temp);
		    return;
		} else {
		    temp = temp.getLeft();
		}
	    }
	}
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
