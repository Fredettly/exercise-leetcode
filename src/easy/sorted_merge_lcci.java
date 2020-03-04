import java.util.Arrays;

/**
 * Created by xwx_ on 2020/3/3
 */
public class sorted_merge_lcci {
    public static int[] merge(int[] A, int m, int[] B, int n) {
        int k = m + n - 1, i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] < B[j]) {
                A[k--] = B[j--];
            } else {
                A[k--] = A[i--];
            }
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 0, 0, 0};
        int m = 3;
        int[] B = {1, 5, 6};
        int n = 3;
        System.out.println(Arrays.toString(merge(A, m, B, n)));
    }

}
