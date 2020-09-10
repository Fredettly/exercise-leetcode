package Icof.dp;

import java.util.Arrays;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */

public class GenerateLIS {

    /**
     * 动态规划数组
     * @param nums
     * @return
     */
	public int[] getdp(int[] nums) {
		int len = nums.length;
		if (len <= 1) {
			return nums;
		}
		int[] dp = new int[len];
		for (int i = 0; i < len; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp;
	}

    /**
     * 最长递增子数组长度
     * @param dp
     * @return
     */
	public int lengthOfLIS(int[] dp) {
		int res = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > res) {
				res = dp[i];
			}
		}
		return res;
	}

    /**
     * 生成最长递增子数组
     * @param nums
     * @param dp
     * @return
     */
	public int[] generateLIS(int[] nums, int[] dp) {
		int len = 0, index = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > len) {
				len = dp[i];
				index = i;
			}
		}
		int[] lis = new int[len];
		lis[--len] = nums[index];
		for (int j = index; j >= 0; j--) {
			if (nums[j] < nums[index] && dp[j] == dp[index] - 1) {
				lis[--len] = nums[j];
				index = j;
			}
		}
		return lis;
	}

    /**
     * 测试
     * @param agrs
     */
	public static void main(String[] agrs) {
		GenerateLIS solution = new GenerateLIS();
		int[] nums = {10,9,2,5,3,7,101,18};
		int[] dp = solution.getdp(nums);
		System.out.println("The dynamic programming array is " + Arrays.toString(dp));
		int length = solution.lengthOfLIS(dp);
		System.out.println("The length of longest increasing subsequence is " + length);
		int[] lis = solution.generateLIS(nums, dp);
		System.out.println("The longest of increasing subsequence is " + Arrays.toString(lis));
	}
}