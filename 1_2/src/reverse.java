
public class reverse {
	public static StringBuffer reverseString1(String str) {
		StringBuffer s = new StringBuffer(str);
		return s.reverse();
	}
	
	public static String reverseString2(String str) {
		int len = str.length();
		char[] s = str.toCharArray();
		for (int i = 0; i < len / 2; i++) {
			char temp = s[i];
			s[i] = s[len - 1 - i];
			s[len - 1 - i] = temp;
		}
		return new String(s);
	}
	
	public static StringBuilder reverseString3(String str) {
		StringBuilder s = new StringBuilder(str);
		return s.reverse();
	}
	
	public static void main(String[] args) {
		System.out.println(reverse.reverseString1(args[0]));
		System.out.println(reverse.reverseString2(args[0]));
		System.out.println(reverse.reverseString3(args[0]));
	}
}
