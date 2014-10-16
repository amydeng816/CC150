public class RankNode {
    public int left_size = 0;
    public RankNode left, right;
    public int data = 0;
    public RankNode(int d) {
	data = d;
    }

    public void insert(int d) {
	if (d <= data) {
	    if (left != null) {
		left.insert(d);
	    } else {
		left = new RankNode(d);
	    }
	    left_size++;
	} else {
	    if (right != null) {
		right.insert(d);
	    } else {
		right = new RankNode(d);
	    }
	}
    }
    

    public int getRank(int d) {
	if (d == data) {
	    return left_size;
	}
	if (d < data) {
	    if (left == null) {
		return -1;
	    }
	    return left.getRank(d);
	} else {
	    if (right == null) {
		return -1;
	    }
	    return 1 + left_size + right.getRank(d);
	}
    }
}
