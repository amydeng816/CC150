
public class ReplSpace {
	public static String repl1(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				count++;
			}
		}
		//System.out.println(count);
		char[] newstr = new char[str.length() + count * 2];
		int j = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				newstr[j++] = '%';
				newstr[j++] = '2';
				newstr[j++] = '0';
			} else {
				newstr[j++] = str.charAt(i);
			}
		}
		return new String(newstr);
	}
	
	
	public static void main(String[] args) {
		System.out.println(repl1(args[0]));
	}
}
