import java.util.Random;

public class Merge {
    private int[] A;
    private int[] B;
    private int N;

    public Merge(int a, int b) {
	N = a + b;
	A = new int[N];
	B = new int[b];
	int M = 100;
	Random r = new Random();
	A[0] = r.nextInt(M);
	for (int i = 1; i < a; i++) {
	    M += 100;
	    A[i] = A[i - 1] + 1 + r.nextInt(M);
	}
	shuffle(A, a);
	print(A);
	MergeSort m = new MergeSort();
	m.mergesort(A, 0, a - 1);
	M = 100;
	B[0] = r.nextInt(M);
	for (int i = 1; i < b; i++) {
	    B[i] = r.nextInt(M) + 1 + B[i - 1];
	}
	shuffle(B, b);
	print(B);
	m.mergesort(B, 0, b - 1);
    }


    private void shuffle(int[] s, int high) {
	Random r = new Random();
	for (int i = 1; i < high; i++) {
	    int pos = r.nextInt(i);
	    int temp = s[i];
	    s[i] = s[pos];
	    s[pos] = temp;
	}
    }

    public static void print(int[] x) {
	for (int i = 0; i < x.length; i++) {
	    System.out.print(x[i] + " ");
	}
	System.out.println();
    }

    public void merge() {
	int a = N - B.length - 1;
	int b = B.length - 1;
	int n = N - 1;
	while (n >= 0) {
	    if (b < 0) {
		return;
	    }
	    if (a < 0) {
		A[n] = B[b--];
	    } else {
		if (A[a] > B[b]) {
		    A[n] = A[a--];
		} else {
		    A[n] = B[b--];
		}
	    }
	    n--;
	}
    }

    public static void main(String[] args) {
	Merge test = new Merge(5, 6);
	test.print(test.A);
	test.print(test.B);
	test.merge();
	test.print(test.A);
    }

}
