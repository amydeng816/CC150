import java.util.Arrays;
import java.util.Random;

public class MinHeight {
    public static TreeNode buildTree(int[] arr) {
	return build(arr, 0, arr.length - 1);
    }

    private static TreeNode build(int[] arr, int begin, int end) {
	if (begin > end) {
	    return null;
	}
	int mid = (begin + end) / 2;
	TreeNode temp = new TreeNode(arr[mid]);
	temp.setLeft(build(arr, begin, mid - 1));
	temp.setRight(build(arr, mid + 1, end));
	return temp;
    }

    public static void main(String[] args) {
	int[] test = new int[10];
	Random r = new Random();
	for (int i = 0; i < 10; i++) {
	    test[i] = r.nextInt(20);
	}
	Arrays.sort(test);
	for (int i = 0; i < 10; i++) {
	    System.out.println(test[i]);
	}
	System.out.println("--------------");
	BinaryTree t = new BinaryTree();
	t.setRoot(MinHeight.buildTree(test));
	System.out.println(t.Root().getData());
	System.out.println(t.Root().getLeft().getData());
	System.out.println(t.Root().getLeft().getLeft().getData());
	System.out.println(t.Root().getLeft().getRight().getData());
	System.out.println(t.Root().getRight().getData());
	System.out.println(t.Root().getRight().getLeft().getData());
	System.out.println(t.Root().getRight().getRight().getData());
    }

}
