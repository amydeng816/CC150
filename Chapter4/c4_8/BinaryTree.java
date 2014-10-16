public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {

    }

    public BinaryTree(int data) {
	root = new TreeNode(data);
    }

    public BinaryTree(TreeNode root) {
	this.root = root;
    }

    public TreeNode Root() {
	return root;
    }

    public void setRoot(TreeNode x) {
	root = x;
    }
}
