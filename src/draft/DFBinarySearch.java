import java.util.Arrays;

public class DFBinarySearch {
	public static int rank(int[] nums, int key) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (key < nums[mid]) {
				high = mid - 1;
			}
			else if (key > nums[mid]) {
				low = mid + 1;
			}
			else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {1, 3, 4, 6, 7, 9, 12};
		int key = 4;
		System.out.println(rank(nums, key));
	}
}