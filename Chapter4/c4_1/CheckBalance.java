public class CheckBalance {
    public static boolean isBalanced(TreeNode root) {
	if (root == null) {
	    return true;
	}
	int diff = getHeight(root.getLeft()) - getHeight(root.getRight());
	if (diff > 1 || diff < -1) {
	    return false;
	}
	return isBalanced(root.getLeft()) && isBalanced(root.getRight());
    }

    private static int getHeight(TreeNode root) {
	if (root == null) {
	    return 0;
	}
	return 1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
    }

    public static void main(String[] args) {
	BinaryTree test = new BinaryTree(1);
	test.Root().setLeft(new TreeNode(2));
	test.Root().setRight(new TreeNode(3));
	test.Root().getLeft().setLeft(new TreeNode(4));
	test.Root().getLeft().setRight(new TreeNode(5));
	test.Root().getLeft().getRight().setLeft(new TreeNode(6));
	//	test.Root().getLeft().getRight().setRight(new TreeNode(7));

	System.out.println(isBalanced(test.Root()));
    }
}
