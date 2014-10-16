public class FindString {
    private String[] strs = {"", "a", "", "b", "c", "", "", "", "d", "", "", "", "", "e", "g", "x", "", "", "", "", "z", "", "", ""};

    public int find(String str) {
	return findHelp(str, 0, strs.length - 1);
    }

    private int findHelp(String str, int low, int high) {
	if (low > high) {
	    return -1;
	}
	int mid = (low + high) / 2;
	int i = mid;
	while (i >= low) {
	    if ("".compareTo(strs[i]) != 0) {
		int comp = str.compareTo(strs[i]);
		if (comp == 0) {
		    return i;
		}
		if (comp < 0) {
		    return findHelp(str, low, i - 1);
		}
		if (comp > 0) {
		    return findHelp(str, mid + 1, high);
		}
	    } 
	    i--;
	}
	return -1;
    }

    public static void main(String[] args) {
	System.out.println((new FindString()).find("e"));
    }

}
