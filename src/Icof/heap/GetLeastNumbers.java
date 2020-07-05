package Icof.heap;

import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Arrays;
public class GetLeastNumbers {

	public int[] getLeastNumbers(int[] nums, int k) {
		int len = nums.length;
		Arrays.sort(nums);
		return Arrays.copyOf(nums, k);
	}

	public int[] getLeastNumbers2(int[] nums, int k) {
		if (k == 0 || nums.length == 0) {
			return new int[0];
		}
		Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
		for (int num : nums) {
			if (pq.size() < k) {
				pq.offer(num);
			} else if (num < pq.peek()) {
				pq.poll();
				pq.offer(num);
			}
		}
		int[] res = new int[pq.size()];
		int index = 0;
		for (int num : pq) {
			res[index++] = num;
		}
		return res;
	}

	public static void main(String[] args) {
		GetLeastNumbers solution = new GetLeastNumbers();
		int[] nums = {4, 1, 7, 8, 3, 11};
		int k = 4;
		int[] res = solution.getLeastNumbers2(nums, k);
		System.out.println(Arrays.toString(res));
	}
}