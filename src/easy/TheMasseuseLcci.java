/**
 * Created by xwx_ on 2020/3/24
 */

/**
 * A popular masseuse receives a sequence of back-to-back appointment requests and is debating which ones to accept. She needs a break between appointments and therefore she cannot accept any adjacent requests. Given a sequence of back-to-back appoint­ ment requests, find the optimal (highest total booked minutes) set the masseuse can honor. Return the number of minutes.
 *
 * Note: This problem is slightly different from the original one in the book.
 *
 *
 *
 * Example 1:
 *
 * Input:  [1,2,3,1]
 * Output:  4
 * Explanation:  Accept request 1 and 3, total minutes = 1 + 3 = 4
 *
 * Example 2:
 *
 * Input:  [2,7,9,3,1]
 * Output:  12
 * Explanation:  Accept request 1, 3 and 5, total minutes = 2 + 9 + 1 = 12
 *
 * Example 3:
 *
 * Input:  [2,1,4,5,3,1,1,3]
 * Output:  12
 * Explanation:  Accept request 1, 3, 5 and 8, total minutes = 2 + 4 + 3 + 3 = 12
 *
 */


public class TheMasseuseLcci {
    public int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        TheMasseuseLcci solution = new TheMasseuseLcci();
//        int[] nums = {};
        int[] nums = {2, 1, 4, 5, 3, 1, 1, 3};
        int res = solution.massage(nums);
        System.out.println(res);
    }
}
