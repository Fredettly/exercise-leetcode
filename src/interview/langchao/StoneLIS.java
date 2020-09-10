/*
 * 沙滩按照线型摆放着n个大小不一的球形石头，已知第i个石头的半径为ri，且不存在两个石头有相同的半径。
 * 为了使石头的摆放更加美观，现要求摆放的石头的半径从左往右依次递增。因此，需要对一些石头进行移动，
 * 每次操作可以选择一个石头，并把它放在剩下n−1个石头在最左边或最右边。
 * 问最少需要操作多少次才能将这n个石头的半径变成升序？
 * 
 * 输入
 * 第一行一个整数n，表示石头的个数。(1 <= n <= 100000)
 * 第二行n个整数，表示从左往右石头的半径r1，r2，…，rn。(1 <= ri <= n)，
 * 且保证不存在两个不同的石头拥有相同的半径。
 * 
 * 输出
 * 最少操作次数样例输入
 * 5
 * 4 1 2 5 3
 * 
 * 样例输出
 * 2
 * 
 * Created by xwx_ on 2020/9/5
 * 
 */
public class StoneLIS {
	public int LeastOperation(int[] stones) {
		int len = stones.length;
		int[] dp = new int[len];
		for (int i = 0; i < len; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (stones[i] > stones[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		int res = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > res)
				res = dp[i];
		}
		return dp.length - res;
	}
	public static void main(String[] args) {
		StoneLIS stone = new StoneLIS();
		int[] nums = {4,1,2,5,3};
		System.out.println(stone.LeastOperation(nums));
	}
}