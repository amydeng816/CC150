

public class Compress {
	public static String compressStr1(String str) {
		char[] arr = new char[str.length()];
		int j = 0;
		int count = 0;
		arr[0] = str.charAt(0);
		for (int i = 0; i < arr.length; i++) {
			if (arr[j] != str.charAt(i)) {
				j++;
				if (j >= arr.length){
					return str;
				} 
				arr[j++] = (char)count;
				count = 1;
				arr[j] = str.charAt(i);
			} else {
				count++;
			}
		}
		if (++j >= arr.length){
			return str;
		} else {
			arr[j] = (char)count;
		}
		return new String(arr, 0, ++j);
	}
	
	public static String compressStr2(String str) {
		String newstr = "";
		int count = 0;
		newstr = newstr + str.charAt(0);
		for (int i = 0; i < str.length(); i++) {
			if (newstr.charAt(newstr.length() - 1) != str.charAt(i)) {
				if (newstr.length() >= str.length()){
					return str;
				} 
				newstr = newstr + count;
				count = 1;
				newstr = newstr + str.charAt(i);
			} else {
				count++;
			}
		}
		newstr = newstr + count;
		if (newstr.length() > str.length()) {
			return str;
		}

		return newstr;
	}
	public static void main(String[] args) {
		System.out.println(Compress.compressStr1(args[0]));
		System.out.println(Compress.compressStr2(args[0]));
	}
}
