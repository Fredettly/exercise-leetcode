package daily;

import java.util.Arrays;

/**
 * 1748. 唯一元素的和
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 * <p>
 * 请你返回 nums 中唯一元素的和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,2]
 * 输出：4
 * 解释：唯一元素为 [1,3] ，和为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：没有唯一元素，和为 0 。
 * 示例 3 ：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：15
 * 解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
 *
 * @author xwx
 * @since 2022/2/8
 */
public class SumOfUnique {

    /**
     * 排序、双指针
     * @param nums
     * @return
     */
    public static int sumOfUnique(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; ) {
            int j = i;
            while (j < len && nums[j] == nums[i]) {
                j++;
            }
            // 相邻的不相同的数字累加
            if (j - i == 1) {
                ans += nums[i];
            }
            i = j;
        }
        return ans;
    }

    /**
     * 计数数组
     */
    static int[] cnt = new int[110];

    /**
     *
     * @param nums
     * @return
     */
    public static int sumOfUnique2(int[] nums) {
        // 记录数字出现次数
        for (int n : nums) {
            cnt[n]++;
        }
        int ans = 0;
        // 累加出现一次的数字
        for (int i = 1; i <= 100; i++) {
            if (cnt[i] == 1) {
                ans += i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{14,83,63,42,15,87,61,37,30,95,99,100,45,30,5,2,29,65,15,71,12,17,61,81};
        System.out.println(sumOfUnique(nums));
    }
}
