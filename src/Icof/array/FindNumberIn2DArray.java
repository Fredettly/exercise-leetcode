package Icof.array;

/**
 * 二维数组中的查找
 */

public class FindNumberIn2DArray {

	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		int column = matrix.length - 1, row = 0;
		while (column >= 0 && row < matrix[0].length) {
			int num = matrix[column][row];
			if (num > target) column--;
			else if (num < target) row++;
			else return true;
		}
		return false;
	}

	public static void main(String[] args) {
		FindNumberIn2DArray solution = new FindNumberIn2DArray();
		int[][] matrix = {
							{1,   4,  7, 11, 15},
							{2,   5,  8, 12, 19},
							{3,   6,  9, 16, 22},
							{10, 13, 14, 17, 24},
							{18, 21, 23, 26, 30}
													};
		int target = 20;
		System.out.println(solution.findNumberIn2DArray(matrix, target));
	}
}