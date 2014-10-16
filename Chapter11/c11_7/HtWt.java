public class HtWt implements Comparable {
    private int height;
    private int weight;

    public HtWt(int h, int w) {
	height = h;
	weight = w;
    }

    public int compareTo(Object s) {
	HtWt second = (HtWt)s;
	if (second.height != height) {
	    return second.height < height ? 1 : -1;
	}
	if (second.weight == weight) {
	    return 0;
	}
	return second.weight < weight ? 1 : -1;
    }

    public boolean isBefore(HtWt other) {
	return (height < other.height && weight < other.weight);
    }

}
