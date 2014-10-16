import java.util.Arrays;


public class Permu {
	public static boolean isPermu1(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		int[] count = new int[256];
		for (int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i)]++;
		}
		for (int i = 0; i < s2.length(); i++) {
			int index = s2.charAt(i);
			if (count[index] < 1) {
				return false;
			}
			count[index]--;
		}
		return true;
	}

	private String sort(String str) {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	public boolean isPermu2(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		return sort(s1).equals(sort(s2));
	}
	
	public static void main(String[] args) {
		System.out.println(Permu.isPermu1("hello", "oellh"));
		Permu test = new Permu();
		System.out.println(test.isPermu2("dlls", "klsld"));
	}
}
