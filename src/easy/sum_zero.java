import java.util.Arrays;

/**
 * Created by xwx_ on 2020/3/15
 */
public class sum_zero {
    public static int[] sumZero(int n) {
        int[] ans = new int[n];
        int sum = 0;
        for (int i = 1; i < n; i++) {
            ans[i] = i;
            sum -= i;
        }
        ans[0] = sum;
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(sumZero(n)));
    }
}
