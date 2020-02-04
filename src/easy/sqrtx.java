/**
 * Created by xwx_ on 2020/2/4
 */
public class sqrtx {
    public static int mySqrt(int a) {
        //牛顿法
//        long x = a;
//        while (x * x > a) {
//            x = (x + a / x) / 2;
//        }
//        return (int) x;
        //二分法
        int left = 0, right = a / 2 + 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == a) {
                return (int) mid;
            } else if (mid * mid < a) {
                left = (int) (mid + 1);
            } else {
                right = (int) (mid - 1);
            }
        }
        return right;
    }
    public static void main(String args[]){
        int a = 8;
        System.out.println(mySqrt(a));
    }
}

