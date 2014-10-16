public class SumPath {

    public void findSum(TreeNode node, int sum) {
	int depth = depth(node);
	int[] path = new int[depth];
	findSum(node, sum, path, 0);
    }

    private void findSum(TreeNode node, int sum, int[] path, int level) {
	if (node == null) {
	    return;
	}

	path[level] = node.getData();
	int t = 0;
	for (int i = level; i >= 0; i--) {
	    t += path[i];
	    if (t == sum) {
		print(path, i, level);
	    }
	}

	findSum(node.getLeft(), sum, path, level + 1);
	findSum(node.getRight(), sum, path, level + 1);

	path[level] = Integer.MIN_VALUE;
    }

    public static void print(int[] path, int start, int end) {
	for (int i = start; i <= end; i++) {
	    System.out.println(path[i] + " ");
	}
	System.out.println();
    }

    public int depth(TreeNode node) {
	if (node == null) {
	    return 0;
	}
	return Math.max(depth(node.getLeft()), depth(node.getRight())) + 1;
    }

    
    public static void main(String[] args) {
	BinaryTree t1 = new BinaryTree(1);
	t1.Root().setLeft(new TreeNode(2));
	t1.Root().setRight(new TreeNode(3));
	t1.Root().getLeft().setLeft(new TreeNode(4));
	t1.Root().getLeft().setRight(new TreeNode(5));
	t1.Root().getLeft().getRight().setLeft(new TreeNode(6));
	t1.Root().getLeft().getRight().setRight(new TreeNode(7));
	SumPath test = new SumPath();
	test.findSum(t1.Root(), 7);
    }
}
