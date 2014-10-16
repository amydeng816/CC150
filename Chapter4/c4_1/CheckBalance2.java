public class CheckBalance2 {
    public static boolean isBalanced(TreeNode root) {
	return getHeight(root) != -1;
    }

    private static int getHeight(TreeNode root) {
	if (root == null) {
	    return 0;
	}
	
	int left = getHeight(root.getLeft());
	if (left == -1) {
	    return -1;
	}

	int right = getHeight(root.getRight());
	if (right == -1) {
	    return -1;
	}

	int diff = left - right;
	if (diff > 1 || diff < -1) {
	    return -1;
	}
	return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
	BinaryTree test = new BinaryTree(1);
	test.Root().setLeft(new TreeNode(2));
	test.Root().setRight(new TreeNode(3));
	test.Root().getLeft().setLeft(new TreeNode(4));
	test.Root().getLeft().setRight(new TreeNode(5));
	test.Root().getLeft().getRight().setLeft(new TreeNode(6));
	test.Root().getLeft().getRight().setRight(new TreeNode(7));

	System.out.println(isBalanced(test.Root()));
    }
}
