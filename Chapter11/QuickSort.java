import java.util.Random;

public class QuickSort {
    void quickSort(int arr[], int left, int right) {
	int index = partition(arr, left, right);
	if (left < index - 1) {
	    quickSort(arr, left, index - 1);
	}
	if (index < right) {
	    quickSort(arr, index, right);
	}
    }

    int partition(int arr[], int left, int right) {
	int pivot = arr[(left + right) / 2];
	while (left <= right) {
	    while (arr[left] < pivot) {
		left++;
	    }
	    while (arr[right] > pivot) {
		right--;
	    }
	    if (left <= right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
		left++;
		right--;
	    }
	}
	return left;
    }

    public static void main(String[] args) {
	Random r = new Random();
	int N = 10;
	int[] array = new int[N];
	for (int i = 0; i < N; i++) {
	    array[i] = r.nextInt(100);
	}
	for (int i = 0; i < N; i++) {
	    System.out.println(array[i]);
	}
	QuickSort test = new QuickSort();
	test.quickSort(array, 0, N - 1);
	System.out.println("----------");
	for (int i = 0; i < N; i++) {
	    System.out.println(array[i]);
	}

    }
}
