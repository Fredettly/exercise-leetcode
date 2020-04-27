package test;

import java.util.Arrays;

/**
 * Created by xwx_ on 2020/4/24
 */
public class QSTest_I {
    public void QuickSort(int l, int r, int[] nums) {
        if (l < r) {
            int i = l, j = r, x = nums[l];
            while (i < j) {
                //找比x小的，放在低指针位
                while (i < j && nums[j] >= x)
                    j--;
                if (i < j)
                    nums[l++] = nums[j];
                //找比x大的，放在高指针位
                while (i < j && nums[i] < x)
                    i++;
                if (i < j)
                    nums[j--] = nums[i];
            }
            //左边比x小，右边比x大
            nums[i] = x;
            //递归
            QuickSort(l, i - 1, nums);
            QuickSort(i + 1, r, nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        new QSTest_I().QuickSort(0, 4, nums);
        System.out.println(Arrays.toString(nums));
    }
}
