public class Operations {

    public static int minus(int a, int b) {
	int h = b > 0 ? -1 : 1;
	int m = 0;
	while (b != 0) {
	    m = m + h;
	    b = b + h;
	}
	return a + m;
    }

    public static int multiply(int a, int b) {
	if (b == 0) {
	    return 0;
	}
	if (b > 0) {
	    b = minus(0, b);
	} else if (b < 0) {
	    a = minus(0, a);
	}
	int sum = 0;
	while (b != 0) {
	    sum += a;
	    b++;
	}
	return sum;

    }

    private static int abs(int a) {
	return a < 0 ? minus(0, a) : a;
    }

    public static int divide(int a1, int b1) throws java.lang.ArithmeticException {
	if (b1 == 0) {
	    throw new java.lang.ArithmeticException("error");
	}

	int a = abs(a1);
	int b = abs(b1);
	int q = 0;
	while (a >= b) {
	    int shift = 0;
	    while (a >= (b << shift)) {
		shift++;
	    }
	    //System.out.println("shift" + shift);
	    a = a + minus(0, (b << (shift - 1)));
	    //System.out.println("+++" + a);
	    q = q + 1 << (shift - 1);
	    //System.out.println("---" + q);
	}
	return (a1 > 0 && b1 < 0) || (a1 < 0 && b1 > 0) ? minus(0, q) : q;
    }

    public static void main(String[] args) {
	System.out.println(Operations.minus(10, 2));
	System.out.println(Operations.minus(-1, 2));
	System.out.println(Operations.minus(-10, -2));
	System.out.println(Operations.minus(10, -5));

	System.out.println(Operations.multiply(10, 2));
	System.out.println(Operations.multiply(-1, 2));
	System.out.println(Operations.multiply(-10, -2));
	System.out.println(Operations.multiply(10, -5));

	System.out.println("****"  + Operations.divide(10, 2));
	System.out.println(Operations.divide(-1, 2));
	System.out.println(Operations.divide(-10, -2));
	System.out.println(Operations.divide(10, -5));


    }

}
