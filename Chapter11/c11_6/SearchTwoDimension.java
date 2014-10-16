public class SearchTwoDimension {
    private int[][] array = {{15, 20, 40, 85}, {20, 35, 80, 95}, {30, 55, 95, 105}, {40, 80, 100, 120}};

    public boolean find1(int elem) {
	for (int i = 0; i < array.length; i++) {
	    //	    System.out.println("row: " + i);
	    if (binarySearch(array[i], elem)) {
		return true;
	    }
	}
	return false;
    }

    private boolean binarySearch(int[] arr, int elem) {
	int low = 0;
	int high = arr.length - 1;
	while (low <= high) {
	    int mid = (low + high) / 2;
	    //	    System.out.println(mid);
	    if (arr[mid] == elem) {
		return true;
	    }
	    if (arr[mid] < elem) {
		low = mid + 1;
	    } else {
		high = mid - 1;
	    }
	}
	return false;
    }

    public boolean find2(int elem) {
	int row = 0;
	int col = array[0].length - 1;
	while (row < array.length && col >= 0) {
	    if (elem == array[row][col]) {
		return true;
	    }
	    if (elem > array[row][col]) {
		row++;
	    } else {
		col--;
	    }
	}
	return false;
    }

    public boolean find3(int elem) {
	Coordinate origin = new Coordinate(0, 0);
	Coordinate dest = new Coordinate(array.length - 1, array[0].length - 1);
	return findElement(array, origin, dest, elem) != null;
    }

    public Coordinate findElement(int[][] matrix, Coordinate origin, Coordinate dest, int x) {
	if (!origin.inbounds(matrix) || !dest.inbounds(matrix)) {
	    return null;
	}
	if (matrix[origin.row][origin.column] == x) {
	    return origin;
	} else if (!origin.isBefore(dest)) {
	    return null;
	}

	Coordinate start = (Coordinate) origin.clone();
	int diagDist = Math.min(dest.row - origin.row, dest.column - origin.column);
	Coordinate end = new Coordinate(start.row + diagDist, start.column + diagDist);
	Coordinate p = new Coordinate(0, 0);

	while (start.isBefore(end)) {
	    p.setToAverage(start, end);
	    if (x > matrix[p.row][p.column]) {
		start.row = p.row + 1;
		start.column = p.column + 1;
	    } else {
		end.row = p.row - 1;
		end.column = p.column - 1;
	    }
	}
	return partitionAndSearch(matrix, origin, dest, start, x);
    }

    public Coordinate partitionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest, Coordinate pivot, int elem) {
	Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.column);
	Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.column - 1);
	Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.column);
	Coordinate upperRightDest = new Coordinate(pivot.row - 1, dest.column);

	Coordinate lowerLeft = findElement(matrix, lowerLeftOrigin, lowerLeftDest, elem);
	if (lowerLeft == null) {
	    return findElement(matrix, upperRightOrigin, upperRightDest, elem);
	}
	return lowerLeft;
    }

    public static void main(String[] args) {
	SearchTwoDimension test = new SearchTwoDimension();
	System.out.println(test.find1(55));
	System.out.println(test.find2(55));
	System.out.println(test.find3(55));
    }
}

class Coordinate implements Cloneable {
    int row;
    int column;

    public Coordinate(int row, int column) {
	this.row = row;
	this.column = column;
    }

    public boolean inbounds(int[][] matrix) {
	return row >= 0 && column >= 0 && row < matrix.length && column < matrix[0].length;
    }

    public boolean isBefore(Coordinate p) {
	return row <= p.row && column <= p.column;
    }

    public Object clone() {
	return new Coordinate(row, column);
    }

    public void setToAverage(Coordinate min, Coordinate max) {
	row = (min.row + max.row) / 2;
	column = (min.column + max.column) / 2;
    }

}
