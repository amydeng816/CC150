public class Question {
    private static RankNode root = null;

    public static void track(int number) {
	if (root == null) {
	    root = new RankNode(number);
	} else {
	    root.insert(number);
	}
    }

    public static int getRankOfNumber(int number) {
	return root.getRank(number);
    }

    public static void main(String[] args) {
	Question test = new Question();
	test.track(20);
	System.out.println(test.getRankOfNumber(20));
	test.track(15);
	System.out.println(test.getRankOfNumber(20));
	test.track(25);
	System.out.println(test.getRankOfNumber(20));
	test.track(10);
	System.out.println(test.getRankOfNumber(20));
	test.track(5);
	System.out.println(test.getRankOfNumber(20));
	test.track(13);
	System.out.println(test.getRankOfNumber(10));
	test.track(23);
	System.out.println(test.getRankOfNumber(5));
	test.track(24);
	System.out.println(test.getRankOfNumber(24));

    }
}
