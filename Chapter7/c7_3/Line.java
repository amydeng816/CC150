public class Line {
    private double slope;
    private double interY;
    private static double limit = 0.000001;

    public Line(double slope, double interY) {
	this.slope = slope;
	this.interY = interY;
    }

    public boolean checkIntersect(Line l2) {
	return Math.abs(slope -  l2.slope) < limit || Math.abs(interY - l2.interY) < limit;
    }

    public static void main(String[] args) {
	Line l1 = new Line(0.5, 1);
	Line l2 = new Line(0.6, 1.00000001);
	System.out.println(l1.checkIntersect(l2));
    }
}
