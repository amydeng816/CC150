public class Decimal {
    public static String decimalToBinary(double num) {
	String d = "0.";
	while (num > 0) {
	    if (d.length() > 32) {
		return "ERROE";
	    } 
	    double r = num * 2;
	    if (r >= 1) {
		num = r - 1;
		d += "1";
	    } else {
		num = r;
		d += "0";
	    }
	}
	return d;
    }

    public static void main(String[] args) {
	System.out.println(decimalToBinary(0.625));
    }
    
}
