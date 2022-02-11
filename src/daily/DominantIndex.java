package daily;

/**
 * 747. 至少是其他数字两倍的最大数
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * <p>
 * 请你找出数组中的最大元素并检查它是否至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 大于数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：4 没有超过 3 的两倍大，所以返回 -1 。
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * 解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * nums 中的最大元素是唯一的
 *
 * @author xwx
 * @since 2022/1/13
 */
public class DominantIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 6};
        System.out.println(dominantIndex(nums));
    }

    /**
     * 找出数组中的最大元素并检查它是否至少是数组中每个其他数字的两倍 。
     * 如果是，则返回 最大元素的下标 ，否则返回 -1
     *
     * @param nums 数组
     * @return 下标
     */
    public static int dominantIndex(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        // 记录最大值和次大值下标
        int first = 0, second = -1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[first]) {
                second = first;
                first = i;
            } else if (second == -1 || nums[i] > nums[second]) {
                second = i;
            }
        }
        // 判断最大值是否至少是次大值的两倍
        return nums[first] >= nums[second] * 2 ? first : -1;
    }
}
