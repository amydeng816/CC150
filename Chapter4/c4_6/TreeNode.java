public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;
    private TreeNode parent;

    public TreeNode(int data) {
	this.data = data;
    }

    public TreeNode(TreeNode parent) {
	this.parent = parent;
    }

    public TreeNode() {

    }

    public int getData() {
	return data;
    }

    public void setData(int data) {
	this.data = data;
    }

    public void setParent(TreeNode parent) {
	this.parent = parent;
    }

    public TreeNode Parent() {
	return parent;
    }

    public TreeNode getLeft() {
	return left;
    }

    public TreeNode getRight() {
	return right;
    }		

    public void setLeft(TreeNode left) {
	this.left = left;
    }

    public void setRight(TreeNode right) {
	this.right = right;
    }
}
