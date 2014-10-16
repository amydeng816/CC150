public class Ancestor {
    public TreeNode CommonAncestorRecursion(TreeNode temp, TreeNode n1, TreeNode n2) {
	if (temp == null) {
	    return null;
	}

	if (temp == n1 || temp == n2) {
	    return temp;
	}

	boolean is_n1_on_left = covers(temp.getLeft(), n1);
	boolean is_n2_on_left = covers(temp.getLeft(), n2);
	if (is_n1_on_left != is_n2_on_left) {
	    return temp;
	}
	TreeNode side = is_n1_on_left ? temp.getLeft() : temp.getRight();
	return  CommonAncestorRecursion(side, n1, n2);
    }

    public TreeNode CommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
	if (root == null) {
	    return null;
	}
	TreeNode temp = root;
	while (true) {
	    if (temp.getLeft() == null) {
		if (temp.getRight() == null) {
		    return null;
		} else {
		    temp = temp.getRight();
		}
	    } else {
		if (temp.getRight() == null) {
		    temp = temp.getLeft();
		} else {
		    if (covers(temp.getLeft(), n1) && covers(temp.getLeft(), n2)) {
			temp = temp.getLeft();
		    } else if (covers(temp.getRight(), n1) && covers(temp.getRight(), n2)) {
			temp = temp.getRight();
		    } else {
			return temp;
		    }
		}		
	    }
	}
    }

    private boolean covers(TreeNode temp, TreeNode n) {
	if (temp == null) {
	    return false;
	}

	if (temp == n) {
	    return true;
	}

	return covers(temp.getLeft(), n) || covers(temp.getRight(), n);
	
    }
    public static void main(String[] args) {
	BinaryTree test = new BinaryTree(1);
	test.Root().setLeft(new TreeNode(2));
	test.Root().setRight(new TreeNode(3));
	test.Root().getLeft().setLeft(new TreeNode(4));
	test.Root().getLeft().setRight(new TreeNode(5));
	test.Root().getLeft().getRight().setLeft(new TreeNode(6));
	test.Root().getLeft().getRight().setRight(new TreeNode(7));
	Ancestor x = new Ancestor();
	TreeNode temp = x. CommonAncestorRecursion(test.Root(), test.Root().getLeft().getRight(), test.Root().getLeft().getRight().getLeft());
	System.out.println(temp.getData());
    }
}
