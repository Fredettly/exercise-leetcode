/*
package test;

import java.util.Arrays;

*/
/**
 * Created by xwx_ on 2020/3/22
 *//*

public class QuickSort {
    public void solution(int[] s) {
        int l = 0;
        int r = s.length - 1;
        quickSort(s, l, r);
    }

    private void quickSort(int s[], int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    s[i++] = s[j];

                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quickSort(s, l, i - 1); // 递归调用
            quickSort(s, i + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] s = {4, 5, 6, 3, 2, 1};
//        int l = 0;
//        int r = 5;
        new QuickSort().solution(s);
        System.out.println(Arrays.toString(s));
    }
}
*/
