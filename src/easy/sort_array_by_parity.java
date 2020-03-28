/**
 * Created by xwx_ on 2020/3/28
 */

import java.util.Arrays;

/**
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 *
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *
 *
 *
 * 提示：
 *
 *     1 <= A.length <= 5000
 *     0 <= A[i] <= 5000
 *
 *
 */



public class sort_array_by_parity {
    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        if (A == null || len == 1) {
            return A;
        }
        int[] even = new int[len];
        int[] odd = new int[len];
        int i = 0, j = 0;
        for (int a : A) {
            if (a % 2 == 0) {
                even[i] = a;
                i++;
            } else {
                odd[j] = a;
                j++;
            }
        }
        int[] res = new int[len];
        System.arraycopy(even, 0, res, 0, i);
        System.arraycopy(odd, 0, res, i, j);
        return res;
    }

    public static void main(String[] args) {
//        int[] A = {3,1,2,4};
        int[] A = {3,1,2,4,5,9,12,1};
        sort_array_by_parity solution = new sort_array_by_parity();
        int[] res = solution.sortArrayByParity(A);
        System.out.println(Arrays.toString(res));
    }
}
