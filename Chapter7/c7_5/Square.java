public class Square {
    private Point lu;
    private Point ld;
    private Point ru;
    private Point rd;

    public Square(Point a, Point b, Point c, Point d) {
	lu = a;
	ld = b;
	ru = c;
	rd = d;
    }

    public Point middle() {
	return new Point((lu.X() + rd.X()) / 2, (lu.Y() + rd.Y()) / 2);
    }

    public Line cutHalf(Square s2) {
	return new Line(middle(), s2.middle());
    }

    public static void main(String[] args) {
	Square test = new Square(new Point(0, 1), new Point(0, 0), new Point(1, 1), new Point(1, 0));
	System.out.println(test.cutHalf(new Square(new Point(1, 2), new Point(1, 1), new Point(2, 2), new Point(2, 1))));
    }
}

class Point {
    private double x;
    private double y;

    Point(double x, double y) {
	this.x = x;
	this.y = y;
    }

    double X() {
	return x;
    }

    double Y() {
	return y;
    }
}


class Line {
    private double slope;
    private double intery;
    private double e = 0.000001;

    Line(double slope, double intery) {
	this.slope = slope;
	this.intery = intery;
    }

    Line(Point a, Point b) {
	if (Math.abs(a.X() - b.X()) < e) {
	    //	    System.out.println(a.X() + " " + b.X());
	    //	    System.out.println("hello1");
	    slope = Double.MAX_VALUE;
	    intery = Double.MIN_VALUE;
	} else if (Math.abs(a.Y() - b.Y()) < e) {
	    slope = 0;
	    intery = a.Y();
	    //	    System.out.println("======");
	} else {
	    slope = (a.Y() - b.Y()) / (a.X() - b.X());
	    intery = a.Y() - a.X() * slope;
	}
	
    }

    public String toString() {
	return "y = " + slope + "x + " + intery; 
    }

}
