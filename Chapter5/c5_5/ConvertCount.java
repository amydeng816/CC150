public class ConvertCount {
    public static int count(int a, int b) {
	int x = a ^ b;
	int n = 0;
	while (x != 0) {
	    n += (x & 1);
	    x = x >> 1;
	}
	return n;
    }

    public static void main(String[] args) {
	System.out.println(count(7, 8));
    }

}
