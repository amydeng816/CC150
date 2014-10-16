public class FindSameOne {
    public static Long findMin(Long num) {
	int ones = 0;
	int i = 0;
	char[] x = Long.toBinaryString(num).toCharArray();
	for (i = x.length - 1; i > 0; i--) {
	    if (x[i] == '1') {
		ones++;
	    }
	    if (x[i] == '1' && x[i - 1] == '0') {
		x[i - 1] = '1';
		ones--;
		break;
	    }
	}

	for (int j = i; j < x.length - ones; j++) {
	    x[j] = '0';
	}
	for (i = x.length - 1; i > x.length - ones - 1; i--) {
	    x[i] = '1';
	    //	    System.out.println(x[i]);
	}
	String minS = new String(x);
	System.out.println(minS);
	return Long.parseLong(minS, 2);
    }

    public static int getNext(int n) {
	int c = n;
	int c0 = 0;
	int c1 = 0;
	while ((c & 1) == 0 && (c != 0)) {
	    c0++;
	    c >>= 1;
	}
	while ((c & 1) == 1) {
	    c1++;
	    c >>= 1;
	}
	if (c0 + c1 == 0 || c0 + c1 == 31) { // here is 31 because there is sign bit
	    return -1;
	}
	int p = c1 + c0;
	n |= (1 << p);
	n &= (~((1 << p) - 1));
	n |= ((1 << (c1 - 1)) - 1);
	System.out.println(Integer.toBinaryString(n));
	return n;
    }

    public static int getPrev(int n) {
	int c0 = 0;
	int c1 = 0;
	int c = n;
	while ((c & 1) == 1) {
	    System.out.println("---");
	    c1++;
	    c >>= 1;
	}
	while (((c & 1) == 0) && (c != 0)) {
	    c0++;
	    c >>= 1;
	}
	if (c == 0) {
	    return -1;
	}
	int p = c0 + c1;
	n &= ((~0) << (p + 1));
	int mask = (1 << (c1 + 1)) - 1;
	System.out.println(c1);
	System.out.println(c0);
	System.out.println(Integer.toBinaryString(mask));
	mask = (mask << (c0 - 1));
	System.out.println(Integer.toBinaryString(mask));
	n |= mask;
	System.out.println(Integer.toBinaryString(n));
	return n;
    }

    public static void main(String[] args) {
	FindSameOne.findMin(Long.parseLong("11011001111100", 2));
	FindSameOne.getNext(Integer.parseInt("11011001111100", 2));
	FindSameOne.getPrev(Integer.parseInt("11011001111100", 2));
    }


}
