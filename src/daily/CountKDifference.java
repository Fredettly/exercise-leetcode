package daily;

/**
 * TODO description
 *
 * @author xwx
 * @since 2022/2/9
 */
public class CountKDifference {

    public static int countKDifference(int[] nums, int k) {
        int[] cnts = new int[110];
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            if (t - k >= 1) {
                ans += cnts[t - k];
            }
            if (t + k <= 100) {
                ans += cnts[t + k];
            }
            cnts[t]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 4};
        System.out.println(countKDifference(nums, 2));
    }
}
