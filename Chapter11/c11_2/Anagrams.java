import java.util.Random;
import java.util.Hashtable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;

public class Anagrams {
    private String[] strs = {"hello", "oehll", "hlleo", "miao", "mia", "oami", "ana", "aan", "out", "snake", "eansk"};

    private void shuffle(String[] s) {
	Random r = new Random();
	int N = s.length;
	for (int i = 1; i < N; i++) {
	    int pos = r.nextInt(i);
	    String temp = s[i];
	    s[i] = s[pos];
	    s[pos] = temp;
	}
    }

    public void print(String[] s) {
	for (int i = 0; i < s.length; i++) {
	    System.out.print(s[i] + " ");
	}
	System.out.println();
    }

    public void sort() {
	shuffle(strs);
	print(strs);
	Hashtable<String, LinkedList> h = new Hashtable<String, LinkedList>();
	for (int i = 0; i < strs.length; i++) {
	    char[] chars = (strs[i]).toCharArray();
	    Arrays.sort(chars);
	    String temp = new String(chars);
	    if (!h.containsKey(temp)) {
		h.put(temp, new LinkedList<String>());
	    }
	    h.get(temp).add(strs[i]);
	}
	int pos = 0;
	while (pos < strs.length) {
	    Set<String> keys = h.keySet();
	    for (String key : keys) {
		LinkedList<String> l = h.get(key);
		for (String s : l) {
		    strs[pos++] = s;
		}
	    }
	}
	print(strs);
    }
    
    public static void main(String[] args) {
	Anagrams test = new Anagrams();
	test.sort();
    }
}
