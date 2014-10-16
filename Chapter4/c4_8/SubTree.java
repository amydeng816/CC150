public class SubTree {

    public boolean containsTree(TreeNode t1, TreeNode t2) {
	if (t2 == null) {
	    return true;
	}
	return isSubTree(t1, t2);
    }

    private boolean isSubTree(TreeNode t1, TreeNode t2) {
	if (t1 == null) {
	    return false;
	}

	if (t1.getData() == t2.getData()) {
	    if (match(t1, t2)) {
		return true;
	    }
	}
	return isSubTree(t1.getLeft(), t2) || isSubTree(t1.getRight(), t2);
    }

    private boolean match(TreeNode t, TreeNode t2) {
	if (t == null && t2 == null) {
	    return true;
	} 
	
	if (t == null || t2 == null) {
	    return false;
	}

	if (t.getData() != t2.getData()) {
	    return false;
	}
	return match(t.getLeft(), t2.getLeft()) && match(t.getRight(), t2.getRight());
    }

    public static void main(String[] args) {
	BinaryTree t1 = new BinaryTree(1);
	t1.Root().setLeft(new TreeNode(2));
	t1.Root().setRight(new TreeNode(3));
	t1.Root().getLeft().setLeft(new TreeNode(4));
	t1.Root().getLeft().setRight(new TreeNode(5));
	t1.Root().getLeft().getRight().setLeft(new TreeNode(6));
	t1.Root().getLeft().getRight().setRight(new TreeNode(7));
	SubTree test = new SubTree();
	BinaryTree t2 = new BinaryTree(5);
	t2.Root().setLeft(new TreeNode(6));
	//t2.Root().setRight(new TreeNode(7));
	System.out.println(test.isSubTree(t1.Root(), t2.Root()));
    }
}
