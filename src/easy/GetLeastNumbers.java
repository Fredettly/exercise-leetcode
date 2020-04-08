import java.util.Arrays;

/**
 * Created by xwx_ on 2020/3/20
 */

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 *
 * 限制：
 *
 *     0 <= k <= arr.length <= 10000
 *     0 <= arr[i] <= 10000
 *
 */


public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int low, int high, int k) {
        int j = partition(nums, low, high);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        return j > k ? quickSearch(nums, low, j - 1, k) : quickSearch(nums, j + 1, high, k);
    }

    private int partition(int[] nums, int low, int high) {
        int v = nums[low];
        int i = low, j = high + 1;
        while (true) {
            while (++i <= high && nums[i] < v) ;
            while (--j >= low && nums[j] > v) ;
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[low] = nums[j];
        nums[j] = v;
        return j;
    }

    public static void main(String[] args) {
        int arr1[] = {3, 2, 1};
        int arr2[] = {0, 1, 2, 1};
        int arr3[] = {5, 2, 4, 1, 7, 3, 6};
        int k1 = 2;
        int k2 = 1;
        int k3 = 3;
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        int[] res = getLeastNumbers.getLeastNumbers(arr1, k1);
        System.out.println(Arrays.toString(res));
    }
}
