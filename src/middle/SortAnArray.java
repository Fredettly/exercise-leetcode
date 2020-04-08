package middle;

/**
 * Created by xwx_ on 2020/3/31
 */

import java.util.Arrays;

/**
 * Given an array of integers nums, sort the array in ascending order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 *
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 *
 *
 *
 * Constraints:
 *
 *     1 <= nums.length <= 50000
 *     -50000 <= nums[i] <= 50000
 *
 *
 *
 */


public class SortAnArray {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        if (len <= 1)return nums;
        qSort(nums, 0, len - 1);
        return nums;
    }

    private void qSort(int[] nums, int l, int r) {
        if (l < r) {
            int n = l, m = r, k = nums[l];
            while (n < m) {
                while (n < m && nums[m] >= k)
                    m--;
                if (n < m)
                    nums[n++] = nums[m];
                while (n < m && nums[n] < k)
                    n++;
                if (n < m)
                    nums[m--] = nums[n];
            }
            nums[n] = k;
            qSort(nums, l, n - 1);
            qSort(nums, n + 1, r);
        }
    }

    public static void main(String[] args) {
        SortAnArray solution = new SortAnArray();
        int[] nums = {5, 1, 1, 2, 0, 0};
        int[] res = solution.sortArray(nums);
        System.out.println(Arrays.toString(res));
    }


}
