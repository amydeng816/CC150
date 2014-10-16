

public class hasUnique {
	public static boolean checkUnique1(String s) {
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i);
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(j) == val) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean checkUnique2(String s) {
		if (s.length() > 256) {
			return false;
		}
			
		boolean[] count = new boolean[256]; 
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i);
			if (count[val]) {
				return false;
			}
			count[val] = true;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(hasUnique.checkUnique1(args[0]));
		System.out.println(hasUnique.checkUnique2(args[0]));
	}
}

