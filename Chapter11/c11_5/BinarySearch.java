public class BinarySearch {
    private int[] array = {1,2,4,5,6,7,8,10,11};

    public int searchRecursion(int n) {
	return searchRecursionHelp(n, 0, array.length - 1);
    }

    public int searchRecursionHelp(int n, int low, int high) {
	if (low > high) {
	    return -1;
	}
	int mid = (low + high) / 2;
	if (array[mid] == n) {
	    return mid;
	}
	if (array[mid] > n) {
	    return searchRecursionHelp(n, low, mid - 1);
	}
	if (array[mid] < n) {
	    return searchRecursionHelp(n, mid + 1, high);
	}
	return -1;
    }

    public int searchIteration(int n) {
	int low = 0;
	int high = array.length - 1;
	while (high >= low) {
	    int mid = (low + high) / 2;
	    if (array[mid] == n) {
		return mid;
	    }
	    if (array[mid] > n) {
		high = mid - 1;
	    } else {
		low = mid + 1;
	    }
	}
	return -1;
    }

    public static void main(String[] args) {
	BinarySearch test = new BinarySearch();
	System.out.println(test.searchIteration(-2));
	System.out.println(test.searchRecursion(-2));
    }
}
