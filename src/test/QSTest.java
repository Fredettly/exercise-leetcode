package test;

import java.util.Arrays;

/**
 * Created by xwx_ on 2020/4/16
 */
public class QSTest {
    public void solution(int[] a) {
        int l = 0;
        int r = a.length - 1;
        quickSort(a, l, r);
    }

    private void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = a[l];
            while (i < j) {
                while (i < j && a[j] >= x)
                    j--;
                if (i < j)
                    a[i++] = a[j];
                while (i < j && a[i] < x)
                    i++;
                if (i < j)
                    a[j--] = a[i];
            }
            a[i] = x;
            quickSort(a, l, i - 1);
            quickSort(a, i + 1, r);
        }
    }


    public static void main(String[] args) {
        int[] nums = {0, 3, 2, 8, 4, 9, 0, 3, 6};
        new QSTest().solution(nums);
        System.out.println(Arrays.toString(nums));
    }
}
