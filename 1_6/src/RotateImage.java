import java.util.Random;


public class RotateImage {
	private int[][] matrix;
	
	public RotateImage(int N) {
		Random r = new Random();
		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
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
	
	public void rotate() {
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = i; j < matrix.length - 1 - i; j++) {
				int temp = matrix[matrix.length - j - 1][i];
				matrix[matrix.length - j - 1][i] = matrix[matrix.length - i - 1][matrix.length - j - 1];
				matrix[matrix.length - i - 1][matrix.length - j - 1] = matrix[j][matrix.length - i - 1];
				matrix[j][matrix.length - i - 1] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		RotateImage test = new RotateImage(6);
		System.out.println(test);
		test.rotate();
		System.out.println("-----------------");
		System.out.println(test);
	}
}
