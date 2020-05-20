package draft;

import java.util.HashMap;

/**
 * Created by xwx_ on 2020/5/2
 */
public class DfPalindrome {
    public boolean isPalindrome(int num) {
        int x = num;
        if (num == 0) return true;
        if (num < 0 || num % 10 == 0) return false;
        int temp = 0;
        while (x != 0) {
            temp = temp * 10 + x % 10;
//            temp *= 10;
//            temp += x % 10;
            x /= 10;
        }
        return temp == num;
    }

    public static void main(String[] args) {
        DfPalindrome sol = new DfPalindrome();
        new HashMap<>();
        System.out.println(sol.isPalindrome(1));
    }
}
