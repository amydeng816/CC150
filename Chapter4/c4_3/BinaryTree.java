public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
	root = new TreeNode();
    }

    public BinaryTree(int data) {
	root = new TreeNode(data);
    }

    public BinaryTree(TreeNode root) {
	this.root = root;
    }

    public void setRoot(TreeNode root) {
	this.root = root;
    }

    public TreeNode Root() {
	return root;
    }

}
