import java.util.Random;

public class SetZero {
	private int[][] matrix;
	
	public SetZero(int M, int N) {
		Random r = new Random();
		matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = r.nextInt(7);
			}
		}
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				s = s + matrix[i][j] + " ";
			}
			s = s + "\n";
		}
		return s;
	}
	
	public void bruteForce() {
		boolean[] col = new boolean[matrix[0].length];
		boolean[] row = new boolean[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					col[j] = true;
					row[i] = true;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] || col[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		SetZero test = new SetZero(5, 6);
		System.out.println(test);
		test.bruteForce();
		System.out.println(test);
	}
}
