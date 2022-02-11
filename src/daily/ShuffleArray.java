package daily;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 384. 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 *
 * 示例：
 *
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 *
 *
 * @author xwx
 * @since 2021/11/22
 */
public class ShuffleArray {
    int[] nums;
    int n;
    Random random = new Random();

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        n = this.nums.length;
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        int[] ans = this.nums.clone();
        for (int i = 0; i < n; i++) {
            swap(ans, i, i + random.nextInt(n - i));
        }
        return ans;
    }

    public void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

//    public static void main(String[] args) {
//        String str = "Hello how are you Contestant";
//        int k = 3;
////        StringBuilder ans = new StringBuilder();
////        String[] array = str.split(" ");
////        for (int i = 0; i < k && i < array.length; i++) {
////            ans.append(array[i]);
////            if (i < k - 1 && i < array.length - 1) {
////                ans.append(" ");
////            }
////        }
////        System.out.println(ans);
//        System.out.println(truncateSentence2(str, k));
//    }

    private static String truncateSentence(String str, int k) {
        StringBuilder ans = new StringBuilder();
        int len = str.length();
        for (int i = 0, count = 0; i < len && count < k; i++) {
            char c = str.charAt(i);
            if (c == ' ') count++;
            if (count < k) ans.append(c);
        }
        return ans.toString();
    }

    private static String truncateSentence2(String str, int k) {
        int len = str.length(), index = 0;
        while (index < len) {
            if (str.charAt(index) == ' ' && --k == 0) break;
            index++;
        }
        return str.substring(0, index);
    }

    private static int getNextKeyOperation(int[] nums, int current) {
        boolean isCurrent = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (!isCurrent && nums[i] == current) {
                isCurrent = true;
                continue;
            }
            if (isCurrent && nums[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] nums = {0, -1, 1, 2, 3, 4, -1, 5, 6, -1, 7, -1, 8, 9};
//        System.out.println(getNextKeyOperation(nums, -1));

        List<Integer> list = Arrays.asList(nums);
        System.out.println(list.subList(1, 5));

    }

    // [0,-1,1,2,3,4,-1,5,6,-1,7,-1,8,9]

}



















