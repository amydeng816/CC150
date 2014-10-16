public class Insert {
    final static int BITS = 32;
    public static String ins(String X, String Y, int i, int j) {
	int M = Integer.parseInt(X, 2);
	//System.out.println(M);
	int N = Integer.parseInt(Y, 2);
	//System.out.println(N);
	int len = j - i + 1;
	int addM = (~0) << len;
	//System.out.println(Integer.toBinaryString(addM));
	M = (~(M | addM)) << i;
	//System.out.println(Integer.toBinaryString(M));
	int x = ((~((~0) << (j + 1))) >> i) << i;
	//System.out.println(Integer.toBinaryString(x | N));
	return Integer.toBinaryString(M ^ (x | N));
    }

    public static void main(String[] args) {
	System.out.println(Insert.ins("10011", "10000000000", 2, 6));
    }

}
