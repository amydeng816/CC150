import java.util.*;

public class FindBestLine {

    public static Line findLine(LinkedList<Point> l) {
	Hashtable<Line, Integer> h = new Hashtable<Line, Integer>();
	for (int i = 0; i < l.size() - 1; i++) {
	    Point p1 = l.get(i);
	    for (int j = i + 1; j < l.size(); j++) {
		Line temp = new Line(p1, l.get(j));
		if (h.containsKey(temp)) {
		    h.put(temp, (h.get(temp) + 1));
		} else {
		    h.put(temp, 1);
		}
	    }
	}
	System.out.println(h);
	Line maxLine = null;
	int max = -1;
	Set<Line> lines = h.keySet();
	for (Line ll : lines) {
	    if (h.get(ll) > max) {
		maxLine = ll;
		max = h.get(ll);
	    }
	}
	return maxLine;
    }
    public static void main(String[] args) {
	Random r = new Random();
	LinkedList<Point> l = new LinkedList<Point>();
	for (int i = 0; i < 10; i++) {
	    l.add(new Point(r.nextInt(10), r.nextInt(10)));
	    System.out.println(l.get(i));
	}

	System.out.println(FindBestLine.findLine(l));
    }


}

class Point {
    private double x;
    private double y;
    private double e = 0.000001;

    Point(double x, double y) {
	this.x = x;
	this.y = y;
    }

    public boolean equals(Object o) {
	return Math.abs(x - ((Point)o).X()) < e && Math.abs(y - ((Point)o).Y()) < e;
    }

    // public boolean equals(Point o) {
    // 	return Math.abs(x - o.X()) < e && Math.abs(y - o.Y()) < e;
    // }

    public double X() {
	return x;
    }

    public double Y() {
	return y;
    }

    public int hashCode() {
	return 0;
    }
    
    public String toString() {
	return x + " " + y;
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

    public int hashCode() {
	return 1;
    }

    public double Slope() {
	return slope;
    }

    public double InterY() {
	return intery;
    }

    public boolean equals(Object o) {
	return Math.abs(slope - ((Line)o).Slope()) < e && Math.abs(intery - ((Line)o).InterY()) < e;
    }

    public String toString() {
	return "y = " + slope + "x + " + intery; 
    }

}
