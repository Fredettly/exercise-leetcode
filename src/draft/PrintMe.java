public class PrintMe {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			if (i > 0) {
				System.out.println("");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("printMyself!");
			}
		}
	}
	public boolean findNumber(int[][] matrix, int target) {
		int column = matrix.length - 1, row = 0;
		while (column >= 0 && row < matrix[0].length) {
			int num = matrix[column][row];
			if (num > target) column--;
			else if (num < target) row++;
			else return true;
		}
		return false;
	}
}