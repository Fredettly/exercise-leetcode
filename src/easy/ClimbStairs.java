/**
 * Created by xwx_ on 2020/2/23
 */
public class ClimbStairs {
//    public static int climbStairs(int i, int n) {
//        if (i > n) {
//            return 0;
//        }
//        if (i == n) {
//            return 1;
//        }
//        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
//    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }
}


